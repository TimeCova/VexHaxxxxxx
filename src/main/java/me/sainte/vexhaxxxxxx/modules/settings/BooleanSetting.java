package me.sainte.vexhaxxxxxx.modules.settings;

public class BooleanSetting extends Setting{
    private boolean enabled = true;
    public BooleanSetting(String name, boolean defaultValue){
        super(name);
        this.enabled = defaultValue;
    }
    public void toggle(){
        this.enabled = !this.enabled;
    }
    public boolean isEnabled(){
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}

