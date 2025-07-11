
package net.mcreator.minepiecegoatededition.block;

public class DarkRootBlock extends SugarCaneBlock implements IGrowable {
	public DarkRootBlock() {
		super(Block.Properties.create(Material.PLANTS, MaterialColor.GRAY).tickRandomly().sound(SoundType.PLANT).zeroHardnessAndResistance().setLightLevel(s -> 1).doesNotBlockMovement());
	}

	@OnlyIn(Dist.CLIENT)
	public static void registerRenderLayer() {
		RenderTypeLookup.setRenderLayer(MinepieceGoatedEditionModBlocks.DARK_ROOT.get(), RenderType.getCutout());
	}

	@Override
	public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
		return 100;
	}

	@Override
	public Block.OffsetType getOffsetType() {
		return Block.OffsetType.NONE;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
		return 60;
	}

	@Override
	public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos, PlayerEntity player) {
		return new ItemStack(MinepieceGoatedEditionModItems.DELETED_MOD_ELEMENT.get());
	}

	@Override
	public boolean isValidPosition(BlockState blockstate, IWorldReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.down();
		BlockState groundState = worldIn.getBlockState(blockpos);
		return groundState.isIn(this) || groundState.isIn(Blocks.SOUL_SAND);
	}

	@Override
	public PlantType getPlantType(IBlockReader world, BlockPos pos) {
		return PlantType.NETHER;
	}

	@Override
	public void randomTick(BlockState blockstate, ServerWorld world, BlockPos pos, Random random) {
		if (world.isAirBlock(pos.up())) {
			int i = 1;
			for (; world.getBlockState(pos.down(i)).getBlock() == this; ++i);
			if (i < 1) {
				int j = blockstate.get(AGE);
				if (ForgeHooks.onCropsGrowPre(world, pos, blockstate, true)) {
					if (j == 15) {
						world.setBlockState(pos.up(), getDefaultState());
						world.setBlockState(pos, blockstate.with(AGE, 0), 4);
					} else {
						world.setBlockState(pos, blockstate.with(AGE, j + 1), 4);
					}
				}
			}
		}
	}

	@Override
	public void onEntityCollision(BlockState blockstate, World world, BlockPos pos, Entity entity) {
		super.onEntityCollision(blockstate, world, pos, entity);
		DarkRootPlantEffectProcedure.execute(entity);
	}

	@Override
	public boolean removedByPlayer(BlockState blockstate, World world, BlockPos pos, PlayerEntity entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.removedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		AshParticleTickUpdateProcedure.execute(world, entity);
		return retval;
	}

	@Override
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState blockstate, boolean clientSide) {
		return true;
	}

	@Override
	public boolean canUseBonemeal(World world, Random random, BlockPos pos, BlockState blockstate) {
		return true;
	}

	@Override
	public void grow(ServerWorld world, Random random, BlockPos pos, BlockState blockstate) {
	}
}