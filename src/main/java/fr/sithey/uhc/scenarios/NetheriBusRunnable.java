package fr.sithey.uhc.scenarios;

import fr.sithey.uhc.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import java.text.SimpleDateFormat;

public class NetheriBusRunnable extends BukkitRunnable implements Listener {
    private Main main = Main.getInstance();
    @Override
    public void run() {
        if (main.games.nethertime == 30 * 60 || main.games.nethertime == 15 * 60 || main.games.nethertime == 10 * 60
                || main.games.nethertime == 5 * 60 || main.games.nethertime == 4 * 60 || main.games.nethertime == 3 * 60
                || main.games.nethertime == 2 * 60 || main.games.nethertime == 60 || main.games.nethertime == 30 || main.games.nethertime == 15 || main.games.nethertime == 10
                || main.games.nethertime == 5 || main.games.nethertime == 4 || main.games.nethertime == 3
                || main.games.nethertime == 2 || main.games.nethertime == 1) {
            Bukkit.broadcastMessage(main.games.prefix + "§6Activation du scenario NetheriBus dans §f§o" + new SimpleDateFormat("mm:ss").format(main.games.nethertime * 1000) + " §eminute(s) !");
        }

        if (main.games.nethertime == 0){
            Bukkit.broadcastMessage(main.games.prefix + "§6NetheriBus activé !");

            main.getServer().getScheduler().scheduleSyncRepeatingTask(main, new Runnable() {
                @Override
                public void run() {
                    for (Player player : Bukkit.getOnlinePlayers()){
                        if (player.getLocation().getWorld().getName().equalsIgnoreCase("world")){
                            player.damage(main.games.overdamage);
                        }
                    }
                }
            }, 0, main.games.overdtime);
            cancel();
        }
        main.games.nethertime--;
    }
    
}


