package fr.sithey.uhc.scenarios;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.Scenarios;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;

public class EnchantedDeath extends Scenarios implements Listener {

    private Main main = Main.getInstance();

    @EventHandler
    public void onCraft(PrepareItemCraftEvent e) {
        if ((GuiScenarioEnum.ENCHANTEDDEATH.isEnabled())) {
            if ((e.getInventory() instanceof CraftingInventory)) {
                CraftingInventory inv = e.getInventory();

                ItemStack AIR = new ItemStack(Material.AIR);
                if (inv.getResult().getType() == Material.ENCHANTMENT_TABLE) {
                    inv.setResult(AIR);
                }
            }
        }

    }
    @EventHandler
    public void onKill(PlayerDeathEvent event) {
        if (GuiScenarioEnum.ENCHANTEDDEATH.isEnabled()) {
            event.getEntity().getWorld().dropItem(event.getEntity().getLocation(), new ItemStack(Material.ENCHANTMENT_TABLE, 1));
        }
    }

    public void configure() {
        scenario = GuiScenarioEnum.ENCHANTEDDEATH;
    }


    public void activate(Player player) {
        org.bukkit.Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
    }

    public void execute() {
    }
}
