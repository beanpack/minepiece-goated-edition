/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minepiecegoatededition.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;

import net.mcreator.minepiecegoatededition.client.particle.ThunderParticleParticle;
import net.mcreator.minepiecegoatededition.client.particle.SparkParticleParticle;
import net.mcreator.minepiecegoatededition.client.particle.FlameParticleParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MinepieceGoatedEditionModParticles {
	@SubscribeEvent
	public static void registerParticles(ParticleFactoryRegisterEvent event) {
		Minecraft.getInstance().particles.registerFactory(MinepieceGoatedEditionModParticleTypes.SPARK_PARTICLE.get(), SparkParticleParticle::factory);
		Minecraft.getInstance().particles.registerFactory(MinepieceGoatedEditionModParticleTypes.THUNDER_PARTICLE.get(), ThunderParticleParticle::factory);
		Minecraft.getInstance().particles.registerFactory(MinepieceGoatedEditionModParticleTypes.FLAME_PARTICLE.get(), FlameParticleParticle::factory);
	}
}
