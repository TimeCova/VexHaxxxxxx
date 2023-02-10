package me.sainte.vexhaxxxxxx.modules;

import me.sainte.vexhaxxxxxx.modules.settings.Setting;
import net.minecraft.client.MinecraftClient;

import java.util.ArrayList;
import java.util.List;

public class Mod {
    private String name;
    private String description;
    private String displayName;
    private Category category;
    private int key;
    private List<Setting> settings = new ArrayList<>();
    private boolean enabled;
    protected MinecraftClient mc = MinecraftClient.getInstance();

    public Mod(String name, String description, Category category){
        this.name = name;
        this.displayName = name;
        this.description = description;
        this.category = category;
    }

    public List<Setting> getSettings() {
        return settings;
    }
    public void addSetting(Setting setting){
        settings.add(setting);
    }
    public void addSettings(Setting... settings){
        for (Setting setting : settings) addSetting(setting);
    }

    public void toggle(){
        this.enabled = !this.enabled;
        if (enabled){
            onEnable();
        }else{
            onDisable();
        }
    }
    public void onEnable(){

    }
    public void onDisable(){

    }
    public void onTick(){

    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getName() {
        return name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        if (enabled){
            onEnable();
        }else{
            onDisable();
        }
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Category getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;

    }

    public enum Category{
        COMBAT("Combat"),
        MOVEMENT("Movement"),
        RENDER("Render"),
        EXPLOITS("Exploits"),
        WORLD("World");

        public String name;
        private Category(String name){
            this.name = name;
        }
    }
}
