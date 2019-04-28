package fr.sithey.uhc.tasks;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

import java.text.SimpleDateFormat;

public class PvP extends BukkitRunnable {
    private Main main = Main.getInstance();

    @Override
    public void run() {


        if (main.timers.PvPTimer == 30 * 60 || main.timers.PvPTimer == 15 * 60 || main.timers.PvPTimer == 10 * 60
                || main.timers.PvPTimer == 5 * 60 || main.timers.PvPTimer == 4 * 60 || main.timers.PvPTimer == 3 * 60
                || main.timers.PvPTimer == 2 * 60 || main.timers.PvPTimer == 60 ||main.timers.PvPTimer == 30 || main.timers.PvPTimer == 15 || main.timers.PvPTimer == 10
                || main.timers.PvPTimer == 5 || main.timers.PvPTimer == 4 || main.timers.PvPTimer == 3
                || main.timers.PvPTimer == 2 || main.timers.PvPTimer == 1) {
            Bukkit.broadcastMessage(main.games.prefix + "§6Activation du PvP dans §f§o" + new SimpleDateFormat("mm:ss").format(main.timers.PvPTimer * 1000) + " §eminute(s) !");
        }

        if (main.timers.PvPTimer == 0) {
            cancel();
            Bukkit.broadcastMessage(main.games.prefix +"§6PvP activé !");
            for (World world : Bukkit.getWorlds())
            world.setPVP(true);
        }
        main.timers.PvPTimer--;
    }
}
