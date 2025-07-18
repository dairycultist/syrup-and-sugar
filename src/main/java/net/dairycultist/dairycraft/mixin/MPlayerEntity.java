package net.dairycultist.dairycraft.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class MPlayerEntity extends LivingEntity {

    @Unique
    private int toHeal = 0;

    public MPlayerEntity(World world) {
        super(world);
    }

    public void heal(int amount) {

        // cache amount to heal
        toHeal += amount;
    }

    @Inject(method = "tickMovement", at = @At(value = "HEAD"))
    public void tickMovement(CallbackInfo ci) {

        // heal over time
        if (toHeal > 0 && this.health > 0 && this.health < 20 && this.age % 20 * 12 == 0) {

            this.health++;
            this.toHeal--;
            this.hearts = this.maxHealth / 2;

            // if you become fully healed, the rest of toHeal is wasted
            if (this.health >= 20)
                this.toHeal = 0;
        }
    }
}
