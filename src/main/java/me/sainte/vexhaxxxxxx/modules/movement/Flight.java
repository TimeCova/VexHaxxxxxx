package me.sainte.vexhaxxxxxx.modules.movement;

import me.sainte.vexhaxxxxxx.events.EventSendPacket;
import me.sainte.vexhaxxxxxx.modules.Mod;
import me.sainte.vexhaxxxxxx.modules.settings.BooleanSetting;
import me.sainte.vexhaxxxxxx.modules.settings.ModeSetting;
import me.sainte.vexhaxxxxxx.modules.settings.NumberSetting;
import org.lwjgl.glfw.GLFW;

public class Flight extends Mod {
    public NumberSetting speed = new NumberSetting("Speed", 0, 8, 1, 0.1);
    public BooleanSetting test = new BooleanSetting("Falldmg?", false);
    public ModeSetting testmode = new ModeSetting("Mode", "Vanilla", "PacketFly", "ColeSpeed", "SpeedTackle");
    public Flight() {
        super("Flight", "Makes you go zoom in the air", Category.MOVEMENT);
        this.setKey(GLFW.GLFW_KEY_G);
        addSettings(speed, test, testmode);
    }
    @Override
    public void onTick() {
        mc.player.getAbilities().flying = true;
        mc.player.getAbilities().setFlySpeed(speed.getValueFloat());
        super.onTick();
    }
    @Override
    public void onDisable() {
        mc.player.getAbilities().flying = false;
        super.onDisable();
    }
}
