package fr.sithey.uhc.listeners;

import fr.sithey.uhc.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Food implements Listener {
    @EventHandler
    public void onHunger(FoodLevelChangeEvent event){
        if (Main.getInstance().isLobby()){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onEat(PlayerItemConsumeEvent event){
        if (event.getItem().getItemMeta().getDisplayName() != null) {
            if (event.getItem().getItemMeta().getDisplayName().equals("GoldenHead")) {
                event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 200, 1));
            }
        }
    }
}
