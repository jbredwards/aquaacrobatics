package com.fuzs.fivefeetsmall.core.mixin;

import com.fuzs.fivefeetsmall.entity.player.IPlayerSPSwimming;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelElytra;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ModelElytra.class)
public abstract class ModelElytraMixin extends ModelBase {

    @Redirect(method = "setRotationAngles", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;isSneaking()Z"))
    public boolean shouldRenderSneakingSetRotationAngles(Entity entityIn) {

        if (entityIn instanceof IPlayerSPSwimming) {

            return ((IPlayerSPSwimming) entityIn).shouldRenderSneaking();
        }
         else {

             return entityIn.isSneaking();
        }
    }

}
