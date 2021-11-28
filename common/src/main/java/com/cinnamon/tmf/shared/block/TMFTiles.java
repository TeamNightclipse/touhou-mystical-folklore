package com.cinnamon.tmf.shared.block;

import com.cinnamon.tmf.Names;
import com.cinnamon.tmf.TMF;
import com.cinnamon.tmf.shared.block.shrine.tile.OfferingTableTile;
import dev.architectury.hooks.block.BlockEntityHooks;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class TMFTiles {

    public static final DeferredRegister<BlockEntityType<?>> BLOCKS = DeferredRegister.create(TMF.MOD_ID, Registry.BLOCK_ENTITY_TYPE_REGISTRY);

    public static final RegistrySupplier<BlockEntityType<OfferingTableTile>> OFFERING_TABLE = BLOCKS.register(Names.OFFERING_TABLE, () -> BlockEntityHooks.builder(OfferingTableTile::new, TMFBlocks.OFFERING_TABLE_BLOCK.get()).build(null));
}
