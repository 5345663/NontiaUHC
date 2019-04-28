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
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BareBones extends Scenarios implements Listener {

    public BareBones() {
    }

    @EventHandler
    public void Break(BlockBreakEvent ev) {
        Block b = ev.getBlock();
        org.bukkit.Location loc = b.getLocation();
        if (GuiScenarioEnum.BAREBONES.isEnabled()) {
            if (b.getType() == Material.DIAMOND_ORE) {
                b.getWorld().dropItem(loc, new ItemStack(Material.IRON_INGOT));
                ExperienceOrb exp = b.getWorld().spawn(b.getLocation(), ExperienceOrb.class);
                exp.setExperience(3);
                b.setType(Material.AIR);
            }
            if (b.getType() == Material.GOLD_ORE) {
                b.getWorld().dropItem(loc, new ItemStack(Material.IRON_INGOT));
                ExperienceOrb exp = b.getWorld().spawn(b.getLocation(), ExperienceOrb.class);
                exp.setExperience(3);
                b.setType(Material.AIR);
            }
            if (b.getType() == Material.LAPIS_ORE) {
                b.getWorld().dropItem(loc, new ItemStack(Material.IRON_INGOT));
                ExperienceOrb exp = b.getWorld().spawn(b.getLocation(), ExperienceOrb.class);
                exp.setExperience(3);
                b.setType(Material.AIR);
            }
        }
    }

    @EventHandler
    public void onCraft(PrepareItemCraftEvent e) {
        if ((GuiScenarioEnum.BAREBONES.isEnabled()) && ((e.getInventory() instanceof CraftingInventory))) {
            CraftingInventory inv = e.getInventory();
            ItemStack AIR = new ItemStack(Material.AIR);
            if (inv.getResult().getType() == Material.ENCHANTMENT_TABLE)
                inv.setResult(AIR);
        }
    }

    @EventHandler
    public void dead(PlayerDeathEvent ev) {
        ItemStack goldenHead = new ItemStack(Material.GOLDEN_APPLE);
        ItemMeta gMeta = goldenHead.getItemMeta();
        gMeta.setDisplayName("§6Golden Head");
        goldenHead.setItemMeta(gMeta);
        Player p = ev.getEntity().getPlayer();
        if ((GuiScenarioEnum.BAREBONES.isEnabled())) {
            p.getWorld().dropItem(p.getLocation(), new ItemStack(Material.DIAMOND, 2));
            p.getWorld().dropItem(p.getLocation(), new ItemStack(Material.ARROW, 32));
            p.getWorld().dropItem(p.getLocation(), new ItemStack(Material.GOLDEN_APPLE, 1));
            p.getWorld().dropItem(p.getLocation(), new ItemStack(Material.STRING, 2));
            p.getWorld().dropItem(p.getLocation(), goldenHead);
        }
    }

    public void configure() {
        scenario = GuiScenarioEnum.BAREBONES;
    }

    public void activate(Player player) {
        org.bukkit.Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
    }

    public void execute() {
    }
}
