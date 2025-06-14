package net.dairycultist.syrup_and_sugar.accessories;

import com.matthewperiut.accessoryapi.api.Accessory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class TestAccessory extends TemplateItem implements Accessory {

    public TestAccessory(Identifier identifier) {
        super(identifier);
    }

    public String[] getAccessoryTypes(ItemStack itemStack) {
        return new String[]{ "ring" };
    }

    public ItemStack tickWhileWorn(PlayerEntity player, ItemStack accessory) {
        return accessory;
    }

    public void onAccessoryAdded(PlayerEntity player, ItemStack accessory) {
        System.out.println("add");
    }

    public void onAccessoryRemoved(PlayerEntity player, ItemStack accessory) {
        System.out.println("remove");
    }
}