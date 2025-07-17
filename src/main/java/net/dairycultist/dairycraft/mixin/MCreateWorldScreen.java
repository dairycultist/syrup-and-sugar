package net.dairycultist.dairycraft.mixin;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.world.CreateWorldScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({CreateWorldScreen.class})
public class MCreateWorldScreen extends Screen {

    @Inject(method = {"render"}, at = {@At("TAIL")})
    private void init(CallbackInfo info) {

        int centerX = this.width / 2;
        int centerY = this.height / 4 + 12;

        // moves buttons initialized by CreateLevelScreenMixin (BH Creative) and CreateWorldGuiMixin (Hardcore)
        this.buttons.set(1, new ButtonWidget(2, centerX - 100, centerY + 120, 98, 20, ((ButtonWidget) this.buttons.get(1)).text));
        this.buttons.set(3, new ButtonWidget(127, centerX + 2, centerY + 120, 98, 20, ((ButtonWidget) this.buttons.get(3)).text));

        ((ButtonWidget) this.buttons.get(2)).y = centerY + 144;
    }
}
