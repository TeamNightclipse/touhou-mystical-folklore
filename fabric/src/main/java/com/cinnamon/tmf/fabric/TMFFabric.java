package com.cinnamon.tmf.fabric;

import com.cinnamon.tmf.TMF;
import net.fabricmc.api.ModInitializer;

public class TMFFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        TMF.init();
    }
}
