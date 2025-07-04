
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minepiecegoatededition.init;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.item.Item;

import net.mcreator.minepiecegoatededition.item.YoruItem;
import net.mcreator.minepiecegoatededition.item.Mp1000Item;
import net.mcreator.minepiecegoatededition.item.GreenBloodSyringeItem;
import net.mcreator.minepiecegoatededition.MinepieceGoatedEditionMod;

public class MinepieceGoatedEditionModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MinepieceGoatedEditionMod.MODID);
	public static final RegistryObject<Item> YORU = REGISTRY.register("yoru", () -> new YoruItem());
	public static final RegistryObject<Item> GREEN_BLOOD_SYRINGE = REGISTRY.register("green_blood_syringe", () -> new GreenBloodSyringeItem());
	public static final RegistryObject<Item> MP_1000 = REGISTRY.register("mp_1000", () -> new Mp1000Item());
	public static final RegistryObject<Item> COW_SMILE_SPAWN_EGG = REGISTRY.register("cow_smile_spawn_egg", () -> new ForgeSpawnEggItem(MinepieceGoatedEditionModEntities.COW_SMILE, -6737152, -1, new Item.Properties().group(null)));
	// Start of user code block custom items
	// End of user code block custom items
}
