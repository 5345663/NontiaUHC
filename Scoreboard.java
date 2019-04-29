package fr.sithey.uhc.scoreboard;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.teams.Teams;
import fr.sithey.uhc.utils.api.Title;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.text.SimpleDateFormat;
//test2
public class Scoreboard {

    public static void sendScoreboard(Player player) {
        Location spawn = new Location(Bukkit.getWorld("world"), 0 ,Bukkit.getWorld("world").getHighestBlockYAt(0, 0) , 0);

        Player p = player;
        ScoreboardManager sb = new ScoreboardManager(player, Main.getInstance().games.scoreboard);
        sb.create();
        sb.setLine(11, "§8§m------- §6Infos §8§m-------");
        sb.setLine(10, "§eMap : §b" + ((int) Bukkit.getWorld("world").getWorldBorder().getSize()) / 2 + " / " + ((int) Bukkit.getWorld("world").getWorldBorder().getSize()) / 2);
        sb.setLine(9, "§eJoueurs : §b" + Main.getInstance().games.alive.size() + " / " + Main.getInstance().games.maxplayers + (Main.getInstance().games.maxparteams == 1 ? "" : " §8(" + (Main.getInstance().games.teams.size() != 0 ? Main.getInstance().games.teams.size() : "0") + ")"));
        sb.setLine(8, "§8§m------- §6Timer §8§m-------");
        sb.setLine(7, "§eTemps : §b" + (Main.getInstance().timers.GameTime <= 0 ? "00:00 " : Main.getInstance().timers.GameTime / 60 + ":" + new SimpleDateFormat("ss").format(Main.getInstance().timers.GameTime * 1000)));
        sb.setLine(6, "§ePvP : §b" + (Main.getInstance().timers.PvPTimer <= 0 ? "§aactivé " : Main.getInstance().timers.PvPTimer / 60 + ":" +new SimpleDateFormat("ss").format(Main.getInstance().timers.PvPTimer * 1000)));
        sb.setLine(5, "§eBordure : §b" + (Main.getInstance().timers.BorderTimer <= 0 ? "§aactivé " : Main.getInstance().timers.BorderTimer / 60 + ":" +new SimpleDateFormat("ss").format(Main.getInstance().timers.BorderTimer * 1000)));
        sb.setLine(4, "§8§m------- §6Stats §8§m-------");
        sb.setLine(3, "§eKills : §b" + (Main.getInstance().stats.kills.get(p.getUniqueId()) == null ? "0" : Main.getInstance().stats.kills.get(p.getUniqueId())));
        if (player.getLocation().getWorld() == Bukkit.getWorld("world")) {
            sb.setLine(2, "§eCentre : §b\u2b06 " + ((int) player.getLocation().distance(spawn.clone())));
        } else{
            sb.setLine(2, "§eCentre : §b\u2b06 ");
        }
        sb.setLine(1, "§8§m----------------");
        sb.setLine(0, "§6play.nontia.fr");
        Bukkit.getServer().getScheduler().runTaskTimer(Main.getInstance(), new Runnable() {
            public void run() {
                sb.setObjectiveName(Main.getInstance().games.scoreboard);
                sb.setLine(10, "§eMap : §b" + ((int) Bukkit.getWorld("world").getWorldBorder().getSize()) / 2 + " / " + ((int) Bukkit.getWorld("world").getWorldBorder().getSize()) / 2);
                sb.setLine(9, "§eJoueurs : §b" + Main.getInstance().games.alive.size() + " / " + Main.getInstance().games.maxplayers + (Main.getInstance().games.maxparteams == 1 ? "" : " §8(" + (Main.getInstance().games.teams.size() != 0 ? Main.getInstance().games.teams.size() : "0") + ")"));
                sb.setLine(7, "§eTemps : §b" + (Main.getInstance().timers.GameTime <= 0 ? "00:00 " : Main.getInstance().timers.GameTime / 60 + ":" + new SimpleDateFormat("ss").format(Main.getInstance().timers.GameTime * 1000)));
                sb.setLine(6, "§ePvP : §b" + (Main.getInstance().timers.PvPTimer <= 0 ? "§aactivé " : Main.getInstance().timers.PvPTimer / 60 + ":" +new SimpleDateFormat("ss").format(Main.getInstance().timers.PvPTimer * 1000)));
                sb.setLine(5, "§eBordure : §b" + (Main.getInstance().timers.BorderTimer <= 0 ? "§aactivé " : Main.getInstance().timers.BorderTimer / 60 + ":" +new SimpleDateFormat("ss").format(Main.getInstance().timers.BorderTimer * 1000)));
                sb.setLine(3, "§eKills : §b" + (Main.getInstance().stats.kills.get(p.getUniqueId()) == null ? "0" : Main.getInstance().stats.kills.get(p.getUniqueId())));
                if (player.getLocation().getWorld() == Bukkit.getWorld("world")) {
                    if (player.getLocation().distance(spawn.clone()) <= 1) {
                        sb.setLine(2, "§eCentre : §b⬤ ");
                    }
                    else if (getDirectionTo(player, spawn.clone()) <= 45.0) {
                        sb.setLine(2, "§eCentre : §b\u2b06 " + ((int) ((int) player.getLocation().distance(spawn.clone()))));
                    } else if (getDirectionTo(player, spawn.clone()) <= 90.0) {
                        sb.setLine(2, "§eCentre : §b\u2b08 " + ((int) player.getLocation().distance(spawn.clone())));
                    } else if (getDirectionTo(player, spawn.clone()) <= 135.0) {
                        sb.setLine(2, "§eCentre : §b➨ " + ((int) player.getLocation().distance(spawn.clone())));
                    } else if (getDirectionTo(player, spawn.clone()) <= 180.0) {
                        sb.setLine(2, "§eCentre : §b\u2b0a " + ((int) player.getLocation().distance(spawn.clone())));
                    } else if (getDirectionTo(player, spawn.clone()) <= 225.0) {
                        sb.setLine(2, "§eCentre : §b\u2b07 " + ((int) player.getLocation().distance(spawn.clone())));
                    } else if (getDirectionTo(player, spawn.clone()) <= 270.0) {
                        sb.setLine(2, "§eCentre : §b\u2b0b " + ((int) player.getLocation().distance(spawn.clone())));
                    } else if (getDirectionTo(player, spawn.clone()) <= 315.0) {
                        sb.setLine(2, "§eCentre : §b\u2b05 " + ((int) player.getLocation().distance(spawn.clone())));
                    } else{
                        sb.setLine(2, "§eCentre : §b\u2b09 " + ((int) player.getLocation().distance(spawn.clone())));
                    }
                }else{
                    sb.setLine(2, "§eCentre : §b⬤ ");
                }
                if (Teams.getTeamWithPlayer(player) != null){
                    if (Teams.getTeamWithPlayer(player).getAlive().size() == 1)
                        Title.sendActionBar(p, "§cAucun mate...");
                    else if (Teams.getTeamWithPlayer(player).getAlive().size() == 2){
                        if (Teams.getTeamWithPlayer(player).getAlive().get(0) != player.getUniqueId())
                        Title.sendActionBar(p, Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(0))));
                        else
                        Title.sendActionBar(p, Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(1))));
                    }else if (Teams.getTeamWithPlayer(player).getAlive().size() == 3){
                    if (Teams.getTeamWithPlayer(player).getAlive().get(0) == player.getUniqueId())
                        Title.sendActionBar(p, Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(1))) + Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(2))));
                    else if (Teams.getTeamWithPlayer(player).getAlive().get(1) == player.getUniqueId())
                        Title.sendActionBar(p, Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(0))) + Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(2))));
                    else if (Teams.getTeamWithPlayer(player).getAlive().get(2) == player.getUniqueId())
                        Title.sendActionBar(p, Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(0))) + Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(1))));
                }else if (Teams.getTeamWithPlayer(player).getAlive().size() == 4){
                    if (Teams.getTeamWithPlayer(player).getAlive().get(0) == player.getUniqueId())
                        Title.sendActionBar(p, Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(1))) + Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(2))) + Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(3))));
                    else if (Teams.getTeamWithPlayer(player).getAlive().get(1) == player.getUniqueId())
                        Title.sendActionBar(p, Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(0))) + Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(2))) + Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(3))));
                    else if (Teams.getTeamWithPlayer(player).getAlive().get(2) == player.getUniqueId())
                        Title.sendActionBar(p, Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(0))) + Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(1))) + Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(3))));
                    else if (Teams.getTeamWithPlayer(player).getAlive().get(3) == player.getUniqueId())
                        Title.sendActionBar(p, Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(0))) + Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(1))) + Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(2))));

                    }
                    else if (Teams.getTeamWithPlayer(player).getAlive().size() == 5){
                        if (Teams.getTeamWithPlayer(player).getAlive().get(0) == player.getUniqueId())
                            Title.sendActionBar(p, Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(3))) + Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(1))) + Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(2)))+ Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(4))));
                        else if (Teams.getTeamWithPlayer(player).getAlive().get(1) == player.getUniqueId())
                            Title.sendActionBar(p, Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(0))) + Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(3))) + Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(2)))+ Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(4))));
                        else if (Teams.getTeamWithPlayer(player).getAlive().get(2) == player.getUniqueId())
                            Title.sendActionBar(p, Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(0))) + Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(1))) + Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(3)))+ Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(4))));
                        else if (Teams.getTeamWithPlayer(player).getAlive().get(3) == player.getUniqueId())
                            Title.sendActionBar(p, Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(0))) + Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(1))) + Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(2)))+ Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(4))));
                        else if (Teams.getTeamWithPlayer(player).getAlive().get(4) == player.getUniqueId())
                            Title.sendActionBar(p, Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(0))) + Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(1))) + Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(2)))+ Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(3))));

                    }
                    else{
                        if (Teams.getTeamWithPlayer(player).getAlive().get(0) == player.getUniqueId())
                            Title.sendActionBar(p, Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(3))) + Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(1))) + Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(2)))+ Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(4))) + " §c...");
                        else if (Teams.getTeamWithPlayer(player).getAlive().get(1) == player.getUniqueId())
                            Title.sendActionBar(p, Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(0))) + Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(3))) + Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(2)))+ Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(4))) + " §c...");
                        else if (Teams.getTeamWithPlayer(player).getAlive().get(2) == player.getUniqueId())
                            Title.sendActionBar(p, Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(0))) + Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(1))) + Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(3)))+ Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(4))) + " §c...");
                        else if (Teams.getTeamWithPlayer(player).getAlive().get(3) == player.getUniqueId())
                            Title.sendActionBar(p, Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(0))) + Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(1))) + Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(2)))+ Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(4))) + " §c...");
                        else if (Teams.getTeamWithPlayer(player).getAlive().get(4) == player.getUniqueId())
                            Title.sendActionBar(p, Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(0))) + Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(1))) + Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(2)))+ Scoreboard.getDirectionMate(player, Bukkit.getPlayer(Teams.getTeamWithPlayer(player).getAlive().get(3))) + " §c...");

                    }
                }
            }
        }, 10L, 10L);
    }

    public static double getDirectionTo(final Player paramPlayer, final Location paramLocation) {
        final Location localLocation = paramPlayer.getLocation().clone();
        localLocation.setY(0.0);
        paramLocation.setY(0.0);
        final Vector localVector1 = localLocation.getDirection();
        final Vector localVector2 = paramLocation.subtract(localLocation).toVector().normalize();
        double d1 = Math.toDegrees(Math.atan2(localVector1.getX(), localVector1.getZ()));
        d1 -= Math.toDegrees(Math.atan2(localVector2.getX(), localVector2.getZ()));
        d1 = (int)(d1 + 22.5) % 360;
        if (d1 < 0.0) {
            d1 += 360.0;
        }
        return d1;
    }
    
    public static String getDirectionMate(Player player, Player mate){
        if (player.getWorld().equals(mate.getWorld())) {
            if (getDirectionTo(player, mate.getLocation().clone()) <= 45.0) {
                return "§a" + mate.getName() + "§f \u2b06 " + ((int) player.getLocation().distance(mate.getLocation())) + " ";
            } else if (getDirectionTo(player, mate.getLocation().clone()) <= 90.0) {
                return "§a" + mate.getName() + "§f \u2b08 " + ((int) player.getLocation().distance(mate.getLocation())) + " ";
            } else if (getDirectionTo(player, mate.getLocation().clone()) <= 135.0) {
                return "§a" + mate.getName() + "§f➨ " + ((int) player.getLocation().distance(mate.getLocation())) + " ";
            } else if (getDirectionTo(player, mate.getLocation().clone()) <= 180.0) {
                return "§a" + mate.getName() + "§f \u2b0a " + ((int) player.getLocation().distance(mate.getLocation())) + " ";
            } else if (getDirectionTo(player, mate.getLocation().clone()) <= 225.0) {
                return "§a" + mate.getName() + "§f \u2b07 " + ((int) player.getLocation().distance(mate.getLocation())) + " ";
            } else if (getDirectionTo(player, mate.getLocation().clone()) <= 270.0) {
                return "§a" + mate.getName() + "§f \u2b0b " + ((int) player.getLocation().distance(mate.getLocation())) + " ";
            } else if (getDirectionTo(player, mate.getLocation().clone()) <= 315.0) {
                return "§a" + mate.getName() + "§f \u2b05 " + ((int) player.getLocation().distance(mate.getLocation())) + " ";
            } else {
                return "§a" + mate.getName() + "§f \u2b09 " + ((int) player.getLocation().distance(mate.getLocation())) + " ";
            }
        }else{
            return "§a" + mate.getName() + "§4 Introuvable... ";
        }
    }
}
