package fr.sithey.uhc.scenarios;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.Scenarios;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class NineSlots extends Scenarios implements Listener {


    @EventHandler
    public void onClick (InventoryClickEvent event){
        ItemStack current = event.getCurrentItem();

        if (current.getType().equals(Material.BEDROCK)){
            event.setCancelled(true);
        }
    }


    public void configure() {
        scenario = GuiScenarioEnum.NINESLOTS;
    }

    @Override
    public void activate(Player player) {
        Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
    }

    public void execute() {
    }

}



