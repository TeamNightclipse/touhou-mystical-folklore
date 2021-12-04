package com.cinnamon.tmf.shared.block;

import com.cinnamon.tmf.Names;
import com.cinnamon.tmf.TMF;
import com.cinnamon.tmf.shared.block.shrine.DecorationBlock;
import com.cinnamon.tmf.shared.block.shrine.OfferingTableBlock;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class TMFBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(TMF.MOD_ID, Registry.BLOCK_REGISTRY);

    public static final RegistrySupplier<Block> OFFERING_TABLE_BLOCK = BLOCKS.register(WoodType.OAK.name() + "_" + Names.OFFERING_TABLE, () ->
            new OfferingTableBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));

    public static final RegistrySupplier<Block> DECORATION_BLOCK = BLOCKS.register(Names.DECORATION, () ->
            new DecorationBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
}
