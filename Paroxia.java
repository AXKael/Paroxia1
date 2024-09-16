package net.kael.paroxia;

import com.mojang.logging.LogUtils;
import net.kael.paroxia.entity.ModEntities;
import net.kael.paroxia.entity.client.*;
import net.kael.paroxia.item.custom.ModItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Paroxia.MOD_ID)
public class Paroxia {
    public static final String MOD_ID = "paroxia";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Paroxia() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);


        modEventBus.addListener(this::commonSetup);


        MinecraftForge.EVENT_BUS.register(this);

        ModEntities.register(modEventBus);

        GeckoLib.initialize();


        modEventBus.addListener(this::addCreative);



    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative (BuildCreativeModeTabContentsEvent event) {

        if(event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.MEGACARUS_PLATE_SWORD);
        }
         if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.MEGACARUS_PLATE_SICKLE_PICKAXE);
        }
         if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.MEGACARUS_PLATE_BATTLE_AXE);
        }
         if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.MEGACARUS_PLATE_SPEAR_SHOVEL);
        }
         if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.ORCHID_CLAW);
        }
         if(event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.MEGACARUS_HELMET);
        }
        if(event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.MEGACARUS_CHESTPLATE);
        }
        if(event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.MEGACARUS_LEGGINGS);
        }
        if(event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.MEGACARUS_BOOTS);
        }

        if(event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ModItems.MEGACARUS_SPAWN_EGG);
        }
        if(event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ModItems.MUGA_SPAWN_EGG);
        }
        if(event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ModItems.TIGERMITE_SPAWN_EGG);
        }
                if(event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ModItems.PARVUBESTUS_SPAWN_EGG);
        }
                if(event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ModItems.ORCHIDQUEEN_SPAWN_EGG);
        }
                if(event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ModItems.ISOPAL_SPAWN_EGG);
        }
                if(event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ModItems.COMEPULGONES_SPAWN_EGG);
        }
                if(event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ModItems.LEMONFLY_SPAWN_EGG);
        }
                if(event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ModItems.CARNOSTIG_SPAWN_EGG);
        }
                if(event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ModItems.SPHAERIDIA_SPAWN_EGG);
        }
                if(event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ModItems.FLUFFMITE_SPAWN_EGG);
        }

        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS)  {
            event.accept(ModItems.MEGACARUS_PLATE);

        }

        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS)  {
            event.accept(ModItems.SPRINGTAIL_GUMMY);

        }

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.MEGACARUS.get(), MegacarusRenderer::new);
            EntityRenderers.register(ModEntities.MUGA.get(), MugaRenderer::new);
            EntityRenderers.register(ModEntities.TIGERMITE.get(), TigermiteRenderer::new);
            EntityRenderers.register(ModEntities.PARVUBESTUS.get(), ParvubestusRenderer::new);
            EntityRenderers.register(ModEntities.ORCHIDQUEEN.get(), OrchidQueenRenderer:: new);
            EntityRenderers.register(ModEntities.ISOPAL.get(), IsopalRenderer:: new);
            EntityRenderers.register(ModEntities.COMEPULGONES.get(), ComepulgonesRenderer:: new);
            EntityRenderers.register(ModEntities.LEMONFLY.get(), LemonflyRenderer:: new);
            EntityRenderers.register(ModEntities.CARNOSTIG.get(), CarnostigRenderer:: new);
            EntityRenderers.register(ModEntities.SPHAERIDIA.get(), SphaeridiaRenderer:: new);
            EntityRenderers.register(ModEntities.FLUFFMITE.get(), FluffmiteRenderer:: new);

       }
    }
}
