package net.mcreator.minepiecegoatededition.potion;

import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effect;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;

import net.mcreator.minepiecegoatededition.procedures.BouncyOnEffectActiveTickProcedure;

import java.util.List;
import java.util.ArrayList;

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
