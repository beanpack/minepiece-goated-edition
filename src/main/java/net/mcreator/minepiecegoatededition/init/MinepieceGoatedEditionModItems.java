
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
import net.mcreator.minepiecegoatededition.item.YakuzaKasenItem;
import net.mcreator.minepiecegoatededition.item.Mp500Item;
import net.mcreator.minepiecegoatededition.item.Mp400Item;
import net.mcreator.minepiecegoatededition.item.Mp300Item;
import net.mcreator.minepiecegoatededition.item.Mp200Item;
import net.mcreator.minepiecegoatededition.item.Mp100Item;
import net.mcreator.minepiecegoatededition.item.Mp1000Item;
import net.mcreator.minepiecegoatededition.item.GreenBloodSyringeItem;
import net.mcreator.minepiecegoatededition.MinepieceGoatedEditionMod;

public class MinepieceGoatedEditionModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MinepieceGoatedEditionMod.MODID);
	public static final RegistryObject<Item> YORU = REGISTRY.register("yoru", () -> new YoruItem());
	public static final RegistryObject<Item> GREEN_BLOOD_SYRINGE = REGISTRY.register("green_blood_syringe", () -> new GreenBloodSyringeItem());
	public static final RegistryObject<Item> MP_1000 = REGISTRY.register("mp_1000", () -> new Mp1000Item());
	public static final RegistryObject<Item> YAKUZA_KASEN = REGISTRY.register("yakuza_kasen", () -> new YakuzaKasenItem());
	public static final RegistryObject<Item> MP_500 = REGISTRY.register("mp_500", () -> new Mp500Item());
	public static final RegistryObject<Item> MP_400 = REGISTRY.register("mp_400", () -> new Mp400Item());
	public static final RegistryObject<Item> MP_300 = REGISTRY.register("mp_300", () -> new Mp300Item());
	public static final RegistryObject<Item> MP_200 = REGISTRY.register("mp_200", () -> new Mp200Item());
	public static final RegistryObject<Item> MP_100 = REGISTRY.register("mp_100", () -> new Mp100Item());
	public static final RegistryObject<Item> COW_SMILE_SPAWN_EGG = REGISTRY.register("cow_smile_spawn_egg", () -> new ForgeSpawnEggItem(MinepieceGoatedEditionModEntities.COW_SMILE, -6737152, -1, new Item.Properties().group(null)));
	// Start of user code block custom items
	// End of user code block custom items
}
