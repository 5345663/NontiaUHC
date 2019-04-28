package fr.sithey.uhc.scenarios;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.Scenarios;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PermaKill extends Scenarios implements Listener {

    public PermaKill() {
    }

    @EventHandler
    public void onDeath (PlayerDeathEvent event) {
        if (GuiScenarioEnum.PERMAKILL.isEnabled()) {
            if (Bukkit.getServer().getWorld("world").getTime() <= 13000) {
                Bukkit.getServer().getWorld("world").setTime(13000);
            } else {
                Bukkit.getServer().getWorld("world").setTime(0);
            }
        }
    }



    public void configure() {
        scenario = GuiScenarioEnum.PERMAKILL;
    }


    public void activate(Player player) {
        Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
    }

    public void execute() {
    }
}
