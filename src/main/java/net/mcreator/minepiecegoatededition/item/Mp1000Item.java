
package net.mcreator.minepiecegoatededition.item;

import net.minecraft.item.Rarity;
import net.minecraft.item.Item;

import net.mcreator.minepiecegoatededition.init.MinepieceGoatedEditionModTabs;

public class Mp1000Item extends Item {
	public Mp1000Item() {
		super(new Item.Properties().group(MinepieceGoatedEditionModTabs.TAB_MINEPIECE_CREATIVE_TAB).maxStackSize(64).isImmuneToFire().rarity(Rarity.COMMON));
	}
}
