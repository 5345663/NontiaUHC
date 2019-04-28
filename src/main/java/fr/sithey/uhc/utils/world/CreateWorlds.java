package fr.sithey.uhc.utils.world;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.tasks.world.WorldLoarder;
import fr.sithey.uhc.utils.uhcgame.Status;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.World;
import org.bukkit.WorldCreator;

import static org.bukkit.Bukkit.getServer;

public class CreateWorlds {
    private Main main = Main.getInstance();

    public void createWorlds(){
        main.getServer().createWorld(new WorldCreator("spawn"));
        main.getServer().createWorld(new WorldCreator("world"));
        main.getServer().createWorld(new WorldCreator("world_nether"));

        for (World world : Bukkit.getWorlds()){
            world.setPVP(false);
            world.setDifficulty(Difficulty.NORMAL);
            world.setTime(0);
            world.setGameRuleValue("naturalRegeneration", "false");
            world.setGameRuleValue("doFireTick", "false");
            if (world.getName().equalsIgnoreCase("spawn")){
                world.setDifficulty(Difficulty.PEACEFUL);
            }
            world.setAutoSave(false);
        }
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                Main.getInstance().isPregen = true;
                try {
                    if (Main.getInstance().isPregen) {
                        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new WorldLoarder(Bukkit.getWorld("world"), 500, 500, 0), 0L, 145L);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                main.setStatus(Status.ATTENTE);
            }
        }, 3*20);
    }
}
