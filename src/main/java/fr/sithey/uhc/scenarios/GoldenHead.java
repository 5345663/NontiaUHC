package fr.sithey.uhc.scenarios;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.ItemCreator;
import fr.sithey.uhc.utils.api.Scenarios;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ShapedRecipe;

public class GoldenHead extends Scenarios implements Listener {

    public GoldenHead() {
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerDeah(PlayerDeathEvent event) {
        if (GuiScenarioEnum.GOLDENHEAD.isEnabled()) {
            Player player = event.getEntity();
            player.getWorld().dropItem(player.getLocation(), new ItemCreator(Material.SKULL_ITEM).setDurability(3).setOwner(player.getName()).setName("Head").getItem());
        }
    }

    public void configure() {
        scenario = GuiScenarioEnum.GOLDENHEAD;
    }


    public void activate(Player player) {
        org.bukkit.Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
        ShapedRecipe goldenhead = new ShapedRecipe(new ItemCreator(Material.GOLDEN_APPLE).setName("GoldenHead").getItem());
        goldenhead.shape("###", "#%#", "###");
        goldenhead.setIngredient('#', Material.GOLD_INGOT);
        goldenhead.setIngredient('%', Material.SKULL_ITEM, 3);
        Main.getInstance().getServer().addRecipe(goldenhead);
    }

    public void execute() {
    }
}
