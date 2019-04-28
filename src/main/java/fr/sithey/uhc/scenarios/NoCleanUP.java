package fr.sithey.uhc.scenarios;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.Scenarios;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class NoCleanUP extends Scenarios implements Listener {

    public NoCleanUP() {
    }

    @EventHandler
    public void onPlayerKill(PlayerDeathEvent event) {
        if (GuiScenarioEnum.NOCLEANUP.isEnabled()) {
            if (event.getEntity().getKiller().getHealth() + Main.getInstance().games.healclean <= event.getEntity().getKiller().getMaxHealth())
                event.getEntity().getKiller().setHealth(event.getEntity().getKiller().getHealth() + Main.getInstance().games.healclean);
            else
                event.getEntity().getKiller().setHealth(event.getEntity().getKiller().getMaxHealth());
        }
    }


    public void configure() {
        scenario = GuiScenarioEnum.NOCLEANUP;
    }


    public void activate(Player player) {
        Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
        player.sendMessage("§6 -  /specialsc nocleanup <" + Main.getInstance().games.healclean + ">");
    }

    public void execute() {
    }

}
