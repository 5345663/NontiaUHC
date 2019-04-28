package fr.sithey.uhc.gui;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.CustomInventory;
import fr.sithey.uhc.utils.api.ItemCreator;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.spigotmc.event.entity.EntityMountEvent;

import java.util.Random;
import java.util.function.Supplier;

public class Monde implements CustomInventory, Listener {
    private Main main = Main.getInstance();
    @Override
    public String getName() {
        return "§6Configuration Monde";
    }

    @Override
    public Supplier<ItemStack[]> getContents(Player player) {
        ItemStack[] slots = new ItemStack[getSlots()];
        for (int i = 0; i <= 26; i++)
            slots [i] = new ItemCreator(Material.STAINED_GLASS_PANE).setDurability(0).setName("§8").getItem();
        slots[2] = new ItemCreator(Material.APPLE).setName("§6Taux de pommes : " + main.games.applerate).getItem();
        slots[3] = new ItemCreator(Material.GOLDEN_APPLE).setName("§6Taux de pommes en or : " + main.games.gapplerate ).getItem();
        slots[4] = new ItemCreator(Material.GOLDEN_CARROT).setName("§cSoon").getItem();
        slots[5] = new ItemCreator(Material.FLINT).setName("§6Taux de flint "+ main.games.flintrate).getItem();
        slots[6] = new ItemCreator(Material.ENDER_PEARL).setName("§6Degat de pearl "+ main.games.damagepearl).getItem();
        slots[12] = new ItemCreator(Material.SADDLE).setName("§6Chevaux "+ (main.games.getHorse() ? "§a✔" : "§4✖")).getItem();
        slots[13] = new ItemCreator(Material.SKULL_ITEM).setDurability(1).setName("§c(Soon)").getItem();
        slots[14] = new ItemCreator(Material.WATCH).setName("§c(Soon) ").getItem();
        slots[22] = new ItemCreator(Material.ARROW).setName("§cRetour").getItem();

        return () -> slots;
    }

    @Override
    public void onClick(Player player, Inventory inv, ItemStack current, int slot) {
        switch (current.getType()) {
            default:
                break;

            case SADDLE:
                if (player.isOp()|| player.getUniqueId() == Main.getInstance().games.host) {
                    main.games.toggleHorse();
                    main.gui.open(player, Monde.class);
                }
                break;
        }
        main.gui.open(player, Monde.class);
    }

    @Override
    public int getRows() {
        return 3;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){
            if (event.getInventory().getName().equalsIgnoreCase("§6Configuration Monde")) {
                if (event.getCurrentItem().getType().equals(Material.ARROW))
                    main.gui.open((Player) event.getWhoClicked(), Configuration.class);
                if (event.getWhoClicked().isOp() ||  event.getWhoClicked().getUniqueId() == Main.getInstance().games.host) {
                    if (event.getCurrentItem().getType().equals(Material.APPLE)) {
                    if (event.getClick().isLeftClick()) {
                        int i = main.games.applerate - 1;
                        if (i >= 0)
                            main.games.applerate = i;
                    }
                    if (event.getClick().isRightClick()) {
                        int i = main.games.applerate + 1;
                        if (i >= 0)
                            main.games.applerate = i;
                    }
                }
                if (event.getCurrentItem().getType().equals(Material.FLINT)) {
                    if (event.getClick().isLeftClick())
                        if (main.games.flintrate - 1 >= 0)
                            main.games.flintrate = main.games.flintrate - 1;
                    if (event.getClick().isRightClick())
                        if (main.games.flintrate + 1 >= 0)
                            main.games.flintrate = main.games.flintrate + 1;
                }
                if (event.getCurrentItem().getType().equals(Material.GOLDEN_APPLE)) {
                    if (event.getClick().isLeftClick())
                        if (main.games.gapplerate - 0.1 >= 0)
                            main.games.gapplerate = main.games.gapplerate - 0.1;
                    if (event.getClick().isRightClick())
                        if (main.games.gapplerate + 0.1 >= 0)
                            main.games.gapplerate = main.games.gapplerate + 0.1;
                }
                if (event.getCurrentItem().getType().equals(Material.ENDER_PEARL)) {
                    if (event.getClick().isLeftClick())
                        if (main.games.damagepearl - 0.5 >= 0)
                            main.games.damagepearl = main.games.damagepearl - 0.5;
                    if (event.getClick().isRightClick())
                        if (main.games.damagepearl + 0.5 >= 0)
                            main.games.damagepearl = main.games.damagepearl + 0.5;
                }
            }
        }
    }

    @EventHandler
    public void appleRate(LeavesDecayEvent event) {
        final Block b = event.getBlock();
        final Location loc = new Location(b.getWorld(), b.getLocation().getBlockX() + 0.0, b.getLocation().getBlockY() + 0.0, b.getLocation().getBlockZ() + 0.0);
        final Random random = new Random();
        final double r = random.nextDouble();
        if (r <= main.games.applerate * 0.01 && b.getType() == Material.LEAVES) {
            b.setType(Material.AIR);
            b.getWorld().dropItemNaturally(loc, new ItemStack(Material.APPLE, 1));
        }
        if (r <= main.games.gapplerate * 0.01 && b.getType() == Material.LEAVES) {
            b.setType(Material.AIR);
            b.getWorld().dropItemNaturally(loc, new ItemStack(Material.GOLDEN_APPLE, 1));
        }
    }

    @EventHandler
    public void onBlockBreakEvent(final BlockBreakEvent e) {
        final Block Block = e.getBlock();
        final Location loc = new Location(Block.getWorld(), (double) (Block.getLocation().getBlockX() + 0.0f), (double) (Block.getLocation().getBlockY() + 0.0f), (double) (Block.getLocation().getBlockZ() + 0.0f));
        final Random random = new Random();
        final double r = random.nextDouble();

        if (r <= main.games.applerate * 0.01 && Block.getType() == Material.LEAVES && !e.getPlayer().getItemInHand().equals((Object) Material.SHEARS)) {
            Block.setType(Material.AIR);
            Block.getWorld().dropItemNaturally(loc, new ItemStack(Material.APPLE));
        }
        if (r<= main.games.flintrate * 0.001 && Block.getType() == Material.GRAVEL){
            Block.setType(Material.AIR);
            Block.getWorld().dropItemNaturally(loc, new ItemStack(Material.FLINT));
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event){
        if (!(event instanceof Player))
            return;

        if (((Player) event).getItemInHand().getType().equals(Material.ENDER_PEARL)){
            event.setCancelled(true);
            event.setDamage(main.games.damagepearl);
        }
    }

    @EventHandler
    public void onEntityMount(final EntityMountEvent event) {
        if (event.getEntity() != null && event.getEntity() instanceof Player && event.getMount() != null && event.getMount() instanceof Horse && main.games.getHorse()) {
            event.setCancelled(true);
        }
    }



}
