package fr.sithey.uhc.gui;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.teams.Teams;
import fr.sithey.uhc.utils.api.CustomInventory;
import fr.sithey.uhc.utils.api.ItemCreator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Scoreboard;

import java.util.function.Supplier;

public class Team implements CustomInventory, Listener {
    private Main main = Main.getInstance();
    @Override
    public String getName() {
        return "§6Configuration Team";
    }

    @Override
    public Supplier<ItemStack[]> getContents(Player player) {
        ItemStack[] slots = new ItemStack[getSlots()];
        for (int i = 0; i <= 26; i++)
            slots [i] = new ItemCreator(Material.STAINED_GLASS_PANE).setDurability(0).setName("§8").getItem();
        slots[2] = new ItemCreator(Material.BLAZE_POWDER).setName("§6Team Kill : "+ (TeamsE.TEAMKILL.isEnabled() ? "§a✔" : "§4✖")).getItem();
        slots[4] = new ItemCreator(Material.ENDER_PEARL).setName("§6Team Size : "+ main.games.maxparteams).getItem();
        slots[6] = new ItemCreator(Material.BARRIER).setName("§cSoon ").getItem();
        slots[12] = new ItemCreator(Material.CAULDRON_ITEM).setName("§6Réinitialise les teams").getItem();
        slots[14] = new ItemCreator(Material.REDSTONE_TORCH_ON).setName("§6RandomTeam "+ (TeamsE.RANDOM.isEnabled() ? "§a✔" : "§4✖")).getItem();
        slots[22] = new ItemCreator(Material.ARROW).setName("§cRetour").getItem();

        return () -> slots;
    }

    @Override
    public void onClick(Player player, Inventory inv, ItemStack current, int slot) {
        switch (current.getType()) {
            default:
                break;
            case ARROW:
                main.gui.open(player, Configuration.class);
                break;
            case BLAZE_POWDER:
                if (player.isOp() || player.getUniqueId() == Main.getInstance().games.host) {
                    TeamsE.TEAMKILL.toggleEnabled();
                for (Teams team : Teams.values()) {
                    Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
                    org.bukkit.scoreboard.Team t = scoreboard.getTeam(team.getColor() + team.getName());
                    if (TeamsE.TEAMKILL.isEnabled()) {
                        t.setAllowFriendlyFire(true);
                    }
                    else {
                        t.setAllowFriendlyFire(false);
                    }
                    main.gui.open(player, Team.class);
                }
                }
                break;
            case REDSTONE_TORCH_ON:
                if (player.isOp() || player.getUniqueId() == Main.getInstance().games.host) {
                    TeamsE.RANDOM.toggleEnabled();
                    main.gui.open(player, Team.class);
                }
                break;
            case CAULDRON_ITEM:
                if (player.isOp() || player.getUniqueId() == Main.getInstance().games.host) {
                    for (Teams teams : Teams.values()) {
                        for (Player players : Bukkit.getOnlinePlayers())
                            if (teams.getMembers().contains(players.getUniqueId()))
                                main.teamsManager.removePlayer(teams, players);
                    }
                }
                break;

        }
    }

    @Override
    public int getRows() {
        return 3;
    }


    public enum TeamsE{
        TEAMKILL(true),
        RANDOM(false);
        private boolean enabled;

        TeamsE(boolean enabled){
            this.enabled = enabled;
        }
        public boolean isEnabled() {
            return this.enabled;
        }
        public void toggleEnabled() { this.enabled = !this.enabled; }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if (event.getCurrentItem()==null)
            return;

        if (event.getWhoClicked().isOp() || event.getWhoClicked().getUniqueId() == Main.getInstance().games.host) {
            if (event.getInventory().getName().equalsIgnoreCase("§6Configuration Team")) {
                if (event.getCurrentItem().getType().equals(Material.ENDER_PEARL)) {
                    if (event.getClick().isLeftClick())
                        if (main.games.maxparteams - 1 > 0) {
                            main.games.maxparteams = main.games.maxparteams - 1;
                            main.gui.open((Player) event.getWhoClicked(), Team.class);
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                if (main.games.maxparteams > 1) {
                                    players.getInventory().setItem(4, new ItemCreator(Material.BANNER).setName("§6Team").getItem());
                                } else {
                                    players.getInventory().setItem(4, new ItemCreator(Material.AIR).getItem());
                                    for (Teams teams : Teams.values()) {
                                        if (teams.getMembers().contains(players.getUniqueId()))
                                            main.teamsManager.removePlayer(teams, players);
                                    }
                                }
                            }
                        }
                    if (event.getClick().isRightClick())
                        if (main.games.maxparteams + 1 > 0) {
                            main.games.maxparteams = main.games.maxparteams + 1;
                            main.gui.open((Player) event.getWhoClicked(), Team.class);
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                if (main.games.maxparteams > 1) {
                                    players.getInventory().setItem(4, new ItemCreator(Material.BANNER).setName("§6Team").getItem());
                                } else {
                                    players.getInventory().setItem(4, new ItemCreator(Material.AIR).getItem());
                                    if (Teams.getTeamWithPlayer(players) != null) {
                                        Main.getInstance().teamsManager.removePlayer(Teams.getTeamWithPlayer(players), players);
                                    }
                                }
                            }
                        }
                }
            }
        }
    }

}
