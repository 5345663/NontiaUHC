package fr.sithey.uhc.gui;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.CustomInventory;
import fr.sithey.uhc.utils.api.ItemCreator;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.function.Supplier;

public class Minage implements CustomInventory {
    @Override
    public String getName() {
        return "§6Configuration Minage";
    }

    @Override
    public Supplier<ItemStack[]> getContents(Player player) {
        ItemStack[] slots = new ItemStack[getSlots()];
        for (int i = 0; i <= 26; i++)
            slots [i] = new ItemCreator(Material.STAINED_GLASS_PANE).setDurability(0).setName("§8").getItem();
        slots[1] = new ItemCreator(Material.WOOL).setDurability(14).setName("§4Strip mine").getItem();
        slots[3] = new ItemCreator(Material.WOOL).setDurability(14).setName("§4Poke hole").getItem();
        slots[5] = new ItemCreator(Material.WOOL).setDurability(14).setName("§4Roller coaster").getItem();
        slots[7] = new ItemCreator(Material.WOOL).setDurability(14).setName("§4Minage optimisé").getItem();
        slots[19] = new ItemCreator(Material.WOOL).setDurability(5).setName("§aStrip mine").getItem();
        slots[21] = new ItemCreator(Material.WOOL).setDurability(5).setName("§aPoke hole").getItem();
        slots[23] = new ItemCreator(Material.WOOL).setDurability(5).setName("§aRoller coaster").getItem();
        slots[25] = new ItemCreator(Material.WOOL).setDurability(5).setName("§aMinage optimisé").getItem();
        slots[10] = new ItemCreator(Material.WOOD_PICKAXE).setName("§6Strip mine " + (MinageE.STRIP.isEnabled() ? "§a✔" : "§4✖")).getItem();
        slots[12] = new ItemCreator(Material.STONE_PICKAXE).setName("§6Poke hole "+ (MinageE.POKE.isEnabled() ? "§a✔" : "§4✖")).getItem();
        slots[14] = new ItemCreator(Material.IRON_PICKAXE).setName("§6Roller coaster "+ (MinageE.ROLLER.isEnabled() ? "§a✔" : "§4✖")).getItem();
        slots[16] = new ItemCreator(Material.DIAMOND_PICKAXE).setName("§6Minage optimisé "+ (MinageE.OPTI.isEnabled() ? "§a✔" : "§4✖")).getItem();
        return () -> slots;
    }

    @Override
    public void onClick(Player player, Inventory inventory, ItemStack current, int slot) {
        if (player.isOp() || player.getUniqueId() == Main.getInstance().games.host) {
            if (current.getItemMeta().getDisplayName().equals("§4Strip mine"))
                MinageE.STRIP.remEnabled();
            if (current.getItemMeta().getDisplayName().equals("§4Poke hole"))
                MinageE.POKE.remEnabled();
            if (current.getItemMeta().getDisplayName().equals("§4Roller coaster"))
                MinageE.ROLLER.remEnabled();
            if (current.getItemMeta().getDisplayName().equals("§4Minage optimisé"))
                MinageE.OPTI.remEnabled();

            if (current.getItemMeta().getDisplayName().equals("§aStrip mine"))
                MinageE.STRIP.setEnabled();
            if (current.getItemMeta().getDisplayName().equals("§aPoke hole"))
                MinageE.POKE.setEnabled();
            if (current.getItemMeta().getDisplayName().equals("§aRoller coaster"))
                MinageE.ROLLER.setEnabled();
            if (current.getItemMeta().getDisplayName().equals("§aMinage optimisé"))
                MinageE.OPTI.setEnabled();
            Main.getInstance().gui.open(player, Minage.class);

        }
        switch (current.getType()) {
            default:
                break;

        }
    }


    @Override
    public int getRows() {
        return 3;
    }

    public enum MinageE{
        STRIP(true, "Strip Mining"),
        POKE(true, "Poke Hole"),
        ROLLER(true, "Roller Coaster"),
        OPTI(true, "Minage Optimisé");

        private boolean enabled;
        private String name;
        MinageE(boolean enabled, String name){
            this.enabled = enabled; this.name = name;
        }
        public String getName() {return name;}
        public boolean isEnabled() {
            return this.enabled;
        }
        public void setEnabled() { this.enabled = true;}
        public void remEnabled() { this.enabled = false;}

    }
}
