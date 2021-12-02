package com.cinnamon.tmf.shared.item;

import com.cinnamon.tmf.Names;
import com.cinnamon.tmf.TMF;
import com.cinnamon.tmf.shared.block.TMFBlocks;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class TMFItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(TMF.MOD_ID, Registry.ITEM_REGISTRY);

    public static final RegistrySupplier<Item> OFFERING_TABLE_ITEM = ITEMS.register(Names.OFFERING_TABLE,
            () -> new BlockItem(TMFBlocks.OFFERING_TABLE_BLOCK.get(), new Item.Properties().tab(TMF.TAB)));

    public static final RegistrySupplier<Item> DECORATION_ITEM = ITEMS.register(Names.DECORATION,
            () -> new BlockItem(TMFBlocks.DECORATION_BLOCK.get(), new Item.Properties().tab(TMF.TAB)));
}
