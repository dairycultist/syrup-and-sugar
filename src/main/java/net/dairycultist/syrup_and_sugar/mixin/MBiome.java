package net.dairycultist.syrup_and_sugar.mixin;

import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Biome.class)
public class MBiome {

    @Inject(method = "setName", at = @At(value = "HEAD"))
    protected void setNameMixin(String name, CallbackInfoReturnable<Biome> cir) {

//        Biome self = (Biome) (Object) this;
//
//        if (name.equals("Desert")) {
//            self.addFeature
//            self.addHostileEntity
//        }
    }
}
