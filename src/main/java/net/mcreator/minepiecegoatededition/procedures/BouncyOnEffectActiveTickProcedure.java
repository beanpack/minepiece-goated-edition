package net.mcreator.minepiecegoatededition.procedures;

import net.minecraft.entity.Entity;

public class BouncyOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.isOnGround()) {
			entity.addVelocity(0, 1, 0);
		}
	}
}
