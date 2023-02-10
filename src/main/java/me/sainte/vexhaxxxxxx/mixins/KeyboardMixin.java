package me.sainte.vexhaxxxxxx.mixins;

import me.sainte.vexhaxxxxxx.VexHaxxxxxx;
import net.minecraft.client.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.security.auth.callback.Callback;

@Mixin(Keyboard.class)
public class KeyboardMixin {
    @Inject(method = "onKey", at = @At("HEAD"), cancellable = true)
    public void onKey(long window, int key, int scancode, int action, int modifiers, CallbackInfo ci){
        VexHaxxxxxx.INSTANCE.onKeyPress(key, action);
    }
}
