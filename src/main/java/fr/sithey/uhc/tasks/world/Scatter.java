package fr.sithey.uhc.tasks.world;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.scenarios.StuffGive;
import fr.sithey.uhc.scenarios.SuperHeroes;
import fr.sithey.uhc.teams.Teams;
import fr.sithey.uhc.utils.api.ItemCreator;
import fr.sithey.uhc.utils.api.Title;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class Scatter extends BukkitRunnable {
    public ArrayList<String> playertp;
    int b;
    boolean oktp;
    private boolean j;
    public ArrayList<Player> players;

    public Scatter() {
        this.playertp = new ArrayList<>();
        this.b = (int) (Bukkit.getWorld("world").getWorldBorder().getSize() - 5);
        this.oktp = true;
        this.j = true;
        this.players = new ArrayList<>();
    }

    public void run() {
        if (this.j) {
            for (final UUID player : Main.getInstance().games.alive) {
                this.players.add(Bukkit.getPlayer(player));
            }
            this.j = false;
        }
        if (this.players.size() == 0) {
            this.cancel();
            for (Teams t : Teams.values()) {
                for (UUID pl : t.getMembers()) {
                    Bukkit.getPlayer(pl).teleport(Bukkit.getPlayer(t.getMembers().get(0)));
                }
            }
            for (Player players : Bukkit.getOnlinePlayers()) {
                players.getActivePotionEffects().forEach(potion -> players.removePotionEffect(potion.getType()));

                players.playSound(players.getLocation(), Sound.ENDERDRAGON_GROWL, 2, 2);
            }
            Main.getInstance().getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    if (Main.getInstance().games.isChatmute()) {
                        Main.getInstance().games.toggleChatmute();
                        Bukkit.broadcastMessage(Main.getInstance().games.prefix + "§6Le chat est maintenant activé !");
                    }
                }
            }, 30 * 20L);
            if (GuiScenarioEnum.SUPERHEROES.isEnabled())
                SuperHeroes.superxs();
            if (GuiScenarioEnum.STUFFGIVE.isEnabled()) {
                StuffGive.superxs();
                for (Player player : Bukkit.getOnlinePlayers())
                    player.getInventory().addItem(new ItemCreator(Material.COOKED_BEEF).setAmount(64).getItem());
            }
            for (Player players : Bukkit.getOnlinePlayers()) {
                if (GuiScenarioEnum.GONEFISHING.isEnabled()) {
                    players.getInventory().addItem(new ItemCreator(Material.FISHING_ROD).addEnchantment(Enchantment.LURE, 5).addEnchantment(Enchantment.LUCK, 255).addEnchantment(Enchantment.DURABILITY, 255).getItem());
                    players.getInventory().addItem(new ItemCreator(Material.ANVIL).setAmount(64).getItem());
                    players.setLevel(258458487);
                }
                if (GuiScenarioEnum.BOOKCEPTION.isEnabled())
                    players.setLevel(258458487);
                if (GuiScenarioEnum.CATEEYES.isEnabled())
                    players.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 99999999, 1, false, false));
                if (GuiScenarioEnum.COMBO.isEnabled())
                    players.setMaximumNoDamageTicks(7);
                if (GuiScenarioEnum.INFINITYENCHANTER.isEnabled()) {
                    players.setLevel(258458487);
                    players.getInventory().addItem(new ItemCreator(Material.BOOKSHELF).setAmount(64).getItem());
                    players.getInventory().addItem(new ItemCreator(Material.ENCHANTMENT_TABLE).setAmount(64).getItem());
                    players.getInventory().addItem(new ItemCreator(Material.ANVIL).setAmount(64).getItem());
                    players.getInventory().addItem(new ItemCreator(Material.LAPIS_BLOCK).setAmount(64).getItem());

                }

                if (GuiScenarioEnum.NINESLOTS.isEnabled()) {
                    for (int i = 9; i <= 35; i++)
                        players.getInventory().setItem(i, new ItemCreator(Material.BEDROCK).getItem());

                }
                if (GuiScenarioEnum.ONEHEAL.isEnabled()) {
                    players.getInventory().addItem(new ItemCreator(Material.GOLD_HOE).setName("OneHeal").getItem());
                }

            }

            Bukkit.getWorld("world").setTime(1000);
        }
        else {
            final Random random = new Random();
            final Player player2 = this.players.get(random.nextInt(this.players.size()));
            int x = (new Random().nextInt(2) == 0 ? +1 : -1) * new Random().nextInt(  b / 2 );
            int z =(new Random().nextInt(2) == 0 ? +1 : -1) * new Random().nextInt(  b / 2 );
            if (player2.isOnline()) {
                if (player2.getGameMode() != GameMode.SPECTATOR) {
                    player2.setGameMode(GameMode.SURVIVAL);
                    player2.setSaturation(30.0f);
                    final Block surfaceAirBlock = Bukkit.getWorld("world").getHighestBlockAt(new Location(Bukkit.getWorld("world"), (double)x, 80.0, (double)z));
                    final Block surfaceBlock = surfaceAirBlock.getRelative(BlockFace.DOWN);
                    if (!Main.getInstance().getServer().getWorld("world").getChunkAt(x, z).isLoaded())
                        Main.getInstance().getServer().getWorld("world").getChunkAt(x, z).load();
                    player2.teleport(new Location(Bukkit.getWorld("world"), (double)x, (double)(surfaceBlock.getLocation().getBlockY() + 20), z));
                    if (player2.getLocation().getBlockY() > 150) {
                        player2.teleport(new Location(Bukkit.getWorld("world"), (double)x, 140.0, (double)z));
                    }
                    for (final Player o : Bukkit.getOnlinePlayers()) {
                        Title.sendActionBar(o, "§6Teleportation de §e" + player2.getName());
                    }
                }
                else {
                    player2.setGameMode(GameMode.SPECTATOR);
                }
                this.players.remove(player2);
            }
            else {
                this.players.remove(player2);
            }
        }
    }


}
