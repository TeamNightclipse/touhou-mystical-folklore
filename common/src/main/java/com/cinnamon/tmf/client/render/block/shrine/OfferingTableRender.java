package com.cinnamon.tmf.client.render.block.shrine;

import com.cinnamon.tmf.shared.block.shrine.OfferingTableBlock;
import com.cinnamon.tmf.shared.block.shrine.tile.OfferingTableBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.level.block.LecternBlock;
import net.minecraft.world.level.block.state.BlockState;

@Environment(EnvType.CLIENT)
public class OfferingTableRender implements BlockEntityRenderer<OfferingTableBlockEntity> {

    private final ItemRenderer itemRenderer;

    public OfferingTableRender(BlockEntityRendererProvider.Context context) {
        //UWU
    }

    @Override
    public void render(OfferingTableBlockEntity blockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
        BlockState blockState = blockEntity.getBlockState();
        if (blockState.getValue(OfferingTableBlock.HAS_ITEM)) {
            poseStack.pushPose();
            poseStack.translate(0.5D, 0.8325D, 0.5D);
            float g = blockState.getValue(LecternBlock.FACING).getClockWise().toYRot();
            poseStack.mulPose(Vector3f.YP.rotationDegrees(-g - 90F));
            poseStack.mulPose(Vector3f.XP.rotationDegrees(90F));
            poseStack.scale(0.5F, 0.5F, 0.5F);
            this.itemRenderer.renderStatic(blockEntity.getItem(), ItemTransforms.TransformType.FIXED, i, OverlayTexture.NO_OVERLAY, poseStack, multiBufferSource, 0);
            poseStack.popPose();
        }
    }

    {
        this.itemRenderer = Minecraft.getInstance().getItemRenderer();
    }
}
