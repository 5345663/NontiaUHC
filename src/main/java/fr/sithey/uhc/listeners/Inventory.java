package fr.sithey.uhc.listeners;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.gui.Configuration;
import fr.sithey.uhc.gui.Special;
import fr.sithey.uhc.gui.Team;
import fr.sithey.uhc.gui.scenarios.Scenario1;
import fr.sithey.uhc.gui.teams.TC1;
import fr.sithey.uhc.utils.api.ItemCreator;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Inventory implements Listener {
    private Main main = Main.getInstance();
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack item = event.getItem();
        Material mat = event.getMaterial();

        if (main.isLobby()) {
            if (action.equals(Action.PHYSICAL) || item == null || mat.equals(Material.AIR))
                return;
            
            if (mat.equals(Material.BANNER)) {
                if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {
                    if (!Team.TeamsE.RANDOM.isEnabled() && Main.getInstance().games.maxparteams > 1)
                    main.gui.open(player, TC1.class);
                }
            }
            if (mat.equals(Material.REDSTONE_COMPARATOR)) {
                if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {
                    main.gui.open(player, Configuration.class);
                }
            }
            if (mat.equals(Material.ANVIL)) {
                if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {
                    main.gui.open(player, Scenario1.class);
                }
            }

            if (GuiScenarioEnum.ONEHEAL.isEnabled()) {
                if (event.getItem().getType().equals(Material.GOLD_HOE) && event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("OneHeal")) {
                    if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK) || event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
                        event.getPlayer().setHealth(event.getPlayer().getMaxHealth());
                        event.getPlayer().setItemInHand(new ItemCreator(Material.AIR).getItem());
                    }
                }
            }

            if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK))
                if (!Special.SpecialE.BRIQUET.isEnabled())
                    if (event.getItem().getType().equals(Material.FLINT_AND_STEEL))
                        event.setCancelled(true);

        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        Player entity = event.getPlayer();
        World world = entity.getWorld();

        if (world.getName().equalsIgnoreCase("spawn")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        org.bukkit.inventory.Inventory inv = event.getInventory();
        ItemStack current = event.getCurrentItem();

        if (current == null) {
            return;
        }

        if (main.isLobby()){
            if (player.getGameMode().equals(GameMode.ADVENTURE))
            event.setCancelled(true);
        }
        
        main.gui.registeredMenus.values().stream().filter(menu -> inv.getName().equalsIgnoreCase(menu.getName()))
                .forEach(menu -> {
                    menu.onClick(player, inv, current, event.getSlot());
                    event.setCancelled(true);
                });
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        Player entity = event.getPlayer();
        World world = entity.getWorld();

        if (world.getName().equalsIgnoreCase("spawn")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player entity = event.getPlayer();
        World world = entity.getWorld();

        if (world.getName().equalsIgnoreCase("spawn")) {
            event.setCancelled(true);
        }
    }
}
