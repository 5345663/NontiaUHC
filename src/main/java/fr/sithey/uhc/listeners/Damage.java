package fr.sithey.uhc.listeners;

import fr.sithey.uhc.Main;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Damage implements Listener {
    @EventHandler
    public void onPlayerDamage(final EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            final Player player = (Player)event.getDamager();
            if (player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) {
                for (final PotionEffect Effect : player.getActivePotionEffects()) {
                    if (Effect.getType().equals(PotionEffectType.INCREASE_DAMAGE)) {
                        final double DamagePercentage = (Effect.getAmplifier() + 1) * 1.3 + 1.0;
                        int NewDamage;
                        if (event.getDamage() / DamagePercentage <= 1.0) {
                            NewDamage = (Effect.getAmplifier() + 1) * 3 + 1;
                        }
                        else {
                            NewDamage = (int)(event.getDamage() / DamagePercentage) + (Effect.getAmplifier() + 1) * 3;
                        }
                        event.setDamage((double)NewDamage);
                        break;
                    }
                }
            }
        }
    }
    @EventHandler
    public void onDamage(EntityDamageEvent event){
        Entity entity = event.getEntity();
        World world = entity.getWorld();

        if (!(entity instanceof Player)){
            return;
        }
        if (world.getName().equalsIgnoreCase("spawn") || Main.getInstance().timers.DamageTimer > 0) {
            event.setCancelled(true);
        } else {
            event.setCancelled(false);
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void DamageEvent(final EntityDamageByEntityEvent entity) {
        if (entity.getDamager() instanceof Arrow) {
            final Arrow arrow = (Arrow)entity.getDamager();
            if (arrow.getShooter() instanceof Player) {
                final Player player = (Player)arrow.getShooter();
                final Damageable pl = (Damageable)entity.getEntity();
                if (pl instanceof Player) {
                    final Player v = (Player)pl;
                    final double ptviev = pl.getHealth();
                    final Integer damage = (int)entity.getFinalDamage();
                    if (!pl.isDead()) {
                        final Integer realHealth = (int)(ptviev - damage);
                        if (realHealth > 0) {
                            player.sendMessage(Main.getInstance().games.prefix + ChatColor.GREEN + v.getName() + ChatColor.AQUA + " est maintenant a " + ChatColor.RED + realHealth + ChatColor.AQUA + " coeurs!");
                        }
                    }
                }
            }
        }
    }
}
