package fr.sithey.uhc.scenarios;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.Scenarios;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class WebCage extends Scenarios implements Listener {

    public WebCage() {
    }

    @org.bukkit.event.EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerDeath(PlayerDeathEvent e) {
        if ((GuiScenarioEnum.WEBCAGE.isEnabled()) && ((e.getEntity() instanceof Player))) {
            Player p = e.getEntity();
            if (p.getWorld().equals(Bukkit.getWorld("octogone"))) {
                p.getWorld().getBlockAt(p.getLocation().add(3.0D, 0.0D, 0.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(3.0D, 1.0D, 0.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(3.0D, 2.0D, 0.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(0.0D, 0.0D, 3.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(0.0D, 1.0D, 3.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(0.0D, 2.0D, 3.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(-3.0D, 0.0D, 0.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(-3.0D, 1.0D, 0.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(-3.0D, 2.0D, 0.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(0.0D, 0.0D, -3.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(0.0D, 1.0D, -3.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(0.0D, 2.0D, -3.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(2.0D, 0.0D, 2.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(2.0D, 1.0D, 2.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(2.0D, 2.0D, 2.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(-2.0D, 0.0D, 2.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(-2.0D, 1.0D, 2.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(-2.0D, 2.0D, 2.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(-2.0D, 0.0D, -2.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(-2.0D, 1.0D, -2.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(-2.0D, 2.0D, -2.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(2.0D, 0.0D, -2.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(2.0D, 1.0D, -2.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(2.0D, 2.0D, -2.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(3.0D, 0.0D, 1.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(3.0D, 1.0D, 1.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(3.0D, 2.0D, 1.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(1.0D, 0.0D, 3.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(1.0D, 1.0D, 3.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(-3.0D, 0.0D, 1.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(-3.0D, 1.0D, 1.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(-3.0D, 2.0D, 1.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(1.0D, 0.0D, -3.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(1.0D, 1.0D, -3.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(1.0D, 2.0D, -3.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(3.0D, 0.0D, -1.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(3.0D, 1.0D, -1.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(3.0D, 2.0D, -1.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(-1.0D, 0.0D, 3.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(-1.0D, 1.0D, 3.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(-1.0D, 2.0D, 3.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(-3.0D, 0.0D, -1.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(-3.0D, 1.0D, -1.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(-3.0D, 2.0D, -1.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(-1.0D, 0.0D, -3.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(-1.0D, 1.0D, -3.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(-1.0D, 2.0D, -3.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(-1.0D, 3.0D, -2.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(-1.0D, 3.0D, -1.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(-1.0D, 3.0D, 0.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(-1.0D, 3.0D, 2.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(-1.0D, 3.0D, 1.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(0.0D, 3.0D, -1.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(1.0D, 3.0D, 2.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(1.0D, 3.0D, 1.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(1.0D, 3.0D, 0.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(1.0D, 3.0D, -2.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(1.0D, 3.0D, -1.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(0.0D, 3.0D, 1.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(2.0D, 3.0D, 1.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(-2.0D, 3.0D, 1.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(2.0D, 3.0D, -1.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(-2.0D, 3.0D, -1.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(2.0D, 3.0D, 0.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(-2.0D, 3.0D, 0.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(0.0D, 3.0D, 2.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(0.0D, 3.0D, -2.0D)).setType(Material.WEB);
                p.getWorld().getBlockAt(p.getLocation().add(0.0D, 3.0D, 0.0D)).setType(Material.WEB);
            }
        }
    }

    public void configure() {
        scenario = GuiScenarioEnum.WEBCAGE;
    }


    public void activate(Player player) {
        Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
    }

    public void execute() {
    }
}
