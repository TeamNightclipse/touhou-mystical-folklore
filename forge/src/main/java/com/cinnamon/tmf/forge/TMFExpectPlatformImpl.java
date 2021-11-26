package com.cinnamon.tmf.forge;

import com.cinnamon.tmf.TMFExpectPlatform;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class TMFExpectPlatformImpl {
    /**
     * This is our actual method to {@link TMFExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
}
