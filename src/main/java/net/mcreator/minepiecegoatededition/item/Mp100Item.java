
package net.mcreator.minepiecegoatededition.item;

import net.minecraft.item.Rarity;
import net.minecraft.item.Item;

import net.mcreator.minepiecegoatededition.init.MinepieceGoatedEditionModTabs;

public class Mp100Item extends Item {
	public Mp100Item() {
		super(new Item.Properties().group(MinepieceGoatedEditionModTabs.TAB_MINEPIECE_CREATIVE_TAB).maxStackSize(64).rarity(Rarity.COMMON));
	}
}
