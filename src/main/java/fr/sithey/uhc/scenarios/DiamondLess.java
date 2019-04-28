package fr.sithey.uhc.scenarios;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.Scenarios;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

public class DiamondLess extends Scenarios implements Listener {

    public DiamondLess() {
    }

    @EventHandler
    public void Break(BlockBreakEvent ev) {
        Block b = ev.getBlock();
        if ((GuiScenarioEnum.DIAMONDLESS.isEnabled()) &&
                (b.getType() == Material.DIAMOND_ORE)) {
            b.getLocation().getBlock().setType(Material.AIR);
            ExperienceOrb exp = (ExperienceOrb) b.getWorld().spawn(b.getLocation(), ExperienceOrb.class);
            exp.setExperience(3);
        }
    }

    @EventHandler
    public void dead(PlayerDeathEvent ev) {
        Player p = ev.getEntity().getPlayer();
        if ((GuiScenarioEnum.DIAMONDLESS.isEnabled())) {
            p.getWorld().dropItem(p.getLocation(), new ItemStack(Material.DIAMOND, Main.getInstance().games.diamondkill));
        }
    }

    public void configure() {
        scenario = GuiScenarioEnum.DIAMONDLESS;
    }

    public void activate(Player player) {
        org.bukkit.Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
        player.sendMessage("§6 - /specialsc diamondless <" + Main.getInstance().games.diamondkill + ">");
    }

    public void execute() {
    }

}
