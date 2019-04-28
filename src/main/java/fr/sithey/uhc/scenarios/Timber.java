package fr.sithey.uhc.scenarios;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.Scenarios;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class Timber extends Scenarios implements Listener {


    @EventHandler
    public void onCut(BlockBreakEvent e) {
        if ((GuiScenarioEnum.TIMBER.isEnabled())) {
            if (e.getBlock().getType() == Material.LOG) {
                {
                    e.setCancelled(true);
                    boolean inWood = false;
                    int count = 0;

                    for (int y = -13; y <= 13; y++) {
                        for (int z = -3; z <= 3; z++) {
                            for (int x = -3; x <= 3; x++) {
                                Location loc = e.getBlock().getLocation().add(x, y, z);
                                if ((loc.getBlock().getType() == Material.LOG) || (loc.getBlock().getType() == Material.LOG_2)) {
                                    count++;
                                    if (!inWood) {
                                        inWood = true;
                                    }
                                    loc.getBlock().breakNaturally();
                                }
                            }
                        }
                    }
                }
            }
            if (e.getBlock().getType() == Material.LOG_2) {
                {
                    e.setCancelled(true);
                    boolean inWood = false;
                    int count = 0;

                    for (int y = -13; y <= 13; y++) {
                        for (int z = -3; z <= 3; z++) {
                            for (int x = -3; x <= 3; x++) {
                                Location loc = e.getBlock().getLocation().add(x, y, z);
                                if ((loc.getBlock().getType() == Material.LOG) || (loc.getBlock().getType() == Material.LOG_2)) {
                                    count++;
                                    if (!inWood) {
                                        inWood = true;
                                    }
                                    loc.getBlock().breakNaturally();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void configure() {
        scenario = GuiScenarioEnum.TIMBER;
    }


    @Override
    public void activate(Player player) {
        Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
    }

    public void execute() {
    }
}
