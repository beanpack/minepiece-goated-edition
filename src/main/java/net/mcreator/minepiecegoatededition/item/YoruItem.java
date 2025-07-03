
package net.mcreator.minepiecegoatededition.item;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

public class YoruItem extends PickaxeItem {
	public YoruItem() {
		super(new IItemTier() {
			public int getMaxUses() {
				return 100;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 11f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 15;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks();
			}
		}, 1, -2.7f, new Item.Properties().group(ItemGroup.TOOLS).isImmuneToFire());
	}
}
