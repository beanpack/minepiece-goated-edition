/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minepiecegoatededition.init;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.RegistryObject;

import net.minecraft.potion.Effect;

import net.mcreator.minepiecegoatededition.potion.TestMobEffect;
import net.mcreator.minepiecegoatededition.potion.GravityMobEffect;
import net.mcreator.minepiecegoatededition.MinepieceGoatedEditionMod;

public class MinepieceGoatedEditionModMobEffects {
	public static final DeferredRegister<Effect> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, MinepieceGoatedEditionMod.MODID);
	public static final RegistryObject<Effect> TEST = REGISTRY.register("test", () -> new TestMobEffect());
	public static final RegistryObject<Effect> GRAVITY = REGISTRY.register("gravity", () -> new GravityMobEffect());
}
