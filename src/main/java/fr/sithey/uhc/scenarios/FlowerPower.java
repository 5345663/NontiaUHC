package fr.sithey.uhc.scenarios;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.ItemCreator;
import fr.sithey.uhc.utils.api.Scenarios;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.Random;

public class FlowerPower extends Scenarios implements Listener {

    @EventHandler
    public void onBreak(final BlockBreakEvent e) {
        if (e.isCancelled()) {
            return;
        }
        if (!GuiScenarioEnum.FLOWERPOWER.isEnabled()) {
            return;
        }
        if (this.getRandomMaterial() != Material.BARRIER || this.getRandomMaterial() != Material.BEDROCK || this.getRandomMaterial() != Material.ENDER_PORTAL) {
            if (e.getBlock().getType().equals(Material.RED_ROSE) || e.getBlock().getType().equals(Material.YELLOW_FLOWER)) {
                e.getBlock().setType(Material.AIR);
                e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemCreator(this.getRandomMaterial()).setAmount(new Random().nextInt(63) + 1).getItem());
            }
        }
    }

    private Material getRandomMaterial() {
        final int index = new Random().nextInt(Material.values().length);
        return Material.values()[index];
    }


    public void configure() {
        scenario = GuiScenarioEnum.FLOWERPOWER;
    }


    public void activate(Player player) {
        org.bukkit.Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
    }

    public void execute() {
    }

}
