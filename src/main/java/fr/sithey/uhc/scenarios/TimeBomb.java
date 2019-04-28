package fr.sithey.uhc.scenarios;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.Scenarios;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;


public class TimeBomb extends Scenarios implements Listener {
    private static int count;

    private Main main = Main.getInstance();
    public TimeBomb() {
    }


    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerDeath(final PlayerDeathEvent event) {
        if (GuiScenarioEnum.TIMEBOMB.isEnabled()) {
            if (!event.getEntity().getWorld().equals(Bukkit.getWorld("octogone"))) {
                event.getEntity().getLocation().getBlock().setType(Material.CHEST);
                event.getEntity().getLocation().getBlock().getRelative(BlockFace.EAST).setType(Material.CHEST);
                final Chest chest = (Chest) event.getEntity().getLocation().getBlock().getState();
                for (final ItemStack itemStack : event.getDrops()) {
                    if (itemStack == null) {
                        continue;
                    }
                    chest.getInventory().addItem(new ItemStack[]{itemStack});
                }
                chest.update();
                event.getDrops().clear();
                new TimeBombRunnable(chest, TimeBomb.count).runTaskTimer((Main) Main.getInstance(), 0L, 20L);
            }
        }
    }

    public static int getCount() {
        return TimeBomb.count;
    }

    public static void setCount(final int count) {
        TimeBomb.count = count;
    }

    static {
        TimeBomb.count = 30;
    }


    public void configure() {
        scenario = GuiScenarioEnum.TIMEBOMB;
    }


    public void activate(Player player) {
        Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
    }

    public void execute() {
    }
}
