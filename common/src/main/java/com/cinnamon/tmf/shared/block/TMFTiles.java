package com.cinnamon.tmf.shared.block;

import com.cinnamon.tmf.Names;
import com.cinnamon.tmf.TMF;
import com.cinnamon.tmf.shared.block.shrine.tile.OfferingTableBlockEntity;
import dev.architectury.hooks.block.BlockEntityHooks;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class TMFTiles {

    public static final DeferredRegister<BlockEntityType<?>> TILES = DeferredRegister.create(TMF.MOD_ID, Registry.BLOCK_ENTITY_TYPE_REGISTRY);

    public static final RegistrySupplier<BlockEntityType<OfferingTableBlockEntity>> OFFERING_TABLE = TILES.register(Names.OFFERING_TABLE, () ->
            BlockEntityHooks.builder(OfferingTableBlockEntity::new, TMFBlocks.OFFERING_TABLE_BLOCK.get()).build(null));
}
