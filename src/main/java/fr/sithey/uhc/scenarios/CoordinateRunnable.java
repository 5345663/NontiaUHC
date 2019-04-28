package fr.sithey.uhc.scenarios;

import fr.sithey.uhc.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class CoordinateRunnable extends BukkitRunnable implements Listener {
    private Main main = Main.getInstance();
    @Override
    public void run() {

        if (main.games.coordtime == 0){
            Random r = new Random();
            int alea = r.nextInt(main.games.alive.size());
            Bukkit.broadcastMessage(main.games.prefix + "§6Un joueur se trouve au coordonées suivante : \n" + main.games.prefix + "§aX: " + ((int) Bukkit.getPlayer(main.games.alive.get(alea)).getLocation().getX()) + " Y: " + ((int) Bukkit.getPlayer(main.games.alive.get(alea)).getLocation().getY())+ " Z: " + ((int) Bukkit.getPlayer(main.games.alive.get(alea)).getLocation().getZ()));
            int coordtime = r.nextInt(9);
            if (coordtime == 0)
                main.games.coordtime = 60;
            if (coordtime == 1)
                main.games.coordtime = 2 * 60;
            if (coordtime == 2)
                main.games.coordtime = 3 * 60;
            if (coordtime == 3)
                main.games.coordtime = 4 * 60;
            if (coordtime == 4)
                main.games.coordtime = 5 * 60;
            if (coordtime == 5)
                main.games.coordtime = 6 * 60;
            if (coordtime == 6)
                main.games.coordtime = 7 * 60;
            if (coordtime == 7)
                main.games.coordtime = 8 * 60;
            if (coordtime == 8)
                main.games.coordtime = 9 * 60;
            if (coordtime == 9)
                main.games.coordtime = 10 * 60;
            cancel();

            CoordinateRunnable start = new CoordinateRunnable();
            start.runTaskTimer(Main.getInstance(), 0, 20);
        }
        main.games.coordtime--;
    }
    
}


