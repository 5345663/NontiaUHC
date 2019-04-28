package fr.sithey.uhc.utils.api;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardLife {
    private static Objective health;
    private static Objective healthBelow;

    public static void setup() {
        final Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        if (scoreboard.getObjective("health") == null) {
            ScoreboardLife.health = scoreboard.registerNewObjective("health", "dummy");
        }
        else {
            scoreboard.getObjective("health").unregister();
            ScoreboardLife.health = scoreboard.registerNewObjective("health", "dummy");
        }
        if (scoreboard.getObjective("healthBelow") == null) {
            ScoreboardLife.healthBelow = scoreboard.registerNewObjective("healthBelow", "dummy");
        }
        else {
            scoreboard.getObjective("healthBelow").unregister();
            ScoreboardLife.healthBelow = scoreboard.registerNewObjective("healthBelow", "dummy");
        }
        ScoreboardLife.health.setDisplaySlot(DisplaySlot.PLAYER_LIST);
        ScoreboardLife.healthBelow.setDisplayName(ChatColor.RED + "❤");
        ScoreboardLife.healthBelow.setDisplaySlot(DisplaySlot.BELOW_NAME);
    }

    public static void setHealth(final Player player) {
        ScoreboardLife.health.getScore(player.getName()).setScore((int)(player.getHealth())+ ((int) getAbsoHearths(player)));
        ScoreboardLife.healthBelow.getScore(player.getName()).setScore((int)(player.getHealth()) + ((int) getAbsoHearths(player)));
    }

    public static double getAbsoHearths(final Player p) {
        return ((CraftPlayer)p).getHandle().getAbsorptionHearts();
    }
}
