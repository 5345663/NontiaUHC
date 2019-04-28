package fr.sithey.uhc.scenarios;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.Scenarios;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;

public class NoBookShelf extends Scenarios implements Listener {

    public NoBookShelf() {
    }

    @EventHandler
    public void onCraft(PrepareItemCraftEvent e) {
        if ((GuiScenarioEnum.NOBOOKSHELF.isEnabled())) {
            if ((e.getInventory() instanceof CraftingInventory)) {
                CraftingInventory inv = e.getInventory();

                ItemStack AIR = new ItemStack(Material.AIR);
                if (inv.getResult().getType() == Material.BOOKSHELF ) {
                    inv.setResult(AIR);
                }
            }
        }

    }

    public void configure() {
        scenario = GuiScenarioEnum.NOBOOKSHELF  ; }

    public void activate(Player player) {
        Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
    }

    public void execute() {
    }

}
