
package net.mcreator.minepiecegoatededition.item;

public class DarkRootFruitItem extends Item {
	public DarkRootFruitItem() {
		super(new Item.Properties().group(MinepieceGoatedEditionModTabs.TAB_MINEPIECE_CREATIVE_TAB).maxStackSize(1).rarity(Rarity.EPIC).food((new Food.Builder()).hunger(2).saturation(0.3f).setAlwaysEdible().build()));
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
		ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
		double x = entity.getPosX();
		double y = entity.getPosY();
		double z = entity.getPosZ();
		DarkRootRemoveProcedure.execute(entity);
		return retval;
	}
}