package fr.sithey.uhc.scenarios.special;

import fr.sithey.uhc.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import java.text.SimpleDateFormat;

public class TaupeGunRunnable extends BukkitRunnable implements Listener {
    private Main main = Main.getInstance();
    @Override
    public void run() {
        if (main.games.taupetime  == 30 * 60 || main.games.taupetime == 15 * 60 || main.games.taupetime == 10 * 60
                || main.games.taupetime == 5 * 60 || main.games.taupetime == 4 * 60 || main.games.taupetime == 3 * 60
                || main.games.taupetime == 2 * 60 || main.games.taupetime == 60 || main.games.taupetime == 30 || main.games.taupetime == 15 || main.games.taupetime == 10
                || main.games.taupetime == 5 || main.games.taupetime == 4 || main.games.taupetime == 3
                || main.games.taupetime == 2 || main.games.taupetime == 1) {
            Bukkit.broadcastMessage(main.games.prefix + "§6Activation du scenario TaupeGun dans §f§o" + new SimpleDateFormat("mm:ss").format(main.games.taupetime * 1000) + " §eminute(s) !");
        }

        if (main.games.taupetime == 0){
            Bukkit.broadcastMessage(main.games.prefix + "§6TaupeGun activé !");
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    TaupeGun.sendTaupe();
                }
            }, 20);

            cancel();
        }
        main.games.taupetime--;
    }
    
}


