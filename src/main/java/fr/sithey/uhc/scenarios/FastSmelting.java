package fr.sithey.uhc.scenarios;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.Scenarios;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.block.Block;
import org.bukkit.block.Furnace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceBurnEvent;

public class FastSmelting extends Scenarios implements Listener {

    public FastSmelting() {
    }

    @EventHandler
    public void onBurn(FurnaceBurnEvent e) {
        if (GuiScenarioEnum.FASTSMELTING.isEnabled()) {
            Block b = e.getBlock();
            handleCookingTime((Furnace) e.getBlock().getState(), 4);
        }
    }


    private void handleCookingTime(final Furnace block, final int speed) {
        new org.bukkit.scheduler.BukkitRunnable() {
            public void run() {
                if ((block.getCookTime() > 0) || (block.getBurnTime() > 0)) {
                    block.setCookTime((short) (block.getCookTime() + speed));
                    block.update();
                } else {
                    cancel();
                }
            }
        }.runTaskTimer(Main.getInstance(), 1L, 1L);
    }

    public void configure() {
        scenario = GuiScenarioEnum.FASTSMELTING;
    }

    public void activate(Player player) {
        org.bukkit.Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
    }

    public void execute() {
    }
}
