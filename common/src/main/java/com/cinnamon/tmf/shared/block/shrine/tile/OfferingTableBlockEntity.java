package com.cinnamon.tmf.shared.block.shrine.tile;

import com.cinnamon.tmf.shared.block.TMFTiles;
import dev.architectury.extensions.BlockEntityExtension;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerListener;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class OfferingTableBlockEntity extends BlockEntity implements BlockEntityExtension {

    public final SimpleContainer inventory;

    public OfferingTableBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(TMFTiles.OFFERING_TABLE.get(), blockPos, blockState);
    }

    public void clearContent() {
        this.inventory.clearContent();
        this.setChanged();
    }

    public ItemStack getItem() {
        return this.inventory.getItem(0);
    }

    public void setItem(ItemStack item) {
        this.inventory.setItem(0, item);
        this.setChanged();
        this.syncData();
    }

    @Override
    public CompoundTag saveClientData(CompoundTag compoundTag) {
        compoundTag.put("Inventory", this.inventory.createTag());
        return compoundTag;
    }

    @Override
    public void loadClientData(BlockState pos, CompoundTag compoundTag) {
        this.inventory.fromTag(compoundTag.getList("Inventory", Tag.TAG_COMPOUND));
    }

    @Override
    public CompoundTag save(CompoundTag compoundTag) {
        compoundTag.put("Inventory", this.inventory.createTag());
        return super.save(compoundTag);
    }

    @Override
    public void load(CompoundTag compoundTag) {
        this.inventory.fromTag(compoundTag.getList("Inventory", Tag.TAG_COMPOUND));
        super.load(compoundTag);
    }

    {
        this.inventory = new SimpleContainer(1);
        this.inventory.addListener(container -> {
            this.setChanged();
            this.syncData();
        });
    }

    public static class Ticker {
        public static void tick(Level level, BlockPos blockPos, BlockState blockState, OfferingTableBlockEntity tableEntity) {

        }
    }
}
