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

public class NoSword extends Scenarios implements Listener {


    @EventHandler
    public void onCraft(PrepareItemCraftEvent e) {
        if ((GuiScenarioEnum.NOSWORD.isEnabled())) {
            if ((e.getInventory() instanceof CraftingInventory)) {
                CraftingInventory inv = e.getInventory();

                ItemStack AIR = new ItemStack(Material.AIR);
                if (inv.getResult().getType() == Material.STONE_SWORD) {
                    inv.setResult(AIR);
                }
                if (inv.getResult().getType() == Material.DIAMOND_SWORD) {
                    inv.setResult(AIR);
                }
                if (inv.getResult().getType() == Material.GOLD_SWORD) {
                    inv.setResult(AIR);
                }
                if (inv.getResult().getType() == Material.WOOD_SWORD) {
                    inv.setResult(AIR);
                }
                if (inv.getResult().getType() == Material.IRON_SWORD) {
                    inv.setResult(AIR);
                }
            }
        }

    }

    public void configure() {
        scenario = GuiScenarioEnum.NOSWORD;
    }


    @Override
    public void activate(Player player) {
        Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
    }

    public void execute() {
    }

}


