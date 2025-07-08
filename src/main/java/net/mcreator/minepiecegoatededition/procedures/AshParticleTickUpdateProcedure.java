package net.mcreator.minepiecegoatededition.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.Entity;

public class AshParticleTickUpdateProcedure {
	public static void execute(IWorld world, Entity entity) {
		if (entity == null)
			return;
		world.addParticle(ParticleTypes.SMOKE, (entity.getPosX()), (entity.getPosY()), (entity.getPosZ()), 0, 0.1, 0);
	}
}
