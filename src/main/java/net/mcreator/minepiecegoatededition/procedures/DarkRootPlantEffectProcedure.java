package net.mcreator.minepiecegoatededition.procedures;

import net.minecraftforge.eventbus.api.Event;

public class DarkRootPlantEffectProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity && !((LivingEntity) entity).world.isRemote())
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WITHER, 40, 1));
	}
}