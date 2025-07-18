package net.dairycultist.dairycraft;

import com.matthewperiut.accessoryapi.AccessoryAPI;
import com.matthewperiut.accessoryapi.api.AccessoryRegister;
import net.dairycultist.dairycraft.accessories.TestAccessory;
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

    @EventListener
    public void decorate(WorldGenEvent.ChunkDecoration event) {
//        event.world, event.worldSource, event.x, event.z, event.random
    }
}
