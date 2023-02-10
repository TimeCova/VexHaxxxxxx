package me.sainte.vexhaxxxxxx.ui.screens.clickgui;

import me.sainte.vexhaxxxxxx.modules.Mod;
import me.sainte.vexhaxxxxxx.modules.settings.BooleanSetting;
import me.sainte.vexhaxxxxxx.modules.settings.ModeSetting;
import me.sainte.vexhaxxxxxx.modules.settings.NumberSetting;
import me.sainte.vexhaxxxxxx.modules.settings.Setting;
import me.sainte.vexhaxxxxxx.ui.screens.clickgui.setting.CheckBox;
import me.sainte.vexhaxxxxxx.ui.screens.clickgui.setting.Component;
import me.sainte.vexhaxxxxxx.ui.screens.clickgui.setting.ModeBox;
import me.sainte.vexhaxxxxxx.ui.screens.clickgui.setting.Slider;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class ModuleButton {
    public Mod module;
    public Frame parent;
    public boolean extended;
    public int offset;
    public List<Component> components;
    public ModuleButton(Mod module, int offset, Frame parent){
        this.module = module;
        this.parent = parent;
        this.extended = false;
        this.offset = offset;
        this.components = new ArrayList<>();
        int setOffset = parent.height;
        for (Setting setting : module.getSettings()){
            if (setting instanceof BooleanSetting){
                components.add(new CheckBox(setting, this, setOffset));
            }else if (setting instanceof ModeSetting){
                components.add(new ModeBox(setting, this, setOffset));
            }else if (setting instanceof NumberSetting){
                components.add(new Slider(setting, this, setOffset));
            }
            setOffset += parent.height;
        }
    }
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta){
        int textOffset = ((parent.height / 2) - parent.mc.textRenderer.fontHeight / 2);
        DrawableHelper.fill(matrices, parent.x, parent.y + offset, parent.x + parent.width, parent.y + offset + parent.height, new Color(0, 0, 0,220).getRGB());
        if (isHovered(mouseX, mouseY)) DrawableHelper.fill(matrices, parent.x, parent.y + offset, parent.x + parent.width, parent.y + offset + parent.height, new Color(0, 0, 0,220).getRGB());
        parent.mc.textRenderer.drawWithShadow(matrices, module.getName(), parent.x + textOffset, parent.y + offset + textOffset, module.isEnabled() ? Color.GREEN.getRGB() : -1);
        if (extended){
            for (Component component : components){
               component.render(matrices, mouseX, mouseY, delta);
            }
        }
    }

    public void mouseClicked(double mouseX, double mouseY, int button){
        if (isHovered(mouseX, mouseY)){
            if (button == 0){
                module.toggle();
            }else if (button == 1){
                extended = !extended;
                parent.updateButtons();
            }
        }
        for (Component component : components){
            component.mouseClicked(mouseX, mouseY, button);
        }
    }
    public void mouseReleased(double mouseX, double mouseY, int button){
        for (Component component : components){
            component.mouseReleased(mouseX, mouseY, button);

        }
    }
    public boolean isHovered(double mouseX, double mouseY){
        return mouseX > parent.x && mouseX < parent.x + parent.width && mouseY > parent.y + offset && mouseY < parent.y + offset + parent.height;
    }
}
