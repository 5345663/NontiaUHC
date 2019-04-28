package fr.sithey.uhc.gui;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.CustomInventory;
import fr.sithey.uhc.utils.api.ItemCreator;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class Potion implements CustomInventory, Listener {
    @Override
    public String getName() {
        return "§4Nether";
    }

    @Override
    public Supplier<ItemStack[]> getContents(Player player) {
        ItemStack[] slots = new ItemStack[getSlots()];
        Stream.of(POTIONE.values()).forEach(netherto -> slots[netherto.getSlot()] = new ItemCreator(netherto.getMaterial()).setName("§8◆ §e" + netherto.getName() + " §8(" + (netherto.isEnabled() ? "§aon" : "§coff") + "§8)").getItem());

        slots[8] = new ItemCreator(Material.ARROW).setName("§cRetour").getItem();
        return () -> slots;
    }

    @Override
    public void onClick(Player player, Inventory inv, ItemStack current, int slot) {
        if (player.isOp() ||  player.getUniqueId() == Main.getInstance().games.host) {
            for (POTIONE netherto : POTIONE.values()) {
                if (current.getItemMeta().getDisplayName() != null && current.getItemMeta().getDisplayName().startsWith("§8◆ §e" + netherto.getName())) {
                    netherto.toggleEnabled();
                    Main.getInstance().gui.open(player, Potion.class);
                }
            }
        }


        switch (current.getType()) {
            default:
                break;

            case ARROW:
                Main.getInstance().gui.open(player, Configuration.class);
                break;
        }
    }

    @Override
    public int getRows() {
        return 1;
    }

    public enum POTIONE{
        POTION(0, true, "Potion", Material.BREWING_STAND_ITEM),
        REGEN(1, true, "Regeneration", Material.GHAST_TEAR),
        SPEED(2, true, "Speed", Material.SUGAR),
        STRENGTH(3, true, "Strength", Material.BLAZE_POWDER),
        POISON(4, true, "Poison", Material.FERMENTED_SPIDER_EYE),
        LVL(5, true, "Level II", Material.GLOWSTONE_DUST);





        private int slot;
        private boolean enabled;
        private String name;
        private Material material;

        POTIONE(int slot, boolean enabled, String name, Material material){
            this.slot = slot;
            this.enabled = enabled;
            this.name = name;
            this.material = material;
        }

        public int getSlot() {
            return this.slot;
        }

        public String getName() { return  this.name; }

        public Material getMaterial() { return  this.material; }


        public boolean isEnabled() {
            return this.enabled;
        }

        public void toggleEnabled() {
            this.enabled = !this.enabled;
        }

    }

    @EventHandler
    public void onClicked(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory inv = event.getInventory();
        ItemStack current = event.getCurrentItem();

        if (current == null) {
            return;
        }

        if (!Main.getInstance().isLobby()) {
            if (!POTIONE.POISON.isEnabled()) {
                if (current.isSimilar(new ItemCreator(POTIONE.POISON.getMaterial()).getItem())) {
                    event.setCurrentItem(new ItemCreator(Material.AIR).getItem());
                }
            }

            if (!POTIONE.REGEN.isEnabled()) {
                if (current.isSimilar(new ItemCreator(POTIONE.REGEN.getMaterial()).getItem())) {
                    event.setCurrentItem(new ItemCreator(Material.AIR).getItem());
                }
            }

            if (!POTIONE.SPEED.isEnabled()) {
                if (current.isSimilar(new ItemCreator(POTIONE.SPEED.getMaterial()).getItem())) {
                    event.setCurrentItem(new ItemCreator(Material.AIR).getItem());
                }
            }

            if (!POTIONE.STRENGTH.isEnabled()) {
                if (current.isSimilar(new ItemCreator(POTIONE.STRENGTH.getMaterial()).getItem())) {
                    event.setCurrentItem(new ItemCreator(Material.AIR).getItem());
                }
            }

            if (!POTIONE.LVL.isEnabled()) {
                if (current.isSimilar(new ItemCreator(POTIONE.LVL.getMaterial()).getItem())) {
                    {
                        event.setCurrentItem(new ItemCreator(Material.AIR).getItem());
                    }
                }
            }

            if (!POTIONE.POTION.isEnabled()) {
                if (current.isSimilar(new ItemCreator(POTIONE.POTION.getMaterial()).getItem())) {
                    {
                        event.setCurrentItem(new ItemCreator(Material.AIR).getItem());
                    }
                }
            }
        }
    }
}
