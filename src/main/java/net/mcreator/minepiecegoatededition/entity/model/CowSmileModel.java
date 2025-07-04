package net.mcreator.minepiecegoatededition.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.util.ResourceLocation;

import net.mcreator.minepiecegoatededition.entity.CowSmileEntity;

public class CowSmileModel extends AnimatedGeoModel<CowSmileEntity> {
	@Override
	public ResourceLocation getAnimationFileLocation(CowSmileEntity entity) {
		return new ResourceLocation("minepiece_goated_edition", "animations/warm_cow_smile.animation.json");
	}

	@Override
	public ResourceLocation getModelLocation(CowSmileEntity entity) {
		return new ResourceLocation("minepiece_goated_edition", "geo/warm_cow_smile.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(CowSmileEntity entity) {
		return new ResourceLocation("minepiece_goated_edition", "textures/entities/" + entity.getTexture() + ".png");
	}

}
