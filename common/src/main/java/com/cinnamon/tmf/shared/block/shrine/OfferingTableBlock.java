package com.cinnamon.tmf.shared.block.shrine;

import com.cinnamon.tmf.shared.block.TMFTiles;
import com.cinnamon.tmf.shared.block.shrine.tile.OfferingTableBlockEntity;
import com.cinnamon.tmf.shared.item.TMFItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.LecternBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class OfferingTableBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING;
    public static final BooleanProperty HAS_ITEM;
    public static final VoxelShape SHAPE_BASE;
    public static final VoxelShape SHAPE_COMMON;
    public static final VoxelShape SHAPE_OCCLUSION;
    public static final VoxelShape SHAPE_COLLISION;

    public OfferingTableBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(OfferingTableBlock.this.newBlockState());
    }

    private BlockState newBlockState() {
        return this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(HAS_ITEM, false);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, HAS_ITEM);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return this.defaultBlockState().setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE_COMMON;
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return SHAPE_OCCLUSION;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE_COLLISION;
    }

    @Override
    public void onPlace(BlockState blockState, Level level, BlockPos blockPos, BlockState blockState2, boolean bl) {
        if (!blockState.is(blockState2.getBlock())) {
            level.updateNeighborsAt(blockPos.below(), this);

            super.onPlace(blockState, level, blockPos, blockState2, bl);
        }
    }

    @Override
    public void onRemove(BlockState blockState, Level level, BlockPos blockPos, BlockState blockState2, boolean bl) {
        if (!blockState.is(blockState2.getBlock())) {
            if (blockState.getValue(HAS_ITEM)) {
                this.popItem(blockState, level, blockPos);
            }

            if (blockState.getValue(HAS_ITEM)) {
                level.updateNeighborsAt(blockPos.below(), this);
            }

            super.onRemove(blockState, level, blockPos, blockState2, bl);
        }
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (blockState.getValue(HAS_ITEM)) {
            if (!level.isClientSide) {
                this.popItem(blockState, level, blockPos);
                level.setBlock(blockPos, blockState.setValue(HAS_ITEM, false), 3);
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            ItemStack itemStack = player.getItemInHand(interactionHand);
            if (!itemStack.isEmpty() && !itemStack.is(TMFItems.OFFERING_TABLE_ITEM.get())) {
                if (!level.isClientSide) {
                    this.putItem(blockState, level, blockPos, itemStack);
                    level.setBlock(blockPos, blockState.setValue(HAS_ITEM, true), 3);
                }
                return InteractionResult.CONSUME;
            } else {
                return InteractionResult.PASS;
            }
        }
    }

    private void putItem(BlockState blockState, Level level, BlockPos blockPos, ItemStack stack) {
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof OfferingTableBlockEntity offeringTableBlockEntity) {
            offeringTableBlockEntity.setItem(stack);
        }
    }

    private void popItem(BlockState blockState, Level level, BlockPos blockPos) {
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof OfferingTableBlockEntity offeringTableBlockEntity) {
            Direction direction = blockState.getValue(FACING);
            ItemStack itemStack = offeringTableBlockEntity.getItem().copy();
            float f = 0.25F * (float)direction.getStepX();
            float g = 0.25F * (float)direction.getStepZ();
            ItemEntity itemEntity = new ItemEntity(level, (double)blockPos.getX() + 0.5D + (double)f, blockPos.getY() + 1, (double)blockPos.getZ() + 0.5D + (double)g, itemStack);
            itemEntity.setDefaultPickUpDelay();
            level.addFreshEntity(itemEntity);
            offeringTableBlockEntity.clearContent();
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new OfferingTableBlockEntity(blockPos, blockState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, TMFTiles.OFFERING_TABLE.get(), OfferingTableBlockEntity.Ticker::tick);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    static {
        FACING = HorizontalDirectionalBlock.FACING;
        HAS_ITEM = BooleanProperty.create("has_item");
        SHAPE_BASE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 13.0D, 16.0D);
        SHAPE_COMMON = Shapes.or(SHAPE_BASE);
        SHAPE_OCCLUSION = Shapes.or(SHAPE_COMMON);
        SHAPE_COLLISION = Shapes.or(SHAPE_COMMON);
    }
}
