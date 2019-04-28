package fr.sithey.uhc.scenarios;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.Scenarios;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.Random;

public class BowSwap extends Scenarios implements Listener {
    private Main main = Main.getInstance();
    public BowSwap() {
    }

    @EventHandler
    public void onEntityDamageByEntity(final EntityDamageByEntityEvent event) {
        if (GuiScenarioEnum.BOWSWAP.isEnabled()) {
            Random r = new Random();
            int alea = r.nextInt(100);
            if (alea <= pourswap) {
                if (event.getEntity() instanceof Player && event.getDamager() instanceof Arrow && ((Arrow) event.getDamager()).getShooter() instanceof Player) {
                    final Location l1 = event.getEntity().getLocation();
                    final Location l2 = ((Player) ((Arrow) event.getDamager()).getShooter()).getLocation();
                    event.getEntity().teleport(l2);
                    ((Player) ((Arrow) event.getDamager()).getShooter()).teleport(l1);
                    ((Player) event.getEntity()).playSound(event.getEntity().getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 1.0f);
                    ((Player) ((Arrow) event.getDamager()).getShooter()).playSound(event.getDamager().getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 1.0f);
                }
            }
        }
    }


    public void configure() {
        scenario = GuiScenarioEnum.BOWSWAP;
    }


    public void activate(Player player) {
        Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
        player.sendMessage("§6 - /specialsc bowswap <" + main.games.pourswap + ">%");
    }

    public void execute() {
    }

    public int pourswap = 100;
}
