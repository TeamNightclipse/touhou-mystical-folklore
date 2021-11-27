package com.cinnamon.tmf.shared.block.tiles;

import com.cinnamon.tmf.Names;
import com.cinnamon.tmf.TMF;
import com.cinnamon.tmf.shared.block.TMFBlocks;
import com.cinnamon.tmf.shared.block.tiles.shrine.OfferingTableTile;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.function.Supplier;

public class TMFTiles {

    public static final DeferredRegister<BlockEntityType<?>> ENTBLOCKS = DeferredRegister.create(TMF.MOD_ID, Registry.BLOCK_ENTITY_TYPE_REGISTRY);

    public static final RegistrySupplier<BlockEntityType<OfferingTableTile>> OfferingTable = ENTBLOCKS.register(Names.OFFERING_TABLE_TILE,

    /*public static final RegistrySupplier<BlockEntityType<?>> OfferingTableTile = ENTBLOCKS.register(Names.OFFERING_TABLE_TILE, new Supplier<BlockEntityType<?>>()
    {
        @Override
        public BlockEntityType<?> get() {
            return BlockEntityType.Builder.of(OFFERING_TABLE_TILE::new, TMFBlocks.OFFERING_TABLE_BLOCK.get());
        }
    });*/
}
