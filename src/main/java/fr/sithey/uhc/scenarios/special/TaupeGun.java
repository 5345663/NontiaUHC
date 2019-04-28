package fr.sithey.uhc.scenarios.special;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.teams.Teams;
import fr.sithey.uhc.utils.api.*;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Random;
import java.util.UUID;

public class TaupeGun extends Scenarios implements Listener, CommandExecutor {

    public static void sendTaupe(){
        for (Teams teams : Main.getInstance().games.teams) {
            Random random = new Random();
            if (!teams.getName().equalsIgnoreCase(Teams.TAUPE.getName())) {
                int r = random.nextInt(teams.getAlive().size());
                if (!Main.getInstance().games.taupe.contains(teams.getAlive().get(r)))
                Main.getInstance().games.taupe.add(teams.getAlive().get(r));
            }
        }
        for (UUID taupe : Main.getInstance().games.taupe) {
            Bukkit.getPlayer(taupe).sendMessage(Main.getInstance().games.prefix + "Vous etes la taupe !\n" +
                    "\n" +
                    Main.getInstance().games.prefix + "Commandes:\n" +
                    Main.getInstance().games.prefix + "/taupe <message> | envoyez un message au taupe.\n" +
                    Main.getInstance().games.prefix + "/kit | utiliser votre kit de taupe.\n" +
                    Main.getInstance().games.prefix + "/reveal | se reveal en tant que taupe.");
            Title.sendTitle(Bukkit.getPlayer(taupe), 5, 20, 5, Main.getInstance().games.prefix, "§4Vous etes la taupe !");
        }
    }


    @Override
    public void configure() {
        scenario = GuiScenarioEnum.TAUPEGUN;
    }

    @Override
    public void activate(Player player) {
        player.sendMessage("§6 - /specialsc taupe <" + Main.getInstance().games.taupetime / 60 + ">(minutes)");
        Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)){
            return true;
        }
        Player player = (Player) sender;
        if (Main.getInstance().games.taupe.contains(player.getUniqueId())){
            if (cmd.getName().equalsIgnoreCase("taupe")){
                if (args.length == 0) {
                    player.sendMessage("§cutilise /taupe <msg>");
                }
                String message = "";
                for (int i = 0; i < args.length; i++) {
                    message = message + args[i] + " ";
                }

                for (Player taupe : Bukkit.getOnlinePlayers()) {
                    if (Main.getInstance().games.taupe.contains(taupe.getUniqueId())) {
                        taupe.sendMessage("§8(§4Taupe§8) §7- §c" + player.getName() + "§7 : §4" + message);
                    }
                }
            }
            if (cmd.getName().equalsIgnoreCase("kit")){
                if (!Main.getInstance().games.kitcmd.contains(player.getUniqueId())) {
                    Main.getInstance().games.kitcmd.add(player.getUniqueId());
                    giveRandomKit(player);
                }
            }
            if (cmd.getName().equalsIgnoreCase("reveal")){
                if (!Teams.getTeamWithPlayer(player).getName().equals(Teams.TAUPE.getName())) {
                    Bukkit.broadcastMessage(Main.getInstance().games.prefix + "§4Le joueur §c§o§l" + player.getName() + " §4viens de se §6§l§oreveal !");
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        players.playSound(players.getLocation(), Sound.ENDERDRAGON_HIT, 2F, 1F);
                    }
                    Main.getInstance().teamsManager.addPlayer(Teams.TAUPE, player);
                    Win.checkDeath();
                    Win.checkWin();
                }
            }
        }
        return false;
    }

    public static void giveRandomKit(final Player p) {
        final Random random = new Random();
        final int randomkit = random.nextInt(4);
        if (randomkit == 0) {
            p.getInventory().addItem(new ItemCreator(Material.BOW).addEnchantment(Enchantment.ARROW_DAMAGE, 2).getItem());
            p.getInventory().addItem(new ItemCreator(Material.ARROW).setAmount(48).getItem());

        }
        else
        if (randomkit == 1) {
            p.getInventory().addItem(new ItemCreator(Material.GOLDEN_APPLE).setAmount(3).getItem());
            p.getInventory().addItem(new ItemCreator(Material.POTION).setAmount(2).setDurability(16453).getItem());
        }
        else
        if (randomkit == 2) {
            p.getInventory().addItem(new ItemCreator(Material.DIAMOND_PICKAXE).addEnchantment(Enchantment.DIG_SPEED, 2).addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1).getItem());
            p.getInventory().addItem(new ItemCreator(Material.IRON_HELMET).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).getItem());
            p.getInventory().addItem(new ItemCreator(Material.GOLD_INGOT).setAmount(8).getItem());
        }
        else
        if (randomkit == 3) {
            p.getInventory().addItem(new ItemCreator(Material.NETHER_WARTS).setAmount(5).getItem());
            p.getInventory().addItem(new ItemCreator(Material.POTION).setAmount(15).getItem());
            p.getInventory().addItem((new ItemCreator(Material.SPIDER_EYE).getItem()));
            p.getInventory().addItem((new ItemCreator(Material.FERMENTED_SPIDER_EYE).getItem()));
            p.getInventory().addItem((new ItemCreator(Material.GOLDEN_CARROT).getItem()));
        }

    }
}
