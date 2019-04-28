package fr.sithey.uhc.scenarios;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.Scenarios;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class FireLess extends Scenarios implements Listener {


    @EventHandler
    public void onFireDMG(EntityDamageEvent e) {
        if ((GuiScenarioEnum.FIRELESS.isEnabled())) {
            if (((e.getEntity() instanceof Player)) && ((e.getCause() == EntityDamageEvent.DamageCause.LAVA) || (e.getCause() == EntityDamageEvent.DamageCause.FIRE) || (e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK))) {
                e.setCancelled(true);
            }
        }
    }

    public void configure() {
        scenario = GuiScenarioEnum.FIRELESS;
    }


    @Override
    public void activate(Player player) {
        Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
    }

    public void execute() {
    }
}
