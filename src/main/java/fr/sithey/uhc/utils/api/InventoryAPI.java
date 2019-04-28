package fr.sithey.uhc.utils.api;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryAPI {
    Player player;
    Inventory inv;
    World world;
    org.bukkit.Location loc;

    public InventoryAPI(Player p, Inventory invv) {
        player = p;
        inv = invv;
    }

    private static ItemStack[] items = new ItemStack[40];

    public ItemStack[] getItems() {
        return items;
    }


    public void saveInventory() {
        for (int slot = 0; slot < 36; slot++) {
            ItemStack item = player.getInventory().getItem(slot);
            if (item != null) {
                items[slot] = item;
            }
        }

        items[36] = player.getInventory().getHelmet();
        items[37] = player.getInventory().getChestplate();
        items[38] = player.getInventory().getLeggings();
        items[39] = player.getInventory().getBoots();

        player.getInventory().clear();
        player.getInventory().setHelmet(null);
        player.getInventory().setChestplate(null);
        player.getInventory().setLeggings(null);
        player.getInventory().setBoots(null);
    }


    public void giveInvent() {
        player.getInventory().clear();

        for (int slot = 0; slot < 36; slot++) {
            ItemStack item = items[slot];
            if (item != null) {
                player.getInventory().setItem(slot, item);
            }
        }

        player.getInventory().setHelmet(items[36]);
        player.getInventory().setChestplate(items[37]);
        player.getInventory().setLeggings(items[38]);
        player.getInventory().setBoots(items[39]);
    }

    public void giveforInv(Player player){
        inv = Bukkit.createInventory(null, 9 * 5, "§7§l◆ §6StarterInventory §7§l◆");
        for (int slot = 0; slot < 36; slot++) {
            ItemStack item = items[slot];
            if (item != null) {
                inv.setItem(slot, item);
            }
        }
        inv.setItem(36, items[36]);
        inv.setItem(37, items[37]);
        inv.setItem(38, items[38]);
        inv.setItem(39, items[39]);

        player.openInventory(inv);
    }
}
