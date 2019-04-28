package fr.sithey.uhc.scenarios;

import fr.sithey.uhc.utils.api.Scenarios;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class LongShot extends Scenarios {

    @EventHandler
    public void onEntityDamageByEntity(final EntityDamageByEntityEvent e) {
        if (e.isCancelled()) {
            return;
        }
        if (!GuiScenarioEnum.LONGSHOTS.isEnabled()) {
            return;
        }
        if (!(e.getDamager() instanceof Projectile) || !(e.getEntity() instanceof Player)) {
            return;
        }
        final Player p = (Player)e.getEntity();
        final Arrow damager = (Arrow)e.getDamager();
        if (!(damager.getShooter() instanceof Player)) {
            return;
        }
        final Player k = (Player)damager.getShooter();
        final double distance = k.getLocation().distance(p.getLocation());
        if (distance >= 75.0) {
            p.damage(3.0);
            if (k.getHealth() > 18.0) {
                k.setHealth(20.0);
            }
            else {
                k.setHealth(k.getHealth() + 2.0);
            }
        }

    }



    public void configure() {
        scenario = GuiScenarioEnum.LONGSHOTS;
    }


    public void activate(Player player) {
    }

    public void execute() {
    }

}
