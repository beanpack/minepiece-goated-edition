/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minepiecegoatededition.init;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.RegistryObject;

import net.minecraft.util.SoundEvent;
import net.minecraft.util.ResourceLocation;

import net.mcreator.minepiecegoatededition.MinepieceGoatedEditionMod;

public class MinepieceGoatedEditionModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MinepieceGoatedEditionMod.MODID);
	public static final RegistryObject<SoundEvent> SWORDSLICE_AUDIO = REGISTRY.register("swordslice-audio", () -> new SoundEvent(new ResourceLocation("minepiece_goated_edition", "swordslice-audio")));
}
