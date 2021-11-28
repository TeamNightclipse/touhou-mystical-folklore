package com.cinnamon.tmf;

import com.cinnamon.tmf.shared.block.TMFBlocks;
import com.cinnamon.tmf.shared.block.TMFTiles;
import com.cinnamon.tmf.shared.item.TMFItems;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class TMF {

    public static final String MOD_ID = "touhoumysticalfolklore";

    public static final CreativeModeTab TAB = CreativeTabRegistry.create(
            new ResourceLocation(MOD_ID, "touhou_mystical_folklore"), () -> new ItemStack(TMFItems.OFFERING_TABLE_ITEM.get())
    );

    public static void init() {
        TMFBlocks.BLOCKS.register();
        TMFItems.ITEMS.register();
        TMFTiles.TILES.register();
        
        System.out.println(TMFExpectPlatform.getConfigDirectory().toAbsolutePath().normalize().toString());
    }
}
