package net.dairycultist.syrup_and_sugar;

import com.matthewperiut.accessoryapi.AccessoryAPI;
import com.matthewperiut.accessoryapi.api.AccessoryRegister;
import net.dairycultist.syrup_and_sugar.accessories.TestAccessory;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class SyrupAndSugar {

    @Entrypoint.Namespace
    public static Namespace NAMESPACE = Null.get();

    public static Item TEST_ACCESSORY;

    @EventListener
    public void registerItems(ItemRegistryEvent event) {

        AccessoryAPI.config.aetherStyleArmor = false;
        AccessoryRegister.add("ring");
        AccessoryRegister.add("ring");

        TEST_ACCESSORY = new TestAccessory(NAMESPACE.id("test_accessory"))
                .setTranslationKey(NAMESPACE, "test_accessory");
    }
}
