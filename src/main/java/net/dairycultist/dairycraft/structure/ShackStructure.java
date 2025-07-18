package net.dairycultist.dairycraft.structure;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

import java.util.Random;

public class ShackStructure extends Structure {

    public boolean attemptToPlace(World world, Biome biome, Random random, int x, int z) {

        world.setBlock(x, world.getTopY(x, z), z, Block.DIAMOND_BLOCK.id);
        return true;
    }
}
