package com.cinnamon.tmf;

import com.google.common.base.Suppliers;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registries;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.function.Supplier;

public class TMF {

    public static final String MOD_ID = "touhoumysticalfolklore";

    //Here create the registry of the modId
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(MOD_ID, Registry.ITEM_REGISTRY);

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(MOD_ID, Registry.BLOCK_REGISTRY);

    // Registering a new creative tab
    public static final CreativeModeTab EXAMPLE_TAB = CreativeTabRegistry.create(new ResourceLocation(MOD_ID, "touhou_mystical_folklore"), () -> new ItemStack(TMF.OFFERING_TABLE_ITEM.get()));

    //Here register the item
    public static final RegistrySupplier<Item> OFFERING_TABLE_ITEM = ITEMS.register("offering_table", new Supplier<Item>() {
        @Override
        public Item get() {
            BlockItem blockItem = new BlockItem(OFFERING_TABLE_BLOCK.get(), new Item.Properties().tab(EXAMPLE_TAB));
            return blockItem;
        }
    });

    public static final RegistrySupplier<Block> OFFERING_TABLE_BLOCK = BLOCKS.register("offering_table", new Supplier<Block>() {
        @Override
        public Block get() {
            Block block = new Block(BlockBehaviour.Properties.of(Material.BAMBOO, MaterialColor.COLOR_BLACK));
            return block;
        }
    });
    
    public static void init() {
        ITEMS.register();
        BLOCKS.register();
        
        System.out.println(TMFExpectPlatform.getConfigDirectory().toAbsolutePath().normalize().toString());
    }
}
