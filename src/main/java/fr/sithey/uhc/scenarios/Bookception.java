package fr.sithey.uhc.scenarios;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.Scenarios;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bookception extends Scenarios implements Listener {

    public Bookception() {
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerDeah(PlayerDeathEvent event) {
        if ((GuiScenarioEnum.BOOKCEPTION.isEnabled())) {
            ItemStack is = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta m = (EnchantmentStorageMeta) is.getItemMeta();
            List<Enchantment> enchants = new ArrayList();
            for (Enchantment enchantment : Enchantment.values()) {
                enchants.add(enchantment);
            }
            Random r = new Random();
            Enchantment enchantement = (Enchantment) enchants.get(r.nextInt(enchants.size()));
            m.addStoredEnchant(enchantement, r.nextInt(enchantement.getMaxLevel() + 1), true);
            is.setItemMeta(m);
            event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(), is);
        }
    }

    public void configure() {
        scenario = GuiScenarioEnum.BOOKCEPTION;
    }


    public void activate(Player player) {
        org.bukkit.Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
    }

    public void execute() {
    }
}
