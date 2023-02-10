package me.sainte.vexhaxxxxxx;

import me.sainte.vexhaxxxxxx.modules.Mod;
import me.sainte.vexhaxxxxxx.modules.ModuleManager;
import me.sainte.vexhaxxxxxx.ui.screens.clickgui.ClickGUI;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.glfw.GLFW;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import me.sainte.vexhaxxxxxx.events.EventSendPacket;


public class VexHaxxxxxx implements ModInitializer {
    public static final VexHaxxxxxx INSTANCE = new VexHaxxxxxx();
    private MinecraftClient mc = MinecraftClient.getInstance();
    public Logger logger = LogManager.getLogger(VexHaxxxxxx.class);
    public void onInitialize() {

    }

    public void onKeyPress(int key, int action){
        if(action == GLFW.GLFW_PRESS) {
            for (Mod module : ModuleManager.INSTANCE.getModules()){
                if (key == module.getKey()) module.toggle();
            }
            if(key == GLFW.GLFW_KEY_RIGHT_SHIFT) mc.setScreen(ClickGUI.INSTANCE);
        }
    }

    public void onTick(){
        if (mc.player != null){
            for (Mod module : ModuleManager.INSTANCE.getEnabledModules()){
                module.onTick();
            }
        }
    }
}
