package me.sainte.vexhaxxxxxx.ui.screens.clickgui.setting;

import me.sainte.vexhaxxxxxx.modules.settings.BooleanSetting;
import me.sainte.vexhaxxxxxx.modules.settings.Setting;
import me.sainte.vexhaxxxxxx.ui.screens.clickgui.ModuleButton;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;

import java.awt.*;

public class CheckBox extends Component{
    private BooleanSetting boolSet = (BooleanSetting)setting;
    public CheckBox(Setting setting, ModuleButton parent, int offset) {
        super(setting, parent, offset);
        this.boolSet = (BooleanSetting)setting;
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        int textOffset = ((parent.parent.height / 2) - mc.textRenderer.fontHeight / 2);
        DrawableHelper.fill(matrices, parent.parent.x, parent.parent.y + parent.offset + offset, parent.parent.x + parent.parent.width, parent.parent.y + parent.offset + offset + parent.parent.height, new Color(0, 0, 0,160).getRGB());
        mc.textRenderer.drawWithShadow(matrices, boolSet.getName() + ": " + boolSet.isEnabled(), parent.parent.x + textOffset, parent.parent.y + parent.offset + offset + textOffset, -1);
        super.render(matrices, mouseX, mouseY, delta);
    }
    @Override
    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (isHovered(mouseX, mouseY) && button == 0) {
            boolSet.toggle();
        }
        super.mouseClicked(mouseX, mouseY, button);
    }
}
