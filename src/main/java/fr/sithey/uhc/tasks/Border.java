package fr.sithey.uhc.tasks;

import fr.sithey.uhc.Main;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.text.SimpleDateFormat;

public class Border extends BukkitRunnable {
    private Main main = Main.getInstance();
    @Override
    public void run() {


        if (main.timers.BorderTimer == 30 * 60 || main.timers.BorderTimer == 15 * 60 || main.timers.BorderTimer == 10 * 60
                || main.timers.BorderTimer == 5 * 60 || main.timers.BorderTimer == 4 * 60 || main.timers.BorderTimer == 3 * 60
                || main.timers.BorderTimer == 2 * 60 || main.timers.BorderTimer == 60|| main.timers.BorderTimer == 10
                || main.timers.BorderTimer == 5 || main.timers.BorderTimer == 4 || main.timers.BorderTimer == 3
                || main.timers.BorderTimer == 2 || main.timers.BorderTimer == 1) {
            Bukkit.broadcastMessage(main.games.prefix + "§6Activation de la bordure dans §f§o" + new SimpleDateFormat("mm:ss").format(main.timers.BorderTimer * 1000) + " §eminute(s) !");
        }
        if (main.timers.BorderTimer == 0) {
            cancel();
            Bukkit.broadcastMessage(main.games.prefix + "§6Bordure activé !");
            Bukkit.getWorld("world").getWorldBorder().setSize(main.games.borderfinal, main.games.bordertime);

        }
        main.timers.BorderTimer--;

    }
}
