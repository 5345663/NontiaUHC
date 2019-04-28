package fr.sithey.uhc.scenarios;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.Scenarios;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class NoFall extends Scenarios implements Listener {

    public NoFall() {
    }

    @org.bukkit.event.EventHandler
    public void onFallDMG(EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }

        if ((GuiScenarioEnum.NOFALL.isEnabled()) && (e.getCause() == DamageCause.FALL)) {
            e.setCancelled(true);
        }
    }

    public void configure() {
        scenario = GuiScenarioEnum.NOFALL;
    }


    public void activate(Player player) {
        org.bukkit.Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
    }

    public void execute() {
    }
}
