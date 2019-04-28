package fr.sithey.uhc.scenarios;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.Scenarios;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class TripleOres extends Scenarios implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (GuiScenarioEnum.TRIPLE_ORES.isEnabled()) {
            Block Block = event.getBlock();

            Location loc = new Location(Block.getWorld(), Block.getLocation().getBlockX() + 0.5D, Block.getLocation().getBlockY() + 0.5D, Block.getLocation().getBlockZ() + 0.5D);
            if (Block.getType() == Material.IRON_ORE) {
                Block.setType(Material.AIR);
                Block.getWorld().dropItem(loc, new ItemStack(Material.IRON_INGOT, 3));
                ((ExperienceOrb) Block.getWorld().spawn(loc, ExperienceOrb.class)).setExperience(6);
            }
            if (Block.getType() == Material.COAL_ORE) {
                Block.setType(Material.AIR);
                Block.getWorld().dropItem(loc, new ItemStack(Material.COAL, 3));
                ((ExperienceOrb) Block.getWorld().spawn(loc, ExperienceOrb.class)).setExperience(3);
            }
            if (Block.getType() == Material.GOLD_ORE) {
                Block.setType(Material.AIR);
                Block.getWorld().dropItem(loc, new ItemStack(Material.GOLD_INGOT, 3));
                ((ExperienceOrb) Block.getWorld().spawn(loc, ExperienceOrb.class)).setExperience(9);
            }
            if (Block.getType() == Material.DIAMOND_ORE) {
                Block.setType(Material.AIR);
                Block.getWorld().dropItem(loc, new ItemStack(Material.DIAMOND, 3));
                ((ExperienceOrb) Block.getWorld().spawn(loc, ExperienceOrb.class)).setExperience(12);
            }


            if (Block.getType() == Material.QUARTZ_ORE) {
                Block.setType(Material.AIR);
                Block.getWorld().dropItem(loc, new ItemStack(Material.QUARTZ, 3));
                ((ExperienceOrb) Block.getWorld().spawn(loc, ExperienceOrb.class)).setExperience(12);
            }
            if (Block.getType() == Material.EMERALD_ORE) {
                Block.setType(Material.AIR);
                Block.getWorld().dropItem(loc, new ItemStack(Material.EMERALD, 3));
                ((ExperienceOrb) Block.getWorld().spawn(loc, ExperienceOrb.class)).setExperience(15);
            }
        }
    }


    public void configure() {
        scenario = GuiScenarioEnum.TRIPLE_ORES;
    }

    @Override
    public void activate(Player player) {
        Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
    }


    public void execute() {
    }
}
