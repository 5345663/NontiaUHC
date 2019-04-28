package fr.sithey.uhc.gui;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.CustomInventory;
import fr.sithey.uhc.utils.api.ItemCreator;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.function.Supplier;

public class Special implements CustomInventory, Listener {
    private Main main = Main.getInstance();
    @Override
    public String getName() {
        return "§6Configuration Special";
    }

    @Override
    public Supplier<ItemStack[]> getContents(Player player) {
        ItemStack[] slots = new ItemStack[getSlots()];
        for (int i = 0; i <= 26; i++)
            slots [i] = new ItemCreator(Material.STAINED_GLASS_PANE).setDurability(0).setName("§8").getItem();
        slots[2] = new ItemCreator(Material.GOLD_SWORD).setName("§6Stalk "+ (SpecialE.STALK.isEnabled() ? "§a✔" : "§4✖")).getItem();
        slots[3] = new ItemCreator(Material.WOOD_AXE).setName("§6Build au centre "+ (SpecialE.BUILD.isEnabled() ? "§a✔" : "§4✖")).getItem();
        slots[4] = new ItemCreator(Material.BED).setName("§6Bed bombe "+ (SpecialE.BED.isEnabled() ? "§a✔" : "§4✖")).getItem();
        slots[5] = new ItemCreator(Material.ENCHANTED_BOOK).setName("§6Flame "+ (SpecialE.FLAME.isEnabled() ? "§a✔" : "§4✖")).getItem();
        slots[6] = new ItemCreator(Material.ENCHANTED_BOOK).setName("§6Fire aspect "+ (SpecialE.FIRE.isEnabled() ? "§a✔" : "§4✖")).getItem();
        slots[10] = new ItemCreator(Material.SKULL_ITEM).setDurability(2).setName("§6IPvP "+ (SpecialE.IPVP.isEnabled() ? "§a✔" : "§4✖")).getItem();
        slots[12] = new ItemCreator(Material.OBSIDIAN).setName("§6Camp portail "+ (SpecialE.CAMP.isEnabled() ? "§a✔" : "§4✖")).getItem();
        slots[13] = new ItemCreator(Material.LAVA_BUCKET).setName("§6Seau de lave "+ (SpecialE.LAVE.isEnabled() ? "§a✔" : "§4✖")).getItem();
        slots[14] = new ItemCreator(Material.FLINT_AND_STEEL).setName("§6Briquet "+ (SpecialE.BRIQUET.isEnabled() ? "§a✔" : "§4✖")).getItem();
        slots[16] = new ItemCreator(Material.SKULL_ITEM).setDurability(1).setName("§6Trap "+ (SpecialE.TRAP.isEnabled() ? "§a✔" : "§4✖")).setDurability(0).getItem();
        slots[22] = new ItemCreator(Material.GHAST_TEAR).setName("§6Spec "+ (SpecialE.SPEC.isEnabled() ? "§a✔" : "§4✖")).getItem();
        slots[26] = new ItemCreator(Material.ARROW).setName("§cRetour").getItem();

        return () -> slots;
    }

    @Override
    public void onClick(Player player, Inventory inv, ItemStack current, int slot) {
        if (player.isOp() || player.getUniqueId() == Main.getInstance().games.host) {
            if (current.getItemMeta().getDisplayName().contains("Stalk"))
                SpecialE.STALK.toggleEnabled();
            if (current.getItemMeta().getDisplayName().contains("Build"))
                SpecialE.BUILD.toggleEnabled();
            if (current.getItemMeta().getDisplayName().contains("Bed"))
                SpecialE.BED.toggleEnabled();
            if (current.getItemMeta().getDisplayName().contains("Flame"))
                SpecialE.FLAME.toggleEnabled();
            if (current.getItemMeta().getDisplayName().contains("Fire"))
                SpecialE.FIRE.toggleEnabled();
            if (current.getItemMeta().getDisplayName().contains("Camp"))
                SpecialE.CAMP.toggleEnabled();
            if (current.getItemMeta().getDisplayName().contains("lave"))
                SpecialE.LAVE.toggleEnabled();
            if (current.getItemMeta().getDisplayName().contains("Briquet"))
                SpecialE.BRIQUET.toggleEnabled();
            if (current.getItemMeta().getDisplayName().contains("Trap"))
                SpecialE.TRAP.toggleEnabled();
            if (current.getItemMeta().getDisplayName().contains("Spec"))
                SpecialE.SPEC.toggleEnabled();
            if (current.getItemMeta().getDisplayName().contains("IPvP"))
                SpecialE.IPVP.toggleEnabled();

            main.gui.open(player, Special.class);
        }
        switch (current.getType()) {
            default:
                break;
            case ARROW:
                main.gui.open(player, Configuration.class);
                break;

        }


    }

    @Override
    public int getRows() {
        return 3;
    }


    public enum SpecialE{
        STALK(false, "Stalk"),
        BUILD(false, "Build au centre"),
        BED(false, "Bed bombe"),
        FLAME(true, "Flame"),
        FIRE(true, "Fire aspect"),
        IPVP(false, "IPvP"),
        CAMP(false, "Camp portail"),
        LAVE(true, "Lave"),
        BRIQUET(true, "Briquet"),
        TRAP(true, "Trap"),
        SPEC(true, "Spectateur");
        private boolean enabled;
        private String name;
        SpecialE(boolean enabled, String name){
            this.enabled = enabled;
            this.name = name;
        }
        public boolean isEnabled() {
            return this.enabled;
        }
        public void toggleEnabled() { this.enabled = !this.enabled; }
        public String getName() {return name;}
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event){
        if (!SpecialE.BED.isEnabled())
            if (event.getPlayer().getLocation().getWorld().getName().equalsIgnoreCase("world_nether"))
            if (event.getItemInHand().getType().equals(Material.BED))
                event.setCancelled(true);
    }

    @EventHandler
    public void onEnch(EnchantItemEvent event){
        if (!SpecialE.FIRE.isEnabled())
            if (event.getEnchantsToAdd().containsKey(Enchantment.FIRE_ASPECT))
                event.setCancelled(true);

        if (!SpecialE.FLAME.isEnabled())
            if (event.getEnchantsToAdd().containsKey(Enchantment.ARROW_FIRE))
                event.setCancelled(true);
    }

    @EventHandler
    public void onLava(PlayerBucketEmptyEvent event){
        if (!SpecialE.LAVE.isEnabled())
        if (event.getBucket().toString().contains("LAVA"))
            event.setCancelled(true);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        if (!main.isLobby()) {
            if (!main.games.alive.contains(event.getPlayer().getUniqueId())) {
                Main.getInstance().getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                    @Override
                    public void run() {
                        if (!event.getPlayer().isOp()) {
                            if (!SpecialE.SPEC.isEnabled()) {
                                event.getPlayer().kickPlayer("§cSpectateur interdit");
                            }
                        }
                    }
                }, 10);
            }

        }

    }
}
