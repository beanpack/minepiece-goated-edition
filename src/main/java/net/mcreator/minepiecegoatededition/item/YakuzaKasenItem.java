
package net.mcreator.minepiecegoatededition.item;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.minepiecegoatededition.init.MinepieceGoatedEditionModTabs;

public class YakuzaKasenItem extends SwordItem {
	public YakuzaKasenItem() {
		super(new IItemTier() {
			public int getMaxUses() {
				return 3600;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 7f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks();
			}
		}, 3, -3f, new Item.Properties().group(MinepieceGoatedEditionModTabs.TAB_MINEPIECE_CREATIVE_TAB).isImmuneToFire());
	}
}
