package fr.sithey.uhc.tasks;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.gui.*;
import fr.sithey.uhc.scenarios.CoordinateRunnable;
import fr.sithey.uhc.scenarios.FinalHealRunnable;
import fr.sithey.uhc.scenarios.SkyHighRunnable;
import fr.sithey.uhc.scenarios.special.TaupeGunRunnable;
import fr.sithey.uhc.tasks.world.Scatter;
import fr.sithey.uhc.teams.Teams;
import fr.sithey.uhc.utils.api.InventoryAPI;
import fr.sithey.uhc.utils.api.Title;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import fr.sithey.uhc.utils.uhcgame.Status;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;

public class Start extends BukkitRunnable {
    private Main main = Main.getInstance();

    @Override
    public void run() {
        for (Player players : Bukkit.getOnlinePlayers()) {
            Bukkit.getPlayer(players.getUniqueId()).setLevel(main.timers.starttime);
        }
        ArrayList<Player> random = new ArrayList<>();

        if (main.timers.starttime == 30) {
            for (Player players : Bukkit.getOnlinePlayers()) {
                players.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 9999, 255));
                players.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 9999, 50));
                players.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 9999, 255));
                players.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 9999, 30));
                players.playSound(players.getLocation(), Sound.EAT, 2, 2);
            }
            if (!main.games.isChatmute()) {
                main.games.toggleChatmute();
                Bukkit.broadcastMessage(main.games.prefix + "§6Le chat est maintenant mute !");
            }
            Bukkit.broadcastMessage(main.games.prefix + "§cBienvenue sur le host de §a" + Bukkit.getPlayer(main.games.host).getName() + "§c.");
            Bukkit.broadcastMessage(main.games.prefix + "§aVous avez les commandes §b/rules §aet §b/scenario\n" + main.games.prefix + "§apour avoir toutes les informations de la partie de §4§l" + (main.games.scoreboard.equals("§c♛♛♛ §6Royal§7-§eUHC §c♛♛♛") ? "l'UHC" : main.games.scoreboard) + "§a.");
            Bukkit.broadcastMessage(main.games.prefix + "§eLe PvP s'activera à §b" + new SimpleDateFormat("mm:ss").format(main.timers.PvPTimer * 1000) + " §eminute(s) !\n");
            Bukkit.broadcastMessage(main.games.prefix + "§eLa Bordure s'activera à §b" + new SimpleDateFormat("mm:ss").format(main.timers.BorderTimer * 1000) + " §eminute(s) !\n");
            Bukkit.broadcastMessage(main.games.prefix + "§eLa Bordure est en §b" + ((int) Bukkit.getWorld("world").getWorldBorder().getSize()) / 2 + " x " + ((int) Bukkit.getWorld("world").getWorldBorder().getSize()) / 2 + " \n" + main.games.prefix + "§eet se rétrécira en §b" + main.games.borderfinal + " x " + main.games.borderfinal + " §een §b" + new SimpleDateFormat("mm:ss").format(main.games.bordertime * 1000) + " §eminute(s) !");
        }

        if (main.timers.starttime == 27) {
            Bukkit.broadcastMessage(main.games.prefix + "§eInformation concernant le minage :");
            for (Minage.MinageE minage : Minage.MinageE.values())
                Bukkit.broadcastMessage(main.games.prefix + "§6" + minage.getName() + " : " + (minage.isEnabled() ? "§a✔" : "§4✖"));
            for (Player players : Bukkit.getOnlinePlayers()) {
                players.playSound(players.getLocation(), Sound.EAT, 2, 2);
            }
        }

        if (main.timers.starttime == 24) {
            Bukkit.broadcastMessage(main.games.prefix + "§eInformations spéciales :");
            for (Special.SpecialE speciaux : Special.SpecialE.values())
                Bukkit.broadcastMessage(main.games.prefix + "§6" + speciaux.getName() + " : " + (speciaux.isEnabled() ? "§a✔" : "§4✖"));
            for (Player players : Bukkit.getOnlinePlayers()) {
                players.playSound(players.getLocation(), Sound.EAT, 2, 2);
            }
        }

        if (main.timers.starttime == 21) {
            Bukkit.broadcastMessage(main.games.prefix + "§eInformations du nether :");
            Bukkit.broadcastMessage(main.games.prefix + "§6Nether" + " : " + (Configuration.NetherE.NETHER.isEnabled() ? "§a✔" : "§4✖"));
            for (Potion.POTIONE potion : Potion.POTIONE.values())
                Bukkit.broadcastMessage(main.games.prefix + "§6" + potion.getName() + " : " + (potion.isEnabled() ? "§a✔" : "§4✖"));
            for (Player players : Bukkit.getOnlinePlayers()) {
                players.playSound(players.getLocation(), Sound.EAT, 2, 2);
            }
        }


        if (main.timers.starttime == 18) {
            Bukkit.broadcastMessage(main.games.prefix + "§eInformations du Monde :");
            Bukkit.broadcastMessage(main.games.prefix + "§6Taux de pommes : §b" + main.games.applerate);
            Bukkit.broadcastMessage(main.games.prefix + "§6Taux de pommes en or : §b" + main.games.gapplerate);
            Bukkit.broadcastMessage(main.games.prefix + "§6Taux de flint : §b" + main.games.flintrate);
            Bukkit.broadcastMessage(main.games.prefix + "§6Chevaux " + (main.games.getHorse() ? "§a✔" : "§4✖"));
            Bukkit.broadcastMessage(main.games.prefix + "§6Degat de pearl §b" + main.games.damagepearl);
            for (Player players : Bukkit.getOnlinePlayers()) {
                players.playSound(players.getLocation(), Sound.EAT, 2, 2);
            }
        }

        if (main.timers.starttime == 15) {
            Bukkit.broadcastMessage(main.games.prefix + "§eInformations des Teams :");
            Bukkit.broadcastMessage(main.games.prefix + "§6Mode de jeu : §b" + (main.games.maxparteams == 1 ? "FFA" : main.games.maxparteams));
            Bukkit.broadcastMessage(main.games.prefix + "§6RandomTeam " + (Team.TeamsE.RANDOM.isEnabled() ? "§a✔" : "§4✖"));
            Bukkit.broadcastMessage(main.games.prefix + "§6Team Kill : " + (Team.TeamsE.TEAMKILL.isEnabled() ? "§a✔" : "§4✖"));
            for (Player players : Bukkit.getOnlinePlayers()) {
                players.playSound(players.getLocation(), Sound.EAT, 2, 2);
            }
        }

        if (main.timers.starttime == 12) {
            Bukkit.broadcastMessage(main.games.prefix + "§eScénarios de la partie : ");
            for (Player players : Bukkit.getOnlinePlayers()) {
                players.playSound(players.getLocation(), Sound.EAT, 2, 2);
                players.performCommand("scenario gui");
            }
        }


        if (main.timers.starttime == 10 || main.timers.starttime == 5 || main.timers.starttime == 4
                || main.timers.starttime == 3 || main.timers.starttime == 2 || main.timers.starttime == 1) {
            Bukkit.broadcastMessage(main.games.prefix + "§6Démarrage de la partie dans §f§o" + new SimpleDateFormat("mm:ss").format(main.timers.starttime * 1000) + " §eminute(s) !");
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.playSound(player.getLocation(), Sound.NOTE_SNARE_DRUM, 2, 2);
                Title.sendTitle(player, 5, 20, 5, "§e" + main.timers.starttime, "");
            }
        }

        if (main.timers.starttime == 5) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20, 255));
                player.playSound(player.getLocation(), Sound.NOTE_SNARE_DRUM, 2, 2);
            }
        }

        if (main.timers.starttime == 1) {
            for (Player players : Bukkit.getOnlinePlayers()) {
                players.playSound(players.getLocation(), Sound.NOTE_SNARE_DRUM, 2, 2);

            }
        }
        if (main.timers.starttime == 0) {

            main.setStatus(Status.JEU);
            main.getServer().setWhitelist(true);

            main.getServer().setWhitelist(true);

            for (Player players : Bukkit.getOnlinePlayers()) {
                main.stats.diamond.put(players.getUniqueId(), 0);
                main.stats.gold.put(players.getUniqueId(), 0);
                main.stats.kills.put(players.getUniqueId(), 0);
                players.playSound(players.getLocation(), Sound.NOTE_SNARE_DRUM, 2, 2);
                players.getInventory().clear();
                players.getInventory().setArmorContents(null);
                players.setMaximumNoDamageTicks(20);
                players.setFoodLevel(25);
                players.setGameMode(GameMode.SURVIVAL);
                InventoryAPI inventaire = new InventoryAPI(players, null);
                inventaire.giveInvent();
                players.setWhitelisted(true);
                if (Teams.getTeamWithPlayer(players) == null || Teams.getTeamWithPlayer(players).getAlive().size() == 1) {
                    random.add(players);
                }
                Collections.shuffle(random);
                for (Player randoms : random)
                    main.teamsManager.randomTeam(randoms);
            }

            new Scatter().runTaskTimer(main, 0L, 10);
            PvP start = new PvP();
            start.runTaskTimer(Main.getInstance(), 10 * main.games.alive.size(), 20);
            Border start1 = new Border();
            start1.runTaskTimer(Main.getInstance(), 10 * main.games.alive.size(), 20);
            Damage start2 = new Damage();
            start2.runTaskTimer(Main.getInstance(), 10 * main.games.alive.size(), 20);
            Timers start4 = new Timers();
            start4.runTaskTimer(Main.getInstance(), 10 * main.games.alive.size(), 20);
            if (GuiScenarioEnum.TAUPEGUN.isEnabled()){
                TaupeGunRunnable start5 = new TaupeGunRunnable();
                start5.runTaskTimer(Main.getInstance(), 10 * main.games.alive.size(), 20);
            }
            for (Teams team : Teams.values()) {
                if (team.getSize() == 0)
                    team.toogleDeath();
                if (GuiScenarioEnum.TAUPEGUN.isEnabled() && Teams.TAUPE.getDeath() && team.getName().equalsIgnoreCase(Teams.TAUPE.getName()))
                    team.toogleDeath();
                if (!team.getDeath()) {
                    if (!(main.games.teams.contains(team))) {
                        main.games.teams.add(team);
                    }
                }
            }

                if (GuiScenarioEnum.SKYHIGH.isEnabled()) {
                    SkyHighRunnable start5 = new SkyHighRunnable();
                    start5.runTaskTimer(Main.getInstance(), 0, 20);
                }
                if (GuiScenarioEnum.FINALHEAL.isEnabled()) {
                    FinalHealRunnable start6 = new FinalHealRunnable();
                    start6.runTaskTimer(Main.getInstance(), 0, 20);
                }
                if (GuiScenarioEnum.NETHERIBUS.isEnabled()) {
                    SkyHighRunnable start7 = new SkyHighRunnable();
                    start7.runTaskTimer(Main.getInstance(), 0, 20);
                }

                if (GuiScenarioEnum.COORDINATE.isEnabled()) {
                    CoordinateRunnable start8 = new CoordinateRunnable();
                    start8.runTaskTimer(Main.getInstance(), 0, 20);
                }
                if (GuiScenarioEnum.BESTPVE.isEnabled()) {

                    for (Player player : Bukkit.getOnlinePlayers()) {
                        main.getServer().getScheduler().scheduleSyncDelayedTask(main, new Runnable() {
                            @Override
                            public void run() {
                                main.games.bestpve.add(player.getUniqueId());
                            }
                        }, 30 * 20);

                        main.getServer().getScheduler().scheduleSyncRepeatingTask(main, new Runnable() {
                            @Override
                            public void run() {
                                if (main.games.bestpve.contains(player.getUniqueId())) {
                                    player.setMaxHealth(player.getMaxHealth() + 2);
                                }
                            }
                        }, 20 * 10 * 60, 20 * 10 * 60);
                    }
                }
                if (GuiScenarioEnum.BESTBTC.isEnabled()) {

                    for (Player player : Bukkit.getOnlinePlayers()) {
                        main.getServer().getScheduler().scheduleSyncRepeatingTask(main, new Runnable() {
                            @Override
                            public void run() {
                                if (main.games.bestbtc.contains(player.getUniqueId())) {
                                    player.setMaxHealth(player.getMaxHealth() + 2);
                                }
                            }
                        }, 20 * 10 * 60, 20 * 10 * 60);
                    }
                }



            cancel();
        }
        main.timers.starttime--;

    }
}
