package fr.sithey.uhc.listeners;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.teams.Teams;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.UUID;

public class Chat implements Listener {
    private Main main = Main.getInstance();
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
            Player player = event.getPlayer();
        String message = event.getMessage();
            if (!player.isOp()){
                if (main.games.isChatmute())
                    event.setCancelled(true);
            }
            if (player.getGameMode().equals(GameMode.SPECTATOR)){
                event.setCancelled(true);
                for (Player spec : Bukkit.getOnlinePlayers())
                    if (!main.games.alive.contains(spec.getUniqueId()))
                        spec.sendMessage("§7Spec " + player.getDisplayName() + " §7: " + message);
            }else{
                if (!player.isOp())
                event.setFormat((Teams.getTeamWithPlayer(player) == null ? "": Teams.getTeamWithPlayer(player).getColor() + (Teams.getTeamWithPlayer(player).getName())) + "%1$s §8» §7%2$s");
                else
                event.setFormat((Teams.getTeamWithPlayer(player) == null ? "": Teams.getTeamWithPlayer(player).getColor() + (Teams.getTeamWithPlayer(player).getName())) + "%1$s §8» §f%2$s");

            }
        if (event.getMessage().startsWith("!")){
            event.setCancelled(true);
            for (Teams t : Teams.values()) {
                if(t.getMembers().contains(player.getUniqueId())){
                    for (UUID team : t.getMembers()) {
                        Bukkit.getPlayer(team).sendMessage("§6[Equipe] §a" + player.getName() + "§7 : " + message);
                    }
                }
            }
        }
    }
}
