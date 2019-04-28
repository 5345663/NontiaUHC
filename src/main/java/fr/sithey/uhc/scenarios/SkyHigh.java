package fr.sithey.uhc.scenarios;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.ItemCreator;
import fr.sithey.uhc.utils.api.Scenarios;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class SkyHigh extends Scenarios implements Listener {

    private Main main = Main.getInstance();


    @EventHandler
    public void place(BlockPlaceEvent ev) {
        if (GuiScenarioEnum.SKYHIGH.isEnabled()) {
            Block b = ev.getBlock();
            Player p = ev.getPlayer();
            if (b.getType() == Material.DIRT)
                    p.getInventory().setItemInHand(new ItemCreator(Material.DIRT).setAmount(3).getItem());
        }
    }



    public void configure() {
        scenario = GuiScenarioEnum.SKYHIGH;
    }


    public void activate(Player player) {
                org.bukkit.Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
        player.sendMessage("§6 - /specialsc skyhigh <" + main.games.skyhigh / 60 + ">(minutes) <" + main.games.skydamage + ">  <" + main.games.skydtime / 20 + ">");

    }

    public void execute() {
    }


    
}


