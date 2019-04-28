package fr.sithey.uhc.teams;

import fr.sithey.uhc.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

public class TeamsManager {
    private Main main = Main.getInstance();

    public void addPlayer(Teams team, Player player) {
        for (Teams teams : Teams.values()) {
            if (teams.getMembers().contains(player.getUniqueId())) {
                removePlayer(teams, player);
            }
        }
        if (team.getSize() < main.games.maxparteams) {
            team.getMembers().add(player.getUniqueId());
            team.getAlive().add(player.getUniqueId());
            Bukkit.getScoreboardManager().getMainScoreboard().getTeam(team.getColor() + team.getName()).addEntry(player.getName());
            player.sendMessage(main.games.prefix +"§6Vous venez de rejoindre la team " + team.getColor() + team.getName() + " §6!");
        } else {
            player.sendMessage(main.games.prefix + "§6La team " + team.getColor() + team.getName() + " §6est complete !");
        }
    }



    public void removePlayer(Teams team, Player player){
        if(team.getMembers().contains(player.getUniqueId())){
            team.getMembers().remove(player.getUniqueId());
            team.getAlive().remove(player.getUniqueId());
            Bukkit.getScoreboardManager().getMainScoreboard().getTeam(team.getColor() + team.getName()).removeEntry(player.getName());
        }
    }

    public void addSwitch(Teams team, Player player) {
        for (Teams teams : Teams.values()) {
            if (teams.getMembers().contains(player.getUniqueId())) {
                removePlayer(teams, player);
            }
        }
        team.getMembers().add(player.getUniqueId());
        team.getAlive().add(player.getUniqueId());
        Bukkit.getScoreboardManager().getMainScoreboard().getTeam(team.getColor() + team.getName()).addEntry(player.getName());
    }

    public void randomTeam(Player player){
        for (Teams teams : Teams.values()){
            if (teams.getSize() < main.games.maxparteams && main.games.maxparteams != 1 && !teams.getName().equals(Teams.TAUPE.getName())) {
                    addPlayer(teams, player);
                    break;
            }

        }
    }

    public void createTeams() {
        for (Teams team : Teams.values()) {
            Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();

            org.bukkit.scoreboard.Team t = scoreboard.registerNewTeam(team.getColor() + team.getName());
            t.setPrefix(team.getColor() + team.getName());
        }
    }

    public void deleteTeams() {
        for (Teams team : Teams.values()) {
            Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
            org.bukkit.scoreboard.Team t = scoreboard.getTeam(team.getColor() + team.getName());
            t.unregister();
        }
    }


}
