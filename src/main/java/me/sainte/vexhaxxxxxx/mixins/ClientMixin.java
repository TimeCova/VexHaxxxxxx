package me.sainte.vexhaxxxxxx.mixins;

import me.sainte.vexhaxxxxxx.VexHaxxxxxx;
import me.sainte.vexhaxxxxxx.events.EventSendPacket;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class ClientMixin {
    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    public void onTick(CallbackInfo ci){
        VexHaxxxxxx.INSTANCE.onTick();
    }
}
