package net.mcreator.minepiecegoatededition.procedures;

import net.minecraftforge.eventbus.api.Event;

public class BouncyOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.isOnGround()) {
			entity.addVelocity(0, 1, 0);
		}
	}
}