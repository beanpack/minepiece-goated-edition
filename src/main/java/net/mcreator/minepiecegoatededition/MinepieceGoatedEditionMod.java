package net.mcreator.minepiecegoatededition;

import software.bernie.geckolib3.GeckoLib;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraftforge.fml.network.simple.SimpleChannel;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.thread.SidedThreadGroups;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.util.ResourceLocation;
import net.minecraft.network.PacketBuffer;

import net.mcreator.minepiecegoatededition.init.MinepieceGoatedEditionModTabs;
import net.mcreator.minepiecegoatededition.init.MinepieceGoatedEditionModSounds;
import net.mcreator.minepiecegoatededition.init.MinepieceGoatedEditionModParticleTypes;
import net.mcreator.minepiecegoatededition.init.MinepieceGoatedEditionModItems;
import net.mcreator.minepiecegoatededition.init.MinepieceGoatedEditionModEntities;

import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.BiConsumer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;
import java.util.AbstractMap;

@Mod("minepiece_goated_edition")
public class MinepieceGoatedEditionMod {
	public static final Logger LOGGER = LogManager.getLogger(MinepieceGoatedEditionMod.class);
	public static final String MODID = "minepiece_goated_edition";

	public MinepieceGoatedEditionMod() {
		GeckoLib.initialize();
		// Start of user code block mod constructor
		// End of user code block mod constructor
		MinecraftForge.EVENT_BUS.register(new MinepieceGoatedEditionModFMLBusEvents(this));
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		MinepieceGoatedEditionModTabs.load();
		MinepieceGoatedEditionModSounds.REGISTRY.register(bus);

		MinepieceGoatedEditionModItems.REGISTRY.register(bus);
		MinepieceGoatedEditionModEntities.REGISTRY.register(bus);

		MinepieceGoatedEditionModParticleTypes.REGISTRY.register(bus);

		bus.register(this);
		// Start of user code block mod init
		// End of user code block mod init
	}

	// Start of user code block mod methods
	// End of user code block mod methods
	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation(MODID, MODID), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
	private static int messageID = 0;

	public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, PacketBuffer> encoder, Function<PacketBuffer, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
		PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
		messageID++;
	}

	private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

	public static void queueServerWork(int tick, Runnable action) {
		if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER)
			workQueue.add(new AbstractMap.SimpleEntry<>(action, tick));
	}

	private static class MinepieceGoatedEditionModFMLBusEvents {
		private final MinepieceGoatedEditionMod parent;

		MinepieceGoatedEditionModFMLBusEvents(MinepieceGoatedEditionMod parent) {
			this.parent = parent;
		}

		@SubscribeEvent
		public void tick(TickEvent.ServerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
				workQueue.forEach(work -> {
					work.setValue(work.getValue() - 1);
					if (work.getValue() == 0)
						actions.add(work);
				});
				actions.forEach(e -> e.getKey().run());
				workQueue.removeAll(actions);
			}
		}
	}
}
