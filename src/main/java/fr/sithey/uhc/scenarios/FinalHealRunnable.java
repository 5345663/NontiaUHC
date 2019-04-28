package fr.sithey.uhc.scenarios;

import fr.sithey.uhc.Main;
import org.bukkit.Bukkit;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.text.SimpleDateFormat;
import java.util.UUID;

public class FinalHealRunnable extends BukkitRunnable {
    private Main main = Main.getInstance();
    @Override
    public void run() {
        if (main.games.healtime == 30 * 60 || main.games.healtime == 15 * 60 || main.games.healtime == 10 * 60
                || main.games.healtime == 5 * 60 || main.games.healtime == 4 * 60 || main.games.healtime == 3 * 60
                || main.games.healtime == 2 * 60 || main.games.healtime == 60 || main.games.healtime == 30 || main.games.healtime == 15 || main.games.healtime == 10
                || main.games.healtime == 5 || main.games.healtime == 4 || main.games.healtime == 3
                || main.games.healtime == 2 || main.games.healtime == 1) {
            Bukkit.broadcastMessage(main.games.prefix + "§6Activation du final heal dans §f§o" + new SimpleDateFormat("mm:ss").format(main.games.healtime * 1000) + " §eminute(s) !");
        }

        if (main.games.healtime == 0){
            Bukkit.broadcastMessage(main.games.prefix + "§6Final heal activé !");
            for (UUID player : main.games.alive){
                Bukkit.getPlayer(player).addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,3 * 20, 255, false, false));

            }
            cancel();
        }
        main.games.healtime--;
    }
}
