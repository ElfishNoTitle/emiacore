package org.peace.notitle.emiacore.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import org.peace.notitle.emiacore.items.EmiaItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(EnvType.CLIENT)
@Mixin(ClientPlayerEntity.class)
public abstract class ClientPlayerEntityMixin {
    @Inject(method = "dropSelectedItem", at = @At("HEAD"), cancellable = true)
    private void onClientPlayerDropItem(boolean entireStack, CallbackInfoReturnable<Boolean> cir){
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player != null && EmiaItem.beKeptItems.contains(player.getMainHandStack().getItem())) {
            cir.cancel();
        }
    }
}
