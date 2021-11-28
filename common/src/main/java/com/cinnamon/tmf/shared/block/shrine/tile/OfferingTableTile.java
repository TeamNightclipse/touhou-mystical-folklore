package com.cinnamon.tmf.shared.block.shrine.tile;

import com.cinnamon.tmf.shared.block.TMFTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;

public class OfferingTableTile extends BlockEntity //implements
{
    public OfferingTableTile(BlockPos blockPos, BlockState blockState) {super(TMFTiles.OFFERING_TABLE.get(), blockPos, blockState);}
    //int ticks = 0;
    public static class OfferingTableTileTicker implements BlockEntityTicker<OfferingTableTile>
    {
        @Override
        public void tick(Level level, BlockPos blockPos, BlockState blockState, OfferingTableTile tableEntity)
        {
            /*Player player = level.getNearestPlayer(TargetingConditions.forNonCombat(), blockPos.getX(), blockPos.getY(), blockPos.getZ());
            if(tableEntity.ticks == 0) player.displayClientMessage(new TextComponent("AHHHHHHHHHH"), false);
            tableEntity.ticks++;
            if(tableEntity.ticks > 12) tableEntity.ticks = 0;*/
        }
    }
}


