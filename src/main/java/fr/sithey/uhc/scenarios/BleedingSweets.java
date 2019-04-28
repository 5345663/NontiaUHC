package fr.sithey.uhc.scenarios;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.ItemCreator;
import fr.sithey.uhc.utils.api.Scenarios;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class BleedingSweets extends Scenarios implements Listener {

    public BleedingSweets() {
    }

    @EventHandler
    public void onPlayerKill(PlayerDeathEvent event) {
        if (GuiScenarioEnum.BLEEDINGSWEETS.isEnabled()) {

            event.getEntity().getPlayer().getWorld().dropItem(event.getEntity().getPlayer().getLocation(), new ItemCreator(Material.DIAMOND).getItem());
            event.getEntity().getPlayer().getWorld().dropItem(event.getEntity().getPlayer().getLocation(), new ItemCreator(Material.GOLD_INGOT).setAmount(5).getItem());
            event.getEntity().getPlayer().getWorld().dropItem(event.getEntity().getPlayer().getLocation(), new ItemCreator(Material.STRING).setAmount(1).getItem());
            event.getEntity().getPlayer().getWorld().dropItem(event.getEntity().getPlayer().getLocation(), new ItemCreator(Material.ARROW).setAmount(16).getItem());

        }

    }


    public void configure() {
        scenario = GuiScenarioEnum.BLEEDINGSWEETS;
    }


    public void activate(Player player) {
        Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
    }

    public void execute() {
    }
}
