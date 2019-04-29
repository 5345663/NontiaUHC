package fr.sithey.uhc.utils.uhcgame;

import fr.sithey.uhc.teams.Teams;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.*;

public class Games {
    public List<UUID> alive = new ArrayList<>();
    public ArrayList<UUID> disconect = new ArrayList<>();
    public List<Player> vote = new ArrayList<>();
    public ArrayList<Teams> teams = new ArrayList<>();
    public UUID host = UUID.randomUUID();
    public String prefix = "§8(§eNontiaUHC§8) §e§l|§f ";
    public String scoreboard = "§cNontiaUHC";
    public int maxplayers = 50;
    public int maxparteams = 1;
    public int bordertime = 600;
    public int borderfinal = 50;
    public boolean chatmute;
    public int applerate = 1;
    public int flintrate = 80;
    public double gapplerate = 0.00;
    public double damagepearl = 1;
    public int oui = 0;
    public int non = 0;
    public boolean horse = true;
    public HashMap<UUID, Teams> lastteams = new HashMap<>();
    public HashMap<UUID, Location> lastcoord = new HashMap<>();
    public HashMap<UUID, Inventory> lastinv = new HashMap<>();

    public boolean isChatmute() {
        return this.chatmute;
    }
    public void toggleChatmute() {
        this.chatmute = !this.chatmute;
    }
    public boolean getHorse() { return this.horse; }
    public void toggleHorse() { this.horse = !this.horse;}

    //blooddiamond
    public double blooddamage = 1.0D;
    //bowswap
    public int pourswap = 100;
    //diamondless
    public int diamondkill = 2;
    //finalheal
    public int healtime = 10 * 60;
    //netheribus
    public int nethertime = 30 * 60;
    public double overdamage = 1.0;
    public int overdtime = 20 * 6;
    //nocleanup
    public double healclean = 4.0;
    //skyhigh
    public int skyhigh = 30 * 60;
    public double skydamage = 1.0;
    public int skydtime = 20 * 6;
    //coordinate
    public int coordtime = 2 * 60;
    //diamondlimite
    public int diamondlimite = 17;
    //goldlimite
    public int goldlimite = 64;
    //bestpve
    public ArrayList<UUID> bestpve = new ArrayList<>();
    //bestpve
    public ArrayList<UUID> bestbtc = new ArrayList<>();
    //taupegun
    public int taupetime = 15 * 60;
    public ArrayList<UUID> taupe = new ArrayList<>();
    public ArrayList<UUID> kitcmd = new ArrayList<>();
}
