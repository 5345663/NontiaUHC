package fr.sithey.uhc.scenarios;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.Scenarios;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class BloodDiamond extends Scenarios implements Listener {

    public BloodDiamond() {
    }

    @EventHandler(priority = EventPriority.LOW)
    public void brek(BlockBreakEvent event) {
        if (GuiScenarioEnum.BLOODDIAMOND.isEnabled()) {
            Block block = event.getBlock();
            Player player = event.getPlayer();
            if (block.getType() == Material.DIAMOND_ORE) {
                damage(player, Main.getInstance().games.blooddamage);
            }
        }
    }

    protected void damage(Player player, double amount) {
        EntityDamageEvent event = new EntityDamageEvent(player, DamageCause.CUSTOM, amount);
        Bukkit.getPluginManager().callEvent(event);
        player.damage(event.getDamage());
    }

    public void configure() {
        scenario = GuiScenarioEnum.BLOODDIAMOND;
    }

    public void activate(Player player) {
        Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
        player.sendMessage("§6 - /specialsc blooddiamond <" + Main.getInstance().games.blooddamage + ">");
    }

    public void execute() {
    }

}
