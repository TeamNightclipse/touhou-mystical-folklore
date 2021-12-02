package com.cinnamon.tmf;

import com.cinnamon.tmf.client.render.block.shrine.OfferingTableRender;
import com.cinnamon.tmf.shared.block.TMFBlocks;
import com.cinnamon.tmf.shared.block.TMFTiles;
import com.cinnamon.tmf.shared.item.TMFItems;
import dev.architectury.event.events.client.ClientLifecycleEvent;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class TMF {

    public static final String MOD_ID = "touhoumysticalfolklore";

    public static final CreativeModeTab TAB = CreativeTabRegistry.create(
            new ResourceLocation(MOD_ID, "touhou_mystical_folklore"), () -> new ItemStack(TMFItems.OFFERING_TABLE_ITEM.get())
    );

    public static void init() {
        TMFBlocks.BLOCKS.register();
        TMFItems.ITEMS.register();
        TMFTiles.TILES.register();
        ClientLifecycleEvent.CLIENT_SETUP.register(instance -> {
            BlockEntityRendererRegistry.register(TMFTiles.OFFERING_TABLE.get(), OfferingTableRender::new);
        });
    }
}
