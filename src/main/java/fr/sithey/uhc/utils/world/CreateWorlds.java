package fr.sithey.uhc.utils.world;

import com.sk89q.worldedit.CuboidClipboard;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.schematic.MCEditSchematicFormat;
import com.sk89q.worldedit.world.DataException;
import fr.sithey.uhc.Main;
import fr.sithey.uhc.tasks.world.WorldLoarder;
import fr.sithey.uhc.utils.uhcgame.Status;
import org.bukkit.*;

import java.io.File;
import java.io.IOException;

import static org.bukkit.Bukkit.getServer;

public class CreateWorlds {
    private Main main = Main.getInstance();

    public void createWorlds(){
        main.getServer().createWorld(new WorldCreator("world"));
        main.getServer().createWorld(new WorldCreator("world_nether"));
        Location loc = new Location(Bukkit.getWorld("world"), 0, 200, 0);
        WorldEditPlugin worldEditPlugin = (WorldEditPlugin) Bukkit.getPluginManager().getPlugin("WorldEdit");
        File schematic = new File(Main.getInstance().getDataFolder().getPath()+"/schematic/spawn.schematic");
        EditSession session = worldEditPlugin.getWorldEdit().getEditSessionFactory().getEditSession(new BukkitWorld(loc.getWorld()), 999999999);
        try {
            CuboidClipboard clipboard = MCEditSchematicFormat.getFormat(schematic).load(schematic);
            clipboard.paste(session, new Vector(loc.getX(), loc.getY(), loc.getZ()), false);

        } catch (MaxChangedBlocksException | DataException | IOException e) {
            e.printStackTrace();
        }

        for (World world : Bukkit.getWorlds()){
            world.setPVP(false);
            world.setDifficulty(Difficulty.NORMAL);
            world.setTime(0);
            world.setGameRuleValue("naturalRegeneration", "false");
            world.setGameRuleValue("doFireTick", "false");
            world.setGameRuleValue("doDaylightCycle", "false");
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
