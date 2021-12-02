package com.cinnamon.tmf.forge;

import com.cinnamon.tmf.TMFPlatform;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class TMFPlatformImpl {
    /**
     * This is our actual method to {@link TMFPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
}
