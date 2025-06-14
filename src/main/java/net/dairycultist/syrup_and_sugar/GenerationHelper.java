package net.dairycultist.syrup_and_sugar;

import net.minecraft.block.Block;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Random;

public class GenerationHelper {

    public interface SubGenerator {

        void generate(World gWorld, Random gRandom, int gx, int gy, int gz, int gw, int gh, int gl, int[] data);
    }

    public static ChestBlockEntity lootChest(World world, Random random, int x, int y, int z, int tries, Item[] items, int[] mins, int[] maxes) {

        world.setBlock(x, y, z, Block.CHEST.id);
        ChestBlockEntity chest = (ChestBlockEntity) world.getBlockEntity(x, y, z);

        for (int i = 0; i < tries; i++) {

            int itemIndex = random.nextInt(items.length);

            chest.setStack(random.nextInt(chest.size()), new ItemStack(items[itemIndex], random.nextInt(mins[itemIndex], maxes[itemIndex])));
        }

        return chest;
    }

    // generate a closed maze, where xyz is bottom corner
    // TODO add capacity to make mazes have more interesting designs and more diverse room sizes (height!)
    // TODO reference dungeons here https://youtu.be/snTfoz_xyQg?t=12180
    public static void generateMaze(World world, Random random, int x, int y, int z, int w, int h, int l, int minRoomEdge, int minRoomHeight, SubGenerator roomBuilder) {

        // uses a modified recursive division method https://en.wikipedia.org/wiki/Maze_generation_algorithm#Recursive_division_method

        // define a space as a 3D size + 6 booleans (one representing whether each wall/floor/ceiling has a door or not)

        // 1. create a space, and add it to a queue
        // 2. while the queue is not empty:
        //    - remove the next space in the queue
        //    - if the room cannot be split because it is too small, continue
        //    - otherwise, create two new spaces as random halves of the space, assigning a door to the relevant
        //      wall/floor/ceiling for either, and, for any doors that existed in the previous room, give it to one
        //      of the new rooms randomly
    }

    public static void replaceRect(World world, int fromId, int toId, int x, int y, int z, int w, int h, int l) {

        for (int ox = x; ox < x + w; ox++)
            for (int oy = y; oy < y + h; oy++)
                for (int oz = z; oz < z + l; oz++)
                    if (world.getBlockId(ox, oy, oz) == fromId)
                        world.setBlockWithoutNotifyingNeighbors(ox, oy, oz, toId);
    }

    public static void replaceRectRandomly(World world, Random random, int oneOutOf, int fromId, int toId, int x, int y, int z, int w, int h, int l) {

        for (int ox = x; ox < x + w; ox++)
            for (int oy = y; oy < y + h; oy++)
                for (int oz = z; oz < z + l; oz++)
                    if (world.getBlockId(ox, oy, oz) == fromId && random.nextInt(oneOutOf) == 0)
                        world.setBlockWithoutNotifyingNeighbors(ox, oy, oz, toId);
    }

    public static void fillRect(World world, int blockId, int x, int y, int z, int w, int h, int l) {

        for (int ox = x; ox < x + w; ox++)
            for (int oy = y; oy < y + h; oy++)
                for (int oz = z; oz < z + l; oz++)
                    world.setBlockWithoutNotifyingNeighbors(ox, oy, oz, blockId);
    }

    public static void fillRectMeta(World world, int blockId, int meta, int x, int y, int z, int w, int h, int l) {

        for (int ox = x; ox < x + w; ox++)
            for (int oy = y; oy < y + h; oy++)
                for (int oz = z; oz < z + l; oz++)
                    world.setBlockWithoutNotifyingNeighbors(ox, oy, oz, blockId, meta);
    }

    public static void fillHollowRect(World world, int blockId, int x, int y, int z, int w, int h, int l) {

        fillRect(world, blockId, x, y, z, w, h, l);
        fillRect(world, 0, x + 1, y + 1, z + 1, w - 2, h - 2, l - 2);
    }
}
