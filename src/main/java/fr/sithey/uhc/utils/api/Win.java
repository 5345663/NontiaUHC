package fr.sithey.uhc.utils.api;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.teams.Teams;
import fr.sithey.uhc.utils.uhcgame.Status;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Win {
    public static void checkWin(){
            if (!Main.getInstance().isStatus(Status.FIN) && Main.getInstance().games.teams.size() == 1){
                for (Player player : Bukkit.getOnlinePlayers()){
                    Title.sendTitle(player, 5, 20 * 3, 5, "§6La Team " + Main.getInstance().games.teams.get(0).getColor() + Main.getInstance().games.teams.get(0).getName(), "§eremporte §bl'UHC");
                }

                Bukkit.broadcastMessage(Main.getInstance().games.prefix + "§6La Team " + Main.getInstance().games.teams.get(0).getColor() + Main.getInstance().games.teams.get(0).getName() + " §eremporte §bl'UHC");
                Main.getInstance().setStatus(Status.FIN);
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                    @Override
                    public void run() {
                        Main.getInstance().getServer().shutdown();
                    }
                }, 20 * 20);
            }
        if (!Main.getInstance().isStatus(Status.FIN) && Main.getInstance().games.alive.size() == 1){
            for (Player player : Bukkit.getOnlinePlayers()){
                Title.sendTitle(player, 5, 20 * 3, 5, "§6Le joueur " + Bukkit.getPlayer(Main.getInstance().games.alive.get(0)).getDisplayName(), "§eremporte §bl'UHC");
            }
            Bukkit.broadcastMessage(Main.getInstance().games.prefix + "§6Le joueur " + Bukkit.getPlayer(Main.getInstance().games.alive.get(0)).getDisplayName() + " §eremporte §bl'UHC");
            Main.getInstance().setStatus(Status.FIN);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    Main.getInstance().getServer().shutdown();
                }
            }, 20 * 20);
        }
    }
    public static void checkDeath(){
        for (Teams teams : Teams.values()) {
            if (teams.getAlive().size() == 0 && !teams.getDeath() && !teams.getName().equals(Teams.TAUPE.getName())) {
                Bukkit.broadcastMessage(Main.getInstance().games.prefix + "§eLa Team " + teams.getName() + "§cest morte !");
                teams.toogleDeath();
                Main.getInstance().games.teams.remove(teams);
            }
            if (teams.getName().equals(Teams.TAUPE.getName()) && Main.getInstance().games.taupetime <= 0 && Main.getInstance().games.taupe.size() == 0) {
                Bukkit.broadcastMessage(Main.getInstance().games.prefix + "§eLa Team " + teams.getName() + "§cest morte !");
                teams.toogleDeath();
                Main.getInstance().games.teams.remove(teams);
            }
        }
    }
}
