package com.cinnamon.tmf.fabric;

import com.cinnamon.tmf.TMFExpectPlatform;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class TMFExpectPlatformImpl {
    /**
     * This is our actual method to {@link TMFExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }
}
