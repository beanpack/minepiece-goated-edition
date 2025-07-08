/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minepiecegoatededition.init;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.RegistryObject;

import net.minecraft.particles.ParticleType;
import net.minecraft.particles.BasicParticleType;

import net.mcreator.minepiecegoatededition.MinepieceGoatedEditionMod;

public class MinepieceGoatedEditionModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, MinepieceGoatedEditionMod.MODID);
	public static final RegistryObject<BasicParticleType> SPARK_PARTICLE = REGISTRY.register("spark_particle", () -> new BasicParticleType(true));
	public static final RegistryObject<BasicParticleType> THUNDER_PARTICLE = REGISTRY.register("thunder_particle", () -> new BasicParticleType(true));
	public static final RegistryObject<BasicParticleType> FLAME_PARTICLE = REGISTRY.register("flame_particle", () -> new BasicParticleType(true));
	public static final RegistryObject<BasicParticleType> WATER_PARTICLE = REGISTRY.register("water_particle", () -> new BasicParticleType(true));
}
