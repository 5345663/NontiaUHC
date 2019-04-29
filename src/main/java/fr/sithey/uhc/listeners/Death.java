package fr.sithey.uhc.listeners;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.teams.Teams;
import fr.sithey.uhc.utils.api.DeathInventoryAPI;
import fr.sithey.uhc.utils.api.Title;
import fr.sithey.uhc.utils.api.Win;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Death implements Listener {
    private Main main = Main.getInstance();
    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        Player player = event.getEntity();
        Player killer = player.getKiller();
        String message = event.getDeathMessage();
        event.setDeathMessage("");
        if (main.games.uuidsupertaupe == player.getUniqueId())
            main.games.uuidsupertaupe = null;

        DeathInventoryAPI inventairedeath = new DeathInventoryAPI(player, null);
        inventairedeath.dropInvent();
        main.games.alive.remove(player.getUniqueId());
        main.getServer().getScheduler().scheduleSyncDelayedTask(main, new Runnable() {
            @Override
            public void run() {
                player.spigot().respawn();
                player.setGameMode(GameMode.SPECTATOR);
            }
        }, 5);

            if (message.contains("burned") || message.contains("drowned") || message.contains("lava") || message.contains("ground") || message.contains("fall") || message.contains("fell")
                        || message.contains("Zombie") || message.contains("Blaze") || message.contains("Creeper") || message.contains("Enderman") || message.contains("Skeleton")
                        || message.contains("Spider") || message.contains("Silverfish") || message.contains("Witch") || message.contains("suffocated") || message.contains("died")) {
               Bukkit.broadcastMessage(main.games.prefix + (Teams.getTeamWithPlayer(player) == null ? "§c" : Teams.getTeamWithPlayer(player).getColor() + Teams.getTeamWithPlayer(player).getName()) + player.getName() + " §aest mort !");
                } else {
                  Bukkit.broadcastMessage(main.games.prefix + (Teams.getTeamWithPlayer(player) == null ? "§c" : Teams.getTeamWithPlayer(player).getColor() +Teams.getTeamWithPlayer(player).getName()) + player.getName() + "§a a été tué par " + (Teams.getTeamWithPlayer(killer) == null ? "§a" :Teams.getTeamWithPlayer(killer).getColor() + Teams.getTeamWithPlayer(killer).getName()) + killer.getName());
                  main.stats.kills.put(killer.getUniqueId(), main.stats.kills.get(killer.getUniqueId()) + 1);
            }
                for (Teams teams : Teams.values()) {
                    if (teams.getAlive().contains(player.getUniqueId())){
                        main.games.lastteams.put(player.getUniqueId(), teams);
                        main.teamsManager.removePlayer(teams, player);
                }
                }
        main.games.lastcoord.put(player.getUniqueId(), player.getLocation());
        main.games.lastinv.put(player.getUniqueId(), player.getInventory());
                Win.checkDeath();
                Win.checkWin();
        Title.sendActionBar(player, "§7Vous êtes mort faire cliques molette pour spec");

        }

    }
