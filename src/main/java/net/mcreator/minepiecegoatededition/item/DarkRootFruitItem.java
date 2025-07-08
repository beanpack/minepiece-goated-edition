
package net.mcreator.minepiecegoatededition.item;

import net.minecraft.world.World;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import net.mcreator.minepiecegoatededition.procedures.DarkRootRemoveProcedure;
import net.mcreator.minepiecegoatededition.init.MinepieceGoatedEditionModTabs;

public class DarkRootFruitItem extends Item {
	public DarkRootFruitItem() {
		super(new Item.Properties().group(MinepieceGoatedEditionModTabs.TAB_MINEPIECE_CREATIVE_TAB).maxStackSize(1).rarity(Rarity.EPIC).food((new Food.Builder()).hunger(2).saturation(0.3f).setAlwaysEdible().build()));
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
		ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
		double x = entity.getPosX();
		double y = entity.getPosY();
		double z = entity.getPosZ();
		DarkRootRemoveProcedure.execute(entity);
		return retval;
	}
}
