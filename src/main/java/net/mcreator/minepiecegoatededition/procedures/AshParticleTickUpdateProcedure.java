package net.mcreator.minepiecegoatededition.procedures;

import net.minecraftforge.eventbus.api.Event;

public class AshParticleTickUpdateProcedure {
	public static void execute(IWorld world, Entity entity) {
		if (entity == null)
			return;
		world.addParticle(ParticleTypes.SMOKE, (entity.getPosX()), (entity.getPosY()), (entity.getPosZ()), 0, 0.1, 0);
	}
}