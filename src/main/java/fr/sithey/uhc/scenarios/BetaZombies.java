package fr.sithey.uhc.scenarios;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.Scenarios;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class BetaZombies extends Scenarios implements Listener {

    public BetaZombies() {
    }

    @EventHandler
    public void onLeavesDecayEvent(EntityDeathEvent e) {
        if (GuiScenarioEnum.BETAZOMBIES.isEnabled()) {
            Entity p = e.getEntity();
            if (p.getType() == EntityType.ZOMBIE) {
                p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.FEATHER, 1));
            }
        }
    }

    public void configure() {
        scenario = GuiScenarioEnum.BETAZOMBIES;
    }


    public void activate(Player player) {
        Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
    }

    public void execute() {
    }
}
