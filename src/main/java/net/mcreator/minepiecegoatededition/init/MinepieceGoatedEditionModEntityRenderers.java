/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minepiecegoatededition.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.minepiecegoatededition.client.renderer.CowSmileRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MinepieceGoatedEditionModEntityRenderers {
	@SubscribeEvent
	public static void render(FMLClientSetupEvent event) {
		MinepieceGoatedEditionModEntityRenderers.renders();
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public static void registerModels(ModelRegistryEvent event) {
		MinepieceGoatedEditionModEntityRenderers.renders();
	}

	private static void renders() {
		RenderingRegistry.registerEntityRenderingHandler(MinepieceGoatedEditionModEntities.COW_SMILE.get(), CowSmileRenderer::new);
	}
}
