package me.sainte.vexhaxxxxxx.modules.movement;

import me.sainte.vexhaxxxxxx.events.EventSendPacket;
import me.sainte.vexhaxxxxxx.modules.Mod;
import org.lwjgl.glfw.GLFW;

public class Sprint extends Mod {
    public Sprint(){
        super("Sprint", "Don't stop running!!",Category.MOVEMENT);
        this.setKey(GLFW.GLFW_KEY_H);
    }
    @Override
    public void onTick() {
        mc.player.setSprinting(true);
        super.onTick();
    }

    @Override
    public void onDisable() {
        mc.player.setSprinting(false);
        super.onDisable();
    }
}
