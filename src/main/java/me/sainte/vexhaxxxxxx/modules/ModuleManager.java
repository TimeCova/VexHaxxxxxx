package me.sainte.vexhaxxxxxx.modules;

import me.sainte.vexhaxxxxxx.modules.exploits.CancelMovement;
import me.sainte.vexhaxxxxxx.modules.movement.*;
import me.sainte.vexhaxxxxxx.modules.Mod;
import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    public static final ModuleManager INSTANCE = new ModuleManager();
    private List<Mod> modules = new ArrayList<>();
    public ModuleManager(){
        addModules();
    }
    public List<Mod> getModules() {
        return modules;
    }

    public List<Mod> getEnabledModules() {
        List<Mod> enabled = new ArrayList<>();
        for (Mod module : modules){
            if (module.isEnabled()) enabled.add(module);
        }
        return enabled;
    }
    public List<Mod> getModulesInCategory(Mod.Category category){
        List<Mod> categoryModules = new ArrayList<>();
        for (Mod mod : modules){
            if (mod.getCategory() == category){
                categoryModules.add(mod);

            }
        }
        return categoryModules;
    }
    private void addModules(){
        modules.add(new Flight());
        modules.add(new Sprint());
        modules.add(new CancelMovement());
    }

}
