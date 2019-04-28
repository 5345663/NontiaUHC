package fr.sithey.uhc.scenarios;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.Scenarios;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CarrotCombo extends Scenarios implements Listener {


    @EventHandler
    public void onPrepareItemCraft(PrepareItemCraftEvent e) {
        if ((GuiScenarioEnum.CARROTCOMBO.isEnabled())) {
            Material itemType = e.getInventory().getResult().getType();
            switch (itemType) {
                case WOOD_SWORD: {
                    ItemStack lo1 = new ItemStack(Material.CARROT_ITEM);
                    ItemMeta lo1M = lo1.getItemMeta();
                    lo1M.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
                    lo1.setItemMeta(lo1M);
                    e.getInventory().setResult(lo1);
                    break;
                }
                case STONE_SWORD: {
                    ItemStack lo1 = new ItemStack(Material.CARROT_ITEM);
                    ItemMeta lo1M = lo1.getItemMeta();
                    lo1M.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
                    lo1.setItemMeta(lo1M);
                    e.getInventory().setResult(lo1);
                    break;
                }
                case GOLD_SWORD: {
                    ItemStack lo1 = new ItemStack(Material.CARROT_ITEM);
                    ItemMeta lo1M = lo1.getItemMeta();
                    lo1M.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
                    lo1.setItemMeta(lo1M);
                    e.getInventory().setResult(lo1);
                    break;
                }
                case IRON_SWORD: {
                    ItemStack lo1 = new ItemStack(Material.CARROT_ITEM);
                    ItemMeta lo1M = lo1.getItemMeta();
                    lo1M.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                    lo1.setItemMeta(lo1M);
                    e.getInventory().setResult(lo1);
                    break;
                }
                case DIAMOND_SWORD: {
                    ItemStack lo1 = new ItemStack(Material.CARROT_ITEM);
                    ItemMeta lo1M = lo1.getItemMeta();
                    lo1M.addEnchant(Enchantment.DAMAGE_ALL, 6, true);
                    lo1.setItemMeta(lo1M);
                    e.getInventory().setResult(lo1);
                    break;
                }
            }
        }
    }

    public void configure() {
        scenario = GuiScenarioEnum.CARROTCOMBO;
    }


    @Override
    public void activate(Player player) {
        Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
    }

    public void execute() {
    }

}



