package net.mcreator.minepiecegoatededition.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

public class DarkRootPlantEffectProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity && !((LivingEntity) entity).world.isRemote())
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WITHER, 40, 1));
	}
}
