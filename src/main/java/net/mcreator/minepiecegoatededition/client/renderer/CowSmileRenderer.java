
package net.mcreator.minepiecegoatededition.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import software.bernie.geckolib3.geo.render.built.GeoModel;

import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.IRenderTypeBuffer;

import net.mcreator.minepiecegoatededition.entity.model.CowSmileModel;
import net.mcreator.minepiecegoatededition.entity.CowSmileEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

public class CowSmileRenderer extends GeoEntityRenderer<CowSmileEntity> {
	@Override
	public ResourceLocation getEntityTexture(CowSmileEntity entity) {
		return new ResourceLocation("minepiece_goated_edition:textures/entities/cowwarmtexture.png");
	}

	public CowSmileRenderer(EntityRendererManager renderManager) {
		super(renderManager, new CowSmileModel());
		this.shadowSize = 0.5f;
	}

	@Override
	public RenderType getRenderType(CowSmileEntity animatable, float partialTicks, MatrixStack poseStack, IRenderTypeBuffer bufferSource, IVertexBuilder buffer, int packedLight, ResourceLocation texture) {
		return RenderType.getEntityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void render(GeoModel model, CowSmileEntity entity, float partialTick, RenderType type, MatrixStack poseStack, IRenderTypeBuffer bufferSource, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
			float alpha) {
		float scale = 1f;
		this.widthScale = scale;
		this.heightScale = scale;
		super.render(model, entity, partialTick, type, poseStack, bufferSource, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
