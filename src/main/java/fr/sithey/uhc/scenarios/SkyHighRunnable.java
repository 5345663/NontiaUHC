package fr.sithey.uhc.scenarios;

import fr.sithey.uhc.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import java.text.SimpleDateFormat;

public class SkyHighRunnable extends BukkitRunnable implements Listener {
    private Main main = Main.getInstance();
    @Override
    public void run() {
        if (main.games.skyhigh  == 30 * 60 || main.games.skyhigh == 15 * 60 || main.games.skyhigh == 10 * 60
                || main.games.skyhigh == 5 * 60 || main.games.skyhigh == 4 * 60 || main.games.skyhigh == 3 * 60
                || main.games.skyhigh == 2 * 60 || main.games.skyhigh == 60 || main.games.skyhigh == 30 || main.games.skyhigh == 15 || main.games.skyhigh == 10
                || main.games.skyhigh == 5 || main.games.skyhigh == 4 || main.games.skyhigh == 3
                || main.games.skyhigh == 2 || main.games.skyhigh == 1) {
            Bukkit.broadcastMessage(main.games.prefix + "§6Activation du scenario SkyHigh dans §f§o" + new SimpleDateFormat("mm:ss").format(main.games.skyhigh * 1000) + " §eminute(s) !");
        }

        if (main.games.skyhigh == 0){
            Bukkit.broadcastMessage(main.games.prefix + "§6SkiHigh activé !");
            main.getServer().getScheduler().scheduleSyncRepeatingTask(main, new Runnable() {
                @Override
                public void run() {
                    for (Player player : Bukkit.getOnlinePlayers()){
                        if (player.getLocation().getBlockY() < 150){
                            player.damage(main.games.skydamage);
                        }
                    }
                }
            }, 0, main.games.skydtime);
            cancel();
        }
        main.games.skyhigh--;
    }
    
}


