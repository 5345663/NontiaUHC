package fr.sithey.uhc.utils.register;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.gui.*;
import fr.sithey.uhc.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class Listeners {
    private Main main = Main.getInstance();

    public void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new Join(), main);
        pm.registerEvents(new Food(), main);
        pm.registerEvents(new Inventory(), main);
        pm.registerEvents(new Special(), main);
        pm.registerEvents(new Configuration(), main);
        pm.registerEvents(new Monde(), main);
        pm.registerEvents(new Damage(), main);
        pm.registerEvents(new Team(), main);
        pm.registerEvents(new Death(), main);
        pm.registerEvents(new Chat(), main);
        pm.registerEvents(new Other(), main);
        pm.registerEvents(new Potion(), main);
    }
}
