package net.dairycultist.dairycraft.structure;

import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

import java.util.Random;

public abstract class Structure {

    public abstract boolean attemptToPlace(World world, Biome biome, Random random, int x, int z);
}
