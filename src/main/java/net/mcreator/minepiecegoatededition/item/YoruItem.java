
package net.mcreator.minepiecegoatededition.item;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.LivingEntity;

import net.mcreator.minepiecegoatededition.procedures.SwordSlashProcedure;
import net.mcreator.minepiecegoatededition.init.MinepieceGoatedEditionModTabs;

public class YoruItem extends SwordItem {
	public YoruItem() {
		super(new IItemTier() {
			public int getMaxUses() {
				return 100;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 9f;
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
		}, 3, -2.7f, new Item.Properties().group(MinepieceGoatedEditionModTabs.TAB_MINEPIECE_CREATIVE_TAB).isImmuneToFire());
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
		boolean retval = super.onEntitySwing(itemstack, entity);
		SwordSlashProcedure.execute(entity.world, entity);
		return retval;
	}
}
