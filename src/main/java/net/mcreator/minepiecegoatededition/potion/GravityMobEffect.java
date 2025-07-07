package net.mcreator.minepiecegoatededition.potion;

import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effect;
import net.minecraft.entity.LivingEntity;

import net.mcreator.minepiecegoatededition.procedures.TestOnEffectActiveTickProcedure;

public class GravityMobEffect extends Effect {
	public GravityMobEffect() {
		super(EffectType.NEUTRAL, -1);
	}

	@Override
	public void performEffect(LivingEntity entity, int amplifier) {
		TestOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isReady(int duration, int amplifier) {
		return true;
	}
}
