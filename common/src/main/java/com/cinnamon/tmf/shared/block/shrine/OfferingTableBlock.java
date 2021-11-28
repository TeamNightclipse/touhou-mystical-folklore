package com.cinnamon.tmf.shared.block.shrine;

import com.cinnamon.tmf.shared.block.shrine.tile.OfferingTableTile;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEventListener;
import org.jetbrains.annotations.Nullable;

public class OfferingTableBlock extends BaseEntityBlock
{
    public OfferingTableBlock(Properties properties)
    {
        super(properties);
    }

    @Nullable @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {return new OfferingTableTile(blockPos, blockState);}

    @Nullable @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType)
    {return (BlockEntityTicker<T>) new OfferingTableTile.OfferingTableTileTicker();}

    @Nullable @Override
    public <T extends BlockEntity> GameEventListener getListener(Level level, T blockEntity) {return super.getListener(level, blockEntity);}
}
