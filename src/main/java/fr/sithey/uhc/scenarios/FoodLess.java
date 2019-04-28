package fr.sithey.uhc.scenarios;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.Scenarios;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodLess extends Scenarios implements Listener {

    @EventHandler

    public void hunger(FoodLevelChangeEvent ev) {
        if ((GuiScenarioEnum.FOODLESS.isEnabled())) {
            ev.setCancelled(true);
        }
    }

    public void configure() {
        scenario = GuiScenarioEnum.FOODLESS;
    }


    @Override
    public void activate(Player player) {
        Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
    }

    public void execute() {
    }

}



