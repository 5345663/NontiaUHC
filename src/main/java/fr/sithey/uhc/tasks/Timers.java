package fr.sithey.uhc.tasks;

import fr.sithey.uhc.Main;
import org.bukkit.scheduler.BukkitRunnable;

public class Timers extends BukkitRunnable {
    private Main main = Main.getInstance();

    @Override
    public void run(){
        main.timers.GameTime++;
    }


}
