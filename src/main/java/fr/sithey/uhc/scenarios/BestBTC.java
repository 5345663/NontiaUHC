package fr.sithey.uhc.scenarios;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.Scenarios;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class BestBTC extends Scenarios implements Listener {

    public void configure() {
        scenario = GuiScenarioEnum.BESTBTC;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event){
        if (GuiScenarioEnum.BESTBTC.isEnabled()){
            if (Main.getInstance().games.bestbtc.contains(event.getPlayer().getUniqueId())) {
                if (event.getPlayer().getLocation().getY() > 50) {
                    Main.getInstance().games.bestbtc.remove(event.getPlayer().getUniqueId());
                    event.getPlayer().sendMessage(Main.getInstance().games.prefix + "Tu es de retiré de la 'liste BTC'");
                }
            }

        }
    }
    @EventHandler
    public void onMine(BlockBreakEvent event){
        if (GuiScenarioEnum.BESTBTC.isEnabled()){
            if (event.getBlock().getType().equals(Material.DIAMOND_ORE)){
                if (!Main.getInstance().games.bestbtc.contains(event.getPlayer().getUniqueId())) {
                    event.getPlayer().sendMessage(Main.getInstance().games.prefix + "Tu es de nouveau ajouté dans la 'liste BTC'");
                    Main.getInstance().games.bestbtc.add(event.getPlayer().getUniqueId());
                }
            }
        }
    }

    public void activate(Player player) {
        org.bukkit.Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
    }

    public void execute() {
    }

}
