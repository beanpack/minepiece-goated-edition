/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minepiecegoatededition.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

public class MinepieceGoatedEditionModTabs {
	public static ItemGroup TAB_MINEPIECE_CREATIVE_TAB;

	public static void load() {
		TAB_MINEPIECE_CREATIVE_TAB = new ItemGroup("minepiece_goated_edition.minepiece_creative_tab") {
			@Override
			@OnlyIn(Dist.CLIENT)
			public ItemStack createIcon() {
				return new ItemStack(Items.PUMPKIN_PIE);
			}

			@Override
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
}
