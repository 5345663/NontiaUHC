package fr.sithey.uhc.cmd;

import fr.sithey.uhc.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class HCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player))
            return true;
        Player player = (Player) sender;
        if (player.isOp() || Main.getInstance().games.host == player.getUniqueId()) {
            if (cmd.getName().equalsIgnoreCase("htp")) {
                if (args.length == 1) {
                    Player cible = Bukkit.getPlayer(args[0]);
                    player.teleport(cible.getLocation());
                } else {
                    player.sendMessage("§6/htp <joueur>");
                }
            }
            if (cmd.getName().equalsIgnoreCase("hgamemode")) {
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("1"))
                        player.setGameMode(GameMode.CREATIVE);
                    if (args[0].equalsIgnoreCase("0"))
                        player.setGameMode(GameMode.SURVIVAL);
                    if (args[0].equalsIgnoreCase("2"))
                        player.setGameMode(GameMode.ADVENTURE);
                    if (args[0].equalsIgnoreCase("3"))
                        player.setGameMode(GameMode.SPECTATOR);
                } else {
                    player.sendMessage("§6/hgamemode <0/1/2/3>");
                }
            }
            if (cmd.getName().equalsIgnoreCase("hforce")) {
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("pvp"))
                        Main.getInstance().timers.PvPTimer = 0;
                    if (args[0].equalsIgnoreCase("bordure"))
                        Main.getInstance().timers.BorderTimer = 0;
                }
            }
            if (cmd.getName().equalsIgnoreCase("hstop"))
                Main.getInstance().getServer().shutdown();

            if (cmd.getName().equalsIgnoreCase("hchat"))
                Main.getInstance().games.toggleChatmute();
            if (cmd.getName().equalsIgnoreCase("hvote")) {
                if (args.length == 0) {
                    player.sendMessage("§6/hvote <message>");
                } else {
                    String message = "";
                    for (int i = 0; i < args.length; i++) {
                        message = message + args[i] + " ";
                    }
                    Main.getInstance().games.oui = 0;
                    Main.getInstance().games.non = 0;
                    Bukkit.broadcastMessage(Main.getInstance().games.prefix + "§bMerci de repondre par §a/oui §bou §c/non§b au vote :\n§6 " + message);
                    for (Player all : Bukkit.getOnlinePlayers())
                        Main.getInstance().games.vote.add(all);
                    Main.getInstance().getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                        @Override
                        public void run() {
                            Bukkit.broadcastMessage(Main.getInstance().games.prefix + "§bResultat du vote : §aOui : " + Main.getInstance().games.oui + " §cNon : " + Main.getInstance().games.non);
                            for (Player all : Bukkit.getOnlinePlayers())
                                Main.getInstance().games.vote.remove(all);
                        }
                    }, 30 * 20);
                }
            }
            if (cmd.getName().equalsIgnoreCase("hkick")) {
                if (args.length == 1) {
                    Player cible = Bukkit.getPlayer(args[0]);
                    cible.kickPlayer(Main.getInstance().games.prefix + "Vous etes kick de l'uhc !");
                    player.sendMessage(Main.getInstance().games.prefix + "Le joueur " + cible.getName() + " est maintenant kick !");
                }
            }
            if (cmd.getName().equalsIgnoreCase("hsay")) {
                if (args.length >= 1) {
                    Player p = (Player) sender;
                    StringBuilder string = new StringBuilder();
                    for (String part : args)
                        string.append(part + " ");
                    Bukkit.broadcastMessage(Main.getInstance().games.prefix + "§3(§bHost§3) §e" + p.getDisplayName() + " §6: " + string.toString());
                }
            }
            if (cmd.getName().equalsIgnoreCase("hmaxplayers")) {
                if (args.length == 1 && args[0] != null) {
                    int i = Integer.parseInt(args[0]);
                        if (i <= 80 && i > 0) {
                            Main.getInstance().games.maxplayers = i;
                            player.sendMessage(Main.getInstance().games.prefix + "§bLe nombre de joueur max est maintenant de §a" + i);
                        } else {
                            player.sendMessage(Main.getInstance().games.prefix + "§cLa limite de joueur est à 80 personnes.");
                        }
                    }
                }
            }
                if (cmd.getName().equalsIgnoreCase("hscoreboard")) {
                    String message = "";
                    for (int i = 0; i < args.length; i++) {
                        message = message + args[i] + " ";
                    }
                    if (args.length >= 1 && args[0] != null && message.length() <= 20) {

                        Main.getInstance().games.scoreboard = message.replace("&", "§");
                        player.sendMessage(Main.getInstance().games.prefix + "§bLe scoreboard viens d'etre changer ! §a" + Main.getInstance().games.scoreboard);
                    }
                }

                if (cmd.getName().equalsIgnoreCase("hwhitelist")) {
                    if (args.length == 0) {
                        player.sendMessage(Main.getInstance().games.prefix + "/hwhitelist on/off/add/remove/list");
                    }
                    if (args.length == 1) {
                        if (args[0].equalsIgnoreCase("on")) {
                            Main.getInstance().getServer().setWhitelist(true);
                            player.sendMessage(Main.getInstance().games.prefix + "§cWhitelist on");
                        }
                        if (args[0].equalsIgnoreCase("off")) {
                            Main.getInstance().getServer().setWhitelist(false);
                            player.sendMessage(Main.getInstance().games.prefix + "§aWhitelist off");

                        }
                        if (args[0].equalsIgnoreCase("list")) {
                            StringBuilder list = new StringBuilder();
                            int i = 1;
                            for (OfflinePlayer whitelisted : Bukkit.getWhitelistedPlayers()) {
                                if (list.length() > 0) {
                                    if (i == Bukkit.getWhitelistedPlayers().size()) {
                                        list.append(" et ");
                                    } else {
                                        list.append(", ");
                                    }
                                }
                                list.append(whitelisted.getName());
                                i++;
                            }
                            sender.sendMessage(Main.getInstance().games.prefix + "§7WhiteList: §b" + (i - 1) + " joueurs");
                            sender.sendMessage(Main.getInstance().games.prefix + "§7WhiteList: §7§o" + list.toString() + ".");
                        }
                    }
                    if (args.length == 2) {
                        Player cible = Bukkit.getPlayer(args[1]);
                        if (args[0].equalsIgnoreCase("add")) {
                            cible.setWhitelisted(true);
                            player.sendMessage(Main.getInstance().games.prefix + "§aWhitelist add " + cible.getDisplayName());
                        }
                        if (args[0].equalsIgnoreCase("remove")) {
                            cible.setWhitelisted(false);
                            player.sendMessage(Main.getInstance().games.prefix + "§cWhitelist remove " + cible.getDisplayName());

                        }
                    }
                }
            if (cmd.getName().equalsIgnoreCase("hrez")){
                if (args.length == 1) {
                    Player cible = Bukkit.getPlayer(args[0]);
                    if (Main.getInstance().games.alive.contains(cible.getUniqueId())) {
                        player.sendMessage(Main.getInstance().games.prefix + "§cJoueur en vie.");
                    } else {
                        cible.teleport(Main.getInstance().games.lastcoord.get(cible.getUniqueId()));
                        cible.setGameMode(GameMode.SURVIVAL);
                        for (ItemStack items : Main.getInstance().games.lastinv.get(cible.getUniqueId())) {
                            if (items != null)
                            cible.getInventory().addItem(items);
                        }
                        if (Main.getInstance().games.lastteams.get(cible.getUniqueId()) != null) {
                            Main.getInstance().teamsManager.addPlayer(Main.getInstance().games.lastteams.get(cible.getUniqueId()), cible);
                        }
                        player.sendMessage(Main.getInstance().games.prefix + "§cJoueur rez.");
                    }
                }
            }

            return false;
        }
    }
