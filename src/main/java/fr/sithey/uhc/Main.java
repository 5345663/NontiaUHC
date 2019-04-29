package fr.sithey.uhc;

import fr.sithey.uhc.scoreboard.ScoreboardSign;
import fr.sithey.uhc.teams.TeamsManager;
import fr.sithey.uhc.utils.api.ScoreboardLife;
import fr.sithey.uhc.utils.register.Commandes;
import fr.sithey.uhc.utils.register.GUI;
import fr.sithey.uhc.utils.register.Listeners;
import fr.sithey.uhc.utils.uhcgame.Games;
import fr.sithey.uhc.utils.uhcgame.Stats;
import fr.sithey.uhc.utils.uhcgame.Status;
import fr.sithey.uhc.utils.uhcgame.Timers;
import fr.sithey.uhc.utils.world.Biomes;
import fr.sithey.uhc.utils.world.Border;
import fr.sithey.uhc.utils.world.CreateWorlds;
import fr.sithey.uhc.utils.world.RemoveWorlds;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Main extends JavaPlugin {
    public static Main instance;
    public Games games;
    public Timers timers;
    public Status status;
    public Stats stats;
    public GUI gui;
    public Map<Player, ScoreboardSign> boards = new HashMap<>();
    public TeamsManager teamsManager;
    public boolean isPregen = false;

    @Override
    public void onEnable() {
        instance = this;
        getServer().setWhitelist(true);
        getServer().getWhitelistedPlayers().clear();
        ScoreboardLife.setup();
        timers = new Timers();
        games = new Games();
        stats = new Stats();
        teamsManager = new TeamsManager();
        gui = new GUI();
        gui.registersGUI();
        new Listeners().registerEvents();
        new Commandes().registerCommands();
        setStatus(Status.PREGEN);
        new Border().createBorder();
        for (Player p : Bukkit.getOnlinePlayers()) {
            Bukkit.getPluginManager().callEvent(new PlayerJoinEvent(p, null));
        }
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                for (Player players : Bukkit.getOnlinePlayers())
                    if (players.getGameMode().equals(GameMode.SPECTATOR))
                        players.setPlayerListName("§8"+players.getName());
            }
        }, 20 * 30, 40);
        Bukkit.getServer().getScheduler().runTaskTimerAsynchronously(this, new Runnable() {
            @Override
            public void run() {
                for (final Player pl : Bukkit.getOnlinePlayers()) {
                    ScoreboardLife.setHealth(pl);
                }
            }
        }, 0L, 10L);

        teamsManager.createTeams();
        new CreateWorlds().createWorlds();

    }

    //NIWAREESTMOCHE
    @Override
    public void onDisable() {
        teamsManager.deleteTeams();
        for (ScoreboardSign scoreboard : boards.values()) {
            boards.remove(null, scoreboard);
            scoreboard.destroy();
        }
        new RemoveWorlds().deleteWorld(new File("world"));
        new RemoveWorlds().deleteWorld(new File("world_nether"));

    }
    @Override
    public void onLoad() {
        new Biomes().removeBiomes();
    }


    public static Main getInstance(){
        return instance;
    }
    public void setStatus(Status status){this.status = status;}
    public boolean isStatus(Status status){return this.status == status;}
    public boolean isLobby() {
        return isStatus(Status.ATTENTE) || isStatus(Status.TP);
    }
    public Location spawn() { return  new Location(Bukkit.getWorld("world"), 0, 200, 0);}


}
