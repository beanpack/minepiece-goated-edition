package net.mcreator.minepiecegoatededition.procedures;

import net.minecraft.entity.Entity;

public class TestOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!entity.isOnGround()) {
			entity.addVelocity(0, (-1.5), 0);
		}
	}
}
