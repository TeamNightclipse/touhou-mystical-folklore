package com.cinnamon.tmf.forge;

import com.cinnamon.tmf.TMF;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(TMF.MOD_ID)
public class TMFForge {
    public TMFForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(TMF.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        TMF.init();
    }
}
