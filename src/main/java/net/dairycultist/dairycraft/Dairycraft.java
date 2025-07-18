package net.dairycultist.dairycraft;

import com.matthewperiut.accessoryapi.AccessoryAPI;
import com.matthewperiut.accessoryapi.api.AccessoryRegister;
import net.dairycultist.dairycraft.accessory.TestAccessory;
import net.dairycultist.dairycraft.structure.ShackStructure;
import net.dairycultist.dairycraft.structure.Structure;
import net.fabricmc.api.ModInitializer;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.event.world.gen.WorldGenEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class Dairycraft implements ModInitializer {

    @Entrypoint.Namespace
    public static Namespace NAMESPACE = Null.get();

    public static Item TEST_ACCESSORY;

    @EventListener
    public void registerItems(ItemRegistryEvent event) {

        AccessoryAPI.config.aetherStyleArmor = false;
        AccessoryRegister.add("ring");
        AccessoryRegister.add("ring");
        AccessoryRegister.add("ring");
        AccessoryRegister.add("shield");

        TEST_ACCESSORY = new TestAccessory(NAMESPACE.id("test_accessory"))
                .setTranslationKey(NAMESPACE, "test_accessory");
    }

    public void onInitialize() {

        System.out.println("Initializing Dairycraft");
//        if (FabricLoader.getInstance().isModLoaded("retrocommands")) {
//
//            CommandRegistry.add(new Command() {
    }

    private static final Structure[] structures = {
            new ShackStructure()
    };

    @EventListener
    public void decorate(WorldGenEvent.ChunkDecoration event) {

        // place structures, ensuring no two structures are placed in the same chunk
        for (Structure structure : structures)
            if (structure.attemptToPlace(event.world, event.biome, event.random, event.x + event.random.nextInt(16), event.z + event.random.nextInt(16)))
                break;
    }
}
