package com.cinnamon.tmf.shared.block.shrine.tile;

import com.cinnamon.tmf.shared.block.TMFTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class OfferingTableTile extends BlockEntity {

    public OfferingTableTile(BlockPos blockPos, BlockState blockState) {
        super(TMFTiles.OFFERING_TABLE.get(), blockPos, blockState);
    }
}
