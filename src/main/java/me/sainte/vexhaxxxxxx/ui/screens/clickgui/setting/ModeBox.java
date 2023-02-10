package me.sainte.vexhaxxxxxx.ui.screens.clickgui.setting;

import me.sainte.vexhaxxxxxx.modules.settings.BooleanSetting;
import me.sainte.vexhaxxxxxx.modules.settings.ModeSetting;
import me.sainte.vexhaxxxxxx.modules.settings.Setting;
import me.sainte.vexhaxxxxxx.ui.screens.clickgui.ModuleButton;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;

import java.awt.*;

public class ModeBox extends Component{
    private ModeSetting modeSet = (ModeSetting)setting;
    public ModeBox(Setting setting, ModuleButton parent, int offset) {
        super(setting, parent, offset);
        this.modeSet = (ModeSetting) setting;

    }
    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        int textOffset = ((parent.parent.height / 2) - mc.textRenderer.fontHeight / 2);
        DrawableHelper.fill(matrices, parent.parent.x, parent.parent.y + parent.offset + offset, parent.parent.x + parent.parent.width, parent.parent.y + parent.offset + offset + parent.parent.height, new Color(0, 0, 0,160).getRGB());
        mc.textRenderer.drawWithShadow(matrices, modeSet.getName() + ": " + modeSet.getMode(), parent.parent.x + textOffset, parent.parent.y + parent.offset + offset + textOffset, -1);
        super.render(matrices, mouseX, mouseY, delta);
    }
    @Override
    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (isHovered(mouseX, mouseY) && button == 0) {
            modeSet.cycle();
        }
        super.mouseClicked(mouseX, mouseY, button);
    }
}

