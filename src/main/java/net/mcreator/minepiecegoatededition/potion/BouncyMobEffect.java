package net.mcreator.minepiecegoatededition.potion;

public class BouncyMobEffect extends Effect {
	public BouncyMobEffect() {
		super(EffectType.NEUTRAL, -1);
	}

	@Override
	public List<ItemStack> getCurativeItems() {
		ArrayList<ItemStack> cures = new ArrayList<ItemStack>();
		return cures;
	}

	@Override
	public void performEffect(LivingEntity entity, int amplifier) {
		BouncyOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isReady(int duration, int amplifier) {
		return true;
	}
}