package fr.sithey.uhc.tasks;

import fr.sithey.uhc.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.text.SimpleDateFormat;

public class Damage extends BukkitRunnable {
    private Main main = Main.getInstance();
    @Override
    public void run() {
        if (main.timers.DamageTimer == 30 * 60 || main.timers.DamageTimer == 15 * 60 || main.timers.DamageTimer == 10 * 60
                || main.timers.DamageTimer == 5 * 60 || main.timers.DamageTimer == 4 * 60 || main.timers.DamageTimer == 3 * 60
                || main.timers.DamageTimer == 2 * 60 || main.timers.DamageTimer == 60 || main.timers.DamageTimer == 30 || main.timers.DamageTimer == 15 || main.timers.DamageTimer == 10
                || main.timers.DamageTimer == 5 || main.timers.DamageTimer == 4 || main.timers.DamageTimer == 3
                || main.timers.DamageTimer == 2 || main.timers.DamageTimer == 1) {
            Bukkit.broadcastMessage(main.games.prefix + "§6Activation des dégats dans §f§o" + new SimpleDateFormat("mm:ss").format(main.timers.DamageTimer * 1000) + " §eminute(s) !");
        }

        if (main.timers.DamageTimer == 0){
            Bukkit.broadcastMessage(main.games.prefix + "§6Dégat activé !");
            for (Player players : Bukkit.getOnlinePlayers()) {
                players.damage(0);
                players.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20, 255, false, false));
            }
            cancel();
        }
        
        
        main.timers.DamageTimer--;
    }
}
