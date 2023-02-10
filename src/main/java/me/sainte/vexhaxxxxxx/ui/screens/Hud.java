package me.sainte.vexhaxxxxxx.ui.screens;

import me.sainte.vexhaxxxxxx.modules.Mod;
import me.sainte.vexhaxxxxxx.modules.ModuleManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

import java.awt.*;
import java.util.Comparator;
import java.util.List;

import static me.sainte.vexhaxxxxxx.ui.screens.Hud.renderArrayList;

public class Hud {
    private static MinecraftClient mc = MinecraftClient.getInstance();
    public static void render(MatrixStack matrices, float tickDelta){
        mc.textRenderer.drawWithShadow(matrices, "VexHax 1.0", 3, 3, Color.GREEN.getRGB());
        renderArrayList(matrices);
    }
    public static void renderArrayList(MatrixStack matrices){
        int index = 0;
        int sWidth = mc.getWindow().getScaledWidth();
        int sHeight = mc.getWindow().getScaledHeight();

        List<Mod> enabled = ModuleManager.INSTANCE.getEnabledModules();

        enabled.sort(Comparator.comparingInt(m -> (int)mc.textRenderer.getWidth(((Mod)m).getDisplayName())).reversed());

        for(Mod mod : enabled){
            mc.textRenderer.drawWithShadow(matrices, mod.getDisplayName(), (sWidth - 4) - mc.textRenderer.getWidth(mod.getDisplayName()), 3 + (index * mc.textRenderer.fontHeight), Color.GREEN.getRGB());
            index++;
        }
    }
}
