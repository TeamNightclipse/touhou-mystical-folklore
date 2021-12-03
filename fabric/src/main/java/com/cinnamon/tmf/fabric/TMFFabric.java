package com.cinnamon.tmf.fabric;

import com.cinnamon.tmf.TMF;
import com.cinnamon.tmf.shared.block.TMFTiles;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.transfer.v1.item.InventoryStorage;
import net.fabricmc.fabric.api.transfer.v1.item.ItemStorage;

public class TMFFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        TMF.init();
        TMFFabric.registerBlockAccess();
    }

    public static void registerBlockAccess() {
        ItemStorage.SIDED.registerForBlockEntity((offeringTableBlockEntity, direction) ->
                InventoryStorage.of(offeringTableBlockEntity.inventory, direction), TMFTiles.OFFERING_TABLE.get());
    }
}
