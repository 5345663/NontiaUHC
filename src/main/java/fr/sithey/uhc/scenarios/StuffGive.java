package fr.sithey.uhc.scenarios;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.ItemCreator;
import fr.sithey.uhc.utils.api.Scenarios;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Random;

public class StuffGive extends Scenarios implements Listener {

    public static void superxs() {
        if (GuiScenarioEnum.STUFFGIVE.isEnabled()) {
            ArrayList SendL = new ArrayList();
            Random random = new Random();
            for (Player p : Bukkit.getOnlinePlayers()) {
                Random r = new Random();
                int alea = r.nextInt(6);
                switch (alea) {
                    case 0: {
                        p.getInventory().setItem(0, new ItemCreator(Material.IRON_SWORD).addEnchantment(Enchantment.DAMAGE_ALL, 3).getItem());
                        p.getInventory().setItem(1, new ItemCreator(Material.BOW).addEnchantment(Enchantment.ARROW_DAMAGE, 3).addEnchantment(Enchantment.ARROW_KNOCKBACK, 1).getItem());
                        p.getInventory().setItem(2, new ItemCreator(Material.GOLDEN_APPLE).setAmount(8).getItem());
                        p.getInventory().setItem(36, new ItemCreator(Material.DIAMOND_BOOTS).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).getItem());
                        p.getInventory().setItem(37, new ItemCreator(Material.IRON_LEGGINGS).addEnchantment(Enchantment.PROTECTION_PROJECTILE, 4).getItem());
                        p.getInventory().setItem(38, new ItemCreator(Material.IRON_CHESTPLATE).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).getItem());
                        p.getInventory().setItem(39, new ItemCreator(Material.DIAMOND_HELMET).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).getItem());

                        p.getInventory().addItem(new ItemCreator(Material.LAVA_BUCKET).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.WATER_BUCKET).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.WATER_BUCKET).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.FLINT_AND_STEEL).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.ANVIL).setAmount(4).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.ENCHANTMENT_TABLE).setAmount(3).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.WOOD).setAmount(64).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.COBBLESTONE).setAmount(64).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.COBBLESTONE).setAmount(64).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.ARROW).setAmount(32).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.FISHING_ROD).getItem());

                        break;
                    }
                    case 1: {
                        p.getInventory().setItem(0, new ItemCreator(Material.DIAMOND_SWORD).addEnchantment(Enchantment.DAMAGE_ALL, 2).getItem());
                        p.getInventory().setItem(1, new ItemCreator(Material.BOW).addEnchantment(Enchantment.ARROW_DAMAGE, 1).addEnchantment(Enchantment.ARROW_KNOCKBACK, 2).getItem());
                        p.getInventory().setItem(2, new ItemCreator(Material.GOLDEN_APPLE).setAmount(6).getItem());
                        p.getInventory().setItem(36, new ItemCreator(Material.DIAMOND_BOOTS).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).getItem());
                        p.getInventory().setItem(37, new ItemCreator(Material.IRON_LEGGINGS).addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2).getItem());
                        p.getInventory().setItem(38, new ItemCreator(Material.DIAMOND_CHESTPLATE).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).getItem());
                        p.getInventory().setItem(39, new ItemCreator(Material.DIAMOND_HELMET).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).getItem());


                        p.getInventory().addItem(new ItemCreator(Material.LAVA_BUCKET).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.WATER_BUCKET).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.WATER_BUCKET).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.FLINT_AND_STEEL).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.ANVIL).setAmount(4).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.ENCHANTMENT_TABLE).setAmount(3).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.WOOD).setAmount(64).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.COBBLESTONE).setAmount(64).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.COBBLESTONE).setAmount(64).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.ARROW).setAmount(32).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.FISHING_ROD).getItem());


                        break;
                    }
                    case 2: {
                        p.getInventory().setItem(0, new ItemCreator(Material.IRON_SWORD).addEnchantment(Enchantment.DAMAGE_ALL, 2).getItem());
                        p.getInventory().setItem(1, new ItemCreator(Material.BOW).addEnchantment(Enchantment.ARROW_DAMAGE, 4).getItem());
                        p.getInventory().setItem(2, new ItemCreator(Material.GOLDEN_APPLE).setAmount(9).getItem());
                        p.getInventory().setItem(36, new ItemCreator(Material.IRON_BOOTS).addEnchantment(Enchantment.PROTECTION_PROJECTILE, 3).getItem());
                        p.getInventory().setItem(37, new ItemCreator(Material.DIAMOND_LEGGINGS).addEnchantment(Enchantment.PROTECTION_PROJECTILE, 4).getItem());
                        p.getInventory().setItem(38, new ItemCreator(Material.IRON_CHESTPLATE).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).getItem());
                        p.getInventory().setItem(39, new ItemCreator(Material.DIAMOND_HELMET).addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2).getItem());




                        p.getInventory().addItem(new ItemCreator(Material.LAVA_BUCKET).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.WATER_BUCKET).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.WATER_BUCKET).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.FLINT_AND_STEEL).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.ANVIL).setAmount(4).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.ENCHANTMENT_TABLE).setAmount(3).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.WOOD).setAmount(64).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.COBBLESTONE).setAmount(64).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.COBBLESTONE).setAmount(64).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.ARROW).setAmount(32).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.FISHING_ROD).getItem());
                        break;
                    }
                    case 3: {
                        p.getInventory().setItem(0, new ItemCreator(Material.DIAMOND_SWORD).addEnchantment(Enchantment.DAMAGE_ALL, 3).getItem());
                        p.getInventory().setItem(1, new ItemCreator(Material.BOW).addEnchantment(Enchantment.ARROW_DAMAGE, 2).getItem());
                        p.getInventory().setItem(2, new ItemCreator(Material.GOLDEN_APPLE).setAmount(8).getItem());
                        p.getInventory().setItem(36, new ItemCreator(Material.DIAMOND_BOOTS).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).getItem());
                        p.getInventory().setItem(37, new ItemCreator(Material.IRON_LEGGINGS).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).getItem());
                        p.getInventory().setItem(38, new ItemCreator(Material.DIAMOND_CHESTPLATE).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).getItem());
                        p.getInventory().setItem(39, new ItemCreator(Material.DIAMOND_HELMET).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).getItem());



                        p.getInventory().addItem(new ItemCreator(Material.LAVA_BUCKET).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.WATER_BUCKET).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.WATER_BUCKET).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.FLINT_AND_STEEL).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.ANVIL).setAmount(4).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.ENCHANTMENT_TABLE).setAmount(3).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.WOOD).setAmount(64).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.COBBLESTONE).setAmount(64).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.COBBLESTONE).setAmount(64).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.ARROW).setAmount(32).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.FISHING_ROD).getItem());
                        break;
                    }
                    case 4: {
                        p.getInventory().setItem(0, new ItemCreator(Material.DIAMOND_SWORD).addEnchantment(Enchantment.DAMAGE_ALL, 4).getItem());
                        p.getInventory().setItem(1, new ItemCreator(Material.BOW).addEnchantment(Enchantment.ARROW_DAMAGE, 4).getItem());
                        p.getInventory().setItem(2, new ItemCreator(Material.GOLDEN_APPLE).setAmount(12).getItem());
                        p.getInventory().setItem(36, new ItemCreator(Material.DIAMOND_BOOTS).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).getItem());
                        p.getInventory().setItem(37, new ItemCreator(Material.IRON_LEGGINGS).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).getItem());
                        p.getInventory().setItem(38, new ItemCreator(Material.IRON_CHESTPLATE).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).getItem());
                        p.getInventory().setItem(39, new ItemCreator(Material.IRON_HELMET).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).getItem());



                        p.getInventory().addItem(new ItemCreator(Material.LAVA_BUCKET).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.WATER_BUCKET).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.WATER_BUCKET).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.FLINT_AND_STEEL).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.ANVIL).setAmount(4).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.ENCHANTMENT_TABLE).setAmount(3).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.WOOD).setAmount(64).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.COBBLESTONE).setAmount(64).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.COBBLESTONE).setAmount(64).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.ARROW).setAmount(32).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.FISHING_ROD).getItem());
                        break;
                    }
                    case 5: {
                        p.getInventory().setItem(0, new ItemCreator(Material.IRON_SWORD).addEnchantment(Enchantment.DAMAGE_ALL, 2).getItem());
                        p.getInventory().setItem(1, new ItemCreator(Material.BOW).addEnchantment(Enchantment.ARROW_DAMAGE, 1).getItem());
                        p.getInventory().setItem(2, new ItemCreator(Material.GOLDEN_APPLE).setAmount(4).getItem());
                        p.getInventory().setItem(36, new ItemCreator(Material.DIAMOND_BOOTS).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).getItem());
                        p.getInventory().setItem(37, new ItemCreator(Material.DIAMOND_LEGGINGS).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).getItem());
                        p.getInventory().setItem(38, new ItemCreator(Material.IRON_CHESTPLATE).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).getItem());
                        p.getInventory().setItem(39, new ItemCreator(Material.DIAMOND_HELMET).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).getItem());



                        p.getInventory().addItem(new ItemCreator(Material.LAVA_BUCKET).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.WATER_BUCKET).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.WATER_BUCKET).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.FLINT_AND_STEEL).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.ANVIL).setAmount(4).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.ENCHANTMENT_TABLE).setAmount(3).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.WOOD).setAmount(64).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.COBBLESTONE).setAmount(64).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.COBBLESTONE).setAmount(64).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.ARROW).setAmount(32).getItem());
                        p.getInventory().addItem(new ItemCreator(Material.FISHING_ROD).getItem());
                        break;
                    }
                }
            }
        }
    }


    public void configure() {
        scenario = GuiScenarioEnum.STUFFGIVE;
    }


    public void activate(Player player) {
        Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
    }

    public void execute() {
    }
}
