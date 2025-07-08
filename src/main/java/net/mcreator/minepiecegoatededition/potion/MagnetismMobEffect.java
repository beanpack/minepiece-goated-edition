package net.mcreator.minepiecegoatededition.potion;

public class MagnetismMobEffect extends Effect {
	public MagnetismMobEffect() {
		super(EffectType.NEUTRAL, -1);
	}

	@Override
	public List<ItemStack> getCurativeItems() {
		ArrayList<ItemStack> cures = new ArrayList<ItemStack>();
		return cures;
	}

	@Override
	public void performEffect(LivingEntity entity, int amplifier) {
		MagnetismEffectOnTickProcedure.execute();
	}

	@Override
	public boolean isReady(int duration, int amplifier) {
		return true;
	}
}