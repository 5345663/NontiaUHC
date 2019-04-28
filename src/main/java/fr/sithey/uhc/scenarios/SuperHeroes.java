package fr.sithey.uhc.scenarios;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.Scenarios;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Random;

public class SuperHeroes extends Scenarios implements Listener {
    public static ArrayList<Player> nofall = new ArrayList();


    public static void superxs() {
        if (GuiScenarioEnum.SUPERHEROES.isEnabled()) {
            ArrayList SendL = new ArrayList();
            Random random = new Random();
            for (Player p : Bukkit.getOnlinePlayers()) {
                Random r = new Random();
                int alea = r.nextInt(5);
                switch (alea) {
                    case 0: {
                        p.sendMessage(Main.getInstance().games.prefix + "§cSuperHero : Resistance");
                        p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 9999999, 0));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 9999999, 0));
                        break;
                    }
                    case 1: {
                        p.sendMessage(Main.getInstance().games.prefix +"§cSuperHero : Speed");
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 9999999, 1));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 9999999, 0));
                        break;
                    }
                    case 2: {
                        p.sendMessage(Main.getInstance().games.prefix +"§cSuperHero : Jump");
                        nofall.add(p);
                        p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 9999999, 3));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 9999999, 0));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 9999999, 0));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 9999999, 0));
                        break;
                    }
                    case 3: {
                        p.sendMessage(Main.getInstance().games.prefix +"§cSuperHero : Strength");
                        p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 9999999, 0));
                        break;
                    }
                    case 4: {
                        p.sendMessage(Main.getInstance().games.prefix + "§cSuperHero : Health");
                        p.setMaxHealth(40.0);
                        p.setHealth(40.0);
                        break;
                    }
                }
            }
        }
    }

    @EventHandler
    public void onDamageEntity(EntityDamageEvent e) {
        Entity entity = e.getEntity();
        if (entity instanceof Player && e.getCause() == EntityDamageEvent.DamageCause.FALL && nofall.contains((Object)entity)) {
            e.setCancelled(true);
        }
    }

    public void configure() {
        scenario = GuiScenarioEnum.SUPERHEROES;
    }


    public void activate(Player player) {
        Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
    }

    public void execute() {
    }
}
