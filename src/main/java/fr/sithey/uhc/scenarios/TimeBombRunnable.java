package fr.sithey.uhc.scenarios;

import org.bukkit.block.Chest;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.scheduler.BukkitRunnable;

public class TimeBombRunnable extends BukkitRunnable {
    private Chest chest;
    private ArmorStand armorStand;
    private int count;

    public TimeBombRunnable(final Chest chest, final int count) {
        this.chest = chest;
        this.count = count;
        (this.armorStand = (ArmorStand)chest.getWorld().spawnEntity(chest.getLocation(), EntityType.ARMOR_STAND)).setVisible(false);
    }

    public void run() {
        if (this.chest.getBlock().isEmpty()) {
            this.armorStand.remove();
            this.cancel();
            return;
        }
        if (this.count == 0) {
            chest.getInventory().clear();
            this.chest.getLocation().getWorld().createExplosion(this.chest.getLocation(), 5.0f);
            this.armorStand.remove();
            this.cancel();
            return;
        }
        this.changeName();
        --this.count;
    }

    private void changeName() {
        this.armorStand = (ArmorStand)this.chest.getWorld().spawnEntity(this.chest.getLocation(), EntityType.ARMOR_STAND);
        for (final Entity entity : this.armorStand.getNearbyEntities(1.0, 1.0, 1.0)) {
            if (entity != null && entity instanceof ArmorStand) {
                entity.remove();
            }
        }
        this.armorStand.setVisible(false);
        this.armorStand.setGravity(false);
        this.armorStand.setCustomNameVisible(true);
        this.armorStand.setCustomName("§5" + this.count);
    }
}
