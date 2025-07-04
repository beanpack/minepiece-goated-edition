package net.mcreator.minepiecegoatededition.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.Entity;

import java.util.stream.Collectors;
import java.util.Comparator;

public class YoruFxSlashProcedure {
	public static void execute(IWorld world, Entity entity) {
		if (entity == null)
			return;
		double radianArc = 0;
		double d = 0;
		double verticalOffset = 0;
		double sign = 0;
		double rollAngle = 0;
		double horizontalOffsetDir = 0;
		double i = 0;
		double dMajor = 0;
		double horizontalOffsetMag = 0;
		double circleDistanceConstant = 0;
		double radianSteps = 0;
		double arcStart = 0;
		entity.getPersistentData().putDouble("ticksAlive", (entity.getPersistentData().getDouble("ticksAlive") + 1));
		if (entity.getPersistentData().getDouble("ticksAlive") < 40) {
			circleDistanceConstant = 3;
			rollAngle = 135;
			horizontalOffsetMag = 0;
			horizontalOffsetDir = 0;
			verticalOffset = 0;
			dMajor = circleDistanceConstant;
			d = circleDistanceConstant * Math.cos(Math.toRadians(rollAngle));
			i = ((-1) * Math.PI) / 4;
			radianArc = (1 * Math.PI) / 2;
			radianSteps = (1 * Math.PI) / 64;
			arcStart = Math.toRadians(entity.rotationYaw + 90);
			if (world instanceof World) {
				if (!((World) world).isRemote()) {
					((World) world).playSound(null, new BlockPos(entity.getPosX(), entity.getPosY(), entity.getPosZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundCategory.NEUTRAL, (float) 0.5,
							(float) 0.5);
				} else {
					((World) world).playSound((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundCategory.NEUTRAL, (float) 0.5, (float) 0.5,
							false);
				}
			}
			while (i <= radianArc) {
				if (0 > Math.sin(i)) {
					sign = -1;
				} else {
					sign = 1;
				}
				if (world instanceof ServerWorld)
					((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE,
							(dMajor * Math.cos(i) * Math.cos(arcStart) - d * Math.sin(i) * Math.sin(arcStart) + entity.getPosX() + horizontalOffsetMag * Math.sin(Math.toRadians(entity.rotationYaw + 180 + horizontalOffsetDir))),
							(sign * Math.sqrt(Math.abs(Math.sin(Math.toRadians(rollAngle))) * (Math.pow(dMajor, 2) - Math.pow(dMajor * Math.cos(i), 2))) + entity.getPosY() + 1 + verticalOffset),
							(dMajor * Math.cos(i) * Math.sin(arcStart) + d * Math.sin(i) * Math.cos(arcStart) + entity.getPosZ() - horizontalOffsetMag * Math.cos(Math.toRadians(entity.rotationYaw + 180 + horizontalOffsetDir))), 1, 0, 0, 0, 0);
				{
					final Vector3d _center = new Vector3d(
							(dMajor * Math.cos(i) * Math.cos(arcStart) - d * Math.sin(i) * Math.sin(arcStart) + entity.getPosX() + horizontalOffsetMag * Math.sin(Math.toRadians(entity.rotationYaw + 180 + horizontalOffsetDir))),
							(sign * Math.sqrt(Math.abs(Math.sin(Math.toRadians(rollAngle))) * (Math.pow(dMajor, 2) - Math.pow(dMajor * Math.cos(i), 2))) + entity.getPosY() + 1 + verticalOffset),
							(dMajor * Math.cos(i) * Math.sin(arcStart) + d * Math.sin(i) * Math.cos(arcStart) + entity.getPosZ() - horizontalOffsetMag * Math.cos(Math.toRadians(entity.rotationYaw + 180 + horizontalOffsetDir))));
					for (Entity entityiterator : world.getLoadedEntitiesWithinAABB(Entity.class, new AxisAlignedBB(_center, _center).grow(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.getDistanceSq(_center)))
							.collect(Collectors.toList())) {
						if (!(entity == entityiterator)) {
							entity.attackEntityFrom(DamageSource.GENERIC, 13);
							if (i < 1) {
								if (world instanceof World) {
									if (!((World) world).isRemote()) {
										((World) world).playSound(null, new BlockPos(entityiterator.getPosX(), entityiterator.getPosY(), entityiterator.getPosZ()),
												ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("minepiece_goated_edition:swordslice-audio")), SoundCategory.NEUTRAL, (float) 0.5, (float) 0.5);
									} else {
										((World) world).playSound((entityiterator.getPosX()), (entityiterator.getPosY()), (entityiterator.getPosZ()),
												ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("minepiece_goated_edition:swordslice-audio")), SoundCategory.NEUTRAL, (float) 0.5, (float) 0.5, false);
									}
								}
							}
						}
					}
				}
				i = i + radianSteps;
			}
		} else {
			entity.attackEntityFrom(DamageSource.GENERIC, 999);
		}
	}
}
