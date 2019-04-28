package fr.sithey.uhc.scenarios;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.Scenarios;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class GoldLimite extends Scenarios implements Listener {

    private Main main = Main.getInstance();

    @EventHandler(priority = EventPriority.LOW)
    public void brek(BlockBreakEvent event) {
        if (GuiScenarioEnum.GOLDLIMITE.isEnabled()) {
            if (event.getBlock().getType().equals(Material.GOLD_ORE)){
                if (main.stats.gold.get(event.getPlayer().getUniqueId()) == null){
                    return;
                }
                if (main.stats.gold.get(event.getPlayer().getUniqueId()) <= main.games.goldlimite )
                main.stats.gold.put(event.getPlayer().getUniqueId(), main.stats.gold.get(event.getPlayer().getUniqueId()) + 1);
                else event.setCancelled(true);
            }
        }
    }

    public void configure() {
        scenario = GuiScenarioEnum.GOLDLIMITE;
    }

    public void activate(Player player) {
        Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
        player.sendMessage("§6 - /specialsc goldlimite <" + main.games.goldlimite + ">");
    }

    public void execute() {
    }

}
