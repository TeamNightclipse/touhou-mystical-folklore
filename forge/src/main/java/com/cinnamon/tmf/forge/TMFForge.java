package com.cinnamon.tmf.forge;

import com.cinnamon.tmf.TMF;
import com.cinnamon.tmf.shared.block.shrine.tile.OfferingTableBlockEntity;
import dev.architectury.platform.forge.EventBuses;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

@Mod(TMF.MOD_ID)
@Mod.EventBusSubscriber(modid = TMF.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TMFForge {
    public TMFForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(TMF.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        TMF.init();
    }

    @SubscribeEvent
    public static void attachBlockEntity(AttachCapabilitiesEvent<BlockEntity> event) {
        if (event.getObject() instanceof OfferingTableBlockEntity offeringTableBlockEntity) {
            ResourceLocation key = new ResourceLocation(TMF.MOD_ID, "inventory");
            event.addCapability(key, TMFForge.inventory(() -> offeringTableBlockEntity.inventory));
        }
    }

    public static ICapabilityProvider inventory(Supplier<Container> container) {
        return new ICapabilityProvider() {
            @NotNull
            @Override
            public <T> LazyOptional<T> getCapability(@NotNull Capability<T> capability, @Nullable Direction arg) {
                IItemHandler iItemHandler = new InvWrapper(container.get());

                return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.orEmpty(
                        capability, LazyOptional.of(() -> iItemHandler)
                );
            }
        };
    }
}
