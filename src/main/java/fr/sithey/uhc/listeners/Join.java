package fr.sithey.uhc.listeners;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.scoreboard.Scoreboard;
import fr.sithey.uhc.teams.Teams;
import fr.sithey.uhc.utils.api.ItemCreator;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Join implements Listener {
    private Main main = Main.getInstance();
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        event.setJoinMessage("");
        Player player = event.getPlayer();
        Scoreboard.sendScoreboard(player);
        if (main.isLobby()){

            player.getInventory().clear();
            if (main.games.alive.size() < 1)
                main.games.host = player.getUniqueId();
            main.getServer().getScheduler().scheduleSyncDelayedTask(main, new Runnable() {
                @Override
                public void run() {
                    player.teleport(main.spawn());
                   if (player.isOp() || Bukkit.getPlayer(main.games.host) == player){
                       player.getInventory().setItem(0, new ItemCreator(Material.REDSTONE_COMPARATOR).setName("§cConfig de la partie").getItem());
                       player.getInventory().setItem(1, new ItemCreator(Material.ANVIL).setName("§cScénario").getItem());
                       player.sendMessage(
                        "§8§m----------------------------------------------------\n"+
                                "\n"+
                                "§cBienvenue à vous en tant que Host, voici quelques commandes utiles pour votre host: \n" +
                                "\n"+
                                "/specialsc - Commande spéciale pour des scénarios spéciaux.\n"+
                                "/htp - Se téléporter à un joueur.\n"+
                                "/hrez - Refait vivre un joueur mort .\n"+
                                "/hsay - Faire une annonce dans votre serveur.\n"+
                                "/hgamemode - Changer de gamemode.\n"+
                                "/hstop - Stop le serveur.\n"+
                                "/hchat - Activer ou désactiver le chat.\n"+
                                "/hvote - Faire un vote.\n"+
                                "/hforce - Force le PvP ou la Bordure .\n"+
                                "/hscoreboard - Change le titre du scoreboard .\n"+
                                "/hmaxplayers - Mettre un nombre maximum de joueur .\n"+
                                "/sethost - Donner l'host .\n"+
                                "/whitelist on/off - Activer ou désactiver la whitelist .\n\n"+
                                "§8§m----------------------------------------------------\n");

                   }
                }
            }, 5);

            if (main.games.maxparteams > 1)
            player.getInventory().setItem(4, new ItemCreator(Material.BANNER).setName("§6Menu des Team").getItem());
            player.getInventory().setArmorContents(null);
            player.setFoodLevel(20);
            player.setGameMode(GameMode.ADVENTURE);
            player.setLevel(0);
            player.setMaxHealth(20);
            player.setMaximumNoDamageTicks(20);
            player.setHealth(player.getMaxHealth());
            player.setExp(0);
            player.getActivePotionEffects().forEach(potion -> player.removePotionEffect(potion.getType()));

            if (!main.games.alive.contains(player.getUniqueId()))
                main.games.alive.add(player.getUniqueId());
            main.stats.kills.put(player.getUniqueId(), 0);
            main.stats.diamond.put(player.getUniqueId(), 0);
            main.stats.gold.put(player.getUniqueId(), 0);
            Bukkit.broadcastMessage(main.games.prefix + player.getName() + " §6a rejoint la partie §c" + main.games.alive.size() + " / " + main.games.maxplayers);

        }

        if (!main.isLobby()){
            if (main.games.disconect.contains(player.getUniqueId())) {
                main.games.alive.add(player.getUniqueId());
                main.games.disconect.remove(player.getUniqueId());

                for (Teams teams : Teams.values()) {
                    if (teams.getMembers().contains(player.getUniqueId()))
                        main.teamsManager.addPlayer(teams, player);
                }
            }

            if (!(main.games.alive.contains(player.getUniqueId()))) {
                player.setGameMode(GameMode.SPECTATOR);
            }


        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        event.setQuitMessage("");
        Player player = event.getPlayer();
        main.boards.remove(player);
        if (main.isLobby()) {
            main.games.alive.remove(player.getUniqueId());
            Bukkit.broadcastMessage(main.games.prefix + player.getName() + " §6a quitté la partie §c" + main.games.alive.size() + " / " + main.games.maxplayers);
            if (Teams.getTeamWithPlayer(player) != null)
            main.teamsManager.removePlayer(Teams.getTeamWithPlayer(player), player);
        }

        if (!main.isLobby()) {
            if (main.games.alive.contains(player.getUniqueId())) {
                main.games.disconect.add(player.getUniqueId());
                main.games.alive.remove(player.getUniqueId());
                if (Teams.getTeamWithPlayer(player) != null)
                    Teams.getTeamWithPlayer(player).getAlive().remove(player.getUniqueId());
            }
        }
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent event){
        Player player = event.getPlayer();
        if (main.isLobby()) {
            if (main.games.alive.size() >= main.games.maxplayers) {
                if (!player.isOp()) {
                    event.setResult(PlayerLoginEvent.Result.KICK_FULL);
                    event.setKickMessage("§cLe serveur est actuellement full !");
                }
            }
        }
    }
    @EventHandler
    public void onSpawn(CreatureSpawnEvent event){
        if (main.isLobby())
            event.setCancelled(true);
    }
}
