package fr.sithey.uhc.teams;

import org.bukkit.DyeColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public enum Teams {
    TAUPE("§4","Taupe ", 10, 0, false, DyeColor.GREEN),
    TEAM1("§c","♠ ", 10, 1, false, DyeColor.RED),
    TEAM2("§b","♠ ", 11, 1, false, DyeColor.BLUE),
    TEAM3("§a","♠ ", 12, 1, false, DyeColor.GREEN),
    TEAM4("§e","♠ ", 13, 1, false, DyeColor.YELLOW),
    TEAM5("§6","♠ ", 14, 1, false, DyeColor.ORANGE),
    TEAM6("§4","♠ ", 15, 1, false, DyeColor.RED),
    TEAM7("§3","♠ ", 16, 1, false, DyeColor.CYAN),
    TEAM8("§2","♠ ", 19, 1, false, DyeColor.GREEN),
    TEAM9("§d","♠ ", 20, 1, false, DyeColor.PURPLE),
    TEAM10("§c","♣ ", 21, 1, false, DyeColor.RED),
    TEAM11("§b","♣ ", 22, 1, false,DyeColor.BLUE),
    TEAM12("§a","♣ ", 23, 1, false,DyeColor.GREEN),
    TEAM13("§e","♣ ", 24, 1, false,DyeColor.YELLOW),
    TEAM14("§6","♣ ", 25, 1, false,DyeColor.ORANGE),
    TEAM15("§4","♣ ", 28, 1, false,DyeColor.RED),
    TEAM16("§3","♣ ", 29, 1, false,DyeColor.CYAN),
    TEAM17("§2","♣ ", 30, 1, false,DyeColor.GREEN),
    TEAM18("§d","♣ ", 31, 1, false,DyeColor.PURPLE),
    TEAM19("§c","♥ ", 32, 1, false,DyeColor.RED),
    TEAM20("§b","♥ ", 33, 1, false,DyeColor.BLUE),
    TEAM21("§a","♥ ", 34, 1, false,DyeColor.GREEN),
    TEAM22("§e","♥ ", 37, 1, false,DyeColor.YELLOW),
    TEAM23("§6","♥ ", 38, 1, false,DyeColor.ORANGE),
    TEAM24("§4","♥ ", 39, 1, false,DyeColor.RED),
    TEAM25("§3","♥ ", 40, 1, false,DyeColor.CYAN),
    TEAM26("§2","♥ ", 41, 1, false,DyeColor.GREEN),
    TEAM27("§d","♥ ", 42, 1, false,DyeColor.PURPLE),
    TEAM28("§c","♦ ", 43, 1, false,DyeColor.RED),
    TEAM29("§b","♦ ", 10, 2, false,DyeColor.BLUE),
    TEAM30("§a","♦ ", 11, 2, false,DyeColor.GREEN),
    TEAM31("§e","♦ ", 12, 2, false,DyeColor.YELLOW),
    TEAM32("§6","♦ ", 13, 2, false,DyeColor.ORANGE),
    TEAM33("§4","♦ ", 14, 2, false,DyeColor.RED),
    TEAM34("§3","♦ ", 15, 2, false,DyeColor.CYAN),
    TEAM35("§2","♦ ", 16, 2, false,DyeColor.GREEN),
    TEAM36("§d","♦ ", 19, 2, false,DyeColor.PURPLE),
    TEAM37("§c","♫ ", 20, 2, false,DyeColor.RED),
    TEAM38("§b","♫ ", 21, 2, false,DyeColor.BLUE),
    TEAM39("§a","♫ ", 22, 2, false,DyeColor.GREEN),
    TEAM40("§e","♫ ", 23, 2, false,DyeColor.YELLOW),
    TEAM41("§6","♫ ", 24, 2, false,DyeColor.ORANGE),
    TEAM42("§4","♫ ", 25, 2, false,DyeColor.RED),
    TEAM43("§3","♫ ", 28, 2, false,DyeColor.CYAN),
    TEAM44("§2","♫ ", 29, 2, false,DyeColor.GREEN),
    TEAM45("§d","♫ ", 30, 2, false,DyeColor.PURPLE),
    TEAM46("§c","❄ ", 31, 2, false,DyeColor.RED),
    TEAM47("§b","❄ ", 32, 2, false,DyeColor.BLUE),
    TEAM48("§a","❄ ", 33, 2, false,DyeColor.GREEN),
    TEAM49("§e","❄ ", 34, 2, false,DyeColor.YELLOW),
    TEAM50("§6","❄ ", 37, 2, false,DyeColor.ORANGE),
    TEAM51("§4","❄ ", 38, 2, false,DyeColor.RED),
    TEAM52("§3","❄ ", 39, 2, false,DyeColor.CYAN),
    TEAM53("§2","❄ ", 40, 2, false,DyeColor.GREEN),
    TEAM54("§d","❄ ", 41, 2, false,DyeColor.PURPLE),
    TEAM55("§c","ᐃ ", 42, 2, false,DyeColor.RED),
    TEAM56("§b","ᐃ ", 43, 2, false,DyeColor.BLUE),
    TEAM57("§a","ᐃ ", 10, 3, false,DyeColor.GREEN),
    TEAM58("§e","ᐃ ", 11, 3, false,DyeColor.YELLOW),
    TEAM59("§6","ᐃ ", 12, 3, false,DyeColor.ORANGE),
    TEAM60("§4","ᐃ ", 13, 3, false,DyeColor.RED),
    TEAM61("§3","ᐃ ", 14, 3, false,DyeColor.CYAN),
    TEAM62("§2","ᐃ ", 15, 3, false,DyeColor.GREEN),
    TEAM63("§d","ᐃ ", 16, 3, false,DyeColor.PURPLE);

    private String color;
    private String name;
    private int slots;
    private int page;
    private List<UUID> members;
    private ArrayList<UUID> alive;
    private boolean death;
    private DyeColor dyeColor;


    private Teams(String color,String name, int slots, int page, boolean death, DyeColor dyeColor){
        this.color = color;
        this.name = name;
        this.slots = slots;
        this.page = page;
        this.members = new ArrayList<>();
        this.alive = new ArrayList<>();
        this.death = death;
        this.dyeColor = dyeColor;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getSlots() { return slots; }

    public int getPage() { return page; }

    public List<UUID> getMembers() { return members; }

    public List<UUID> getAlive() { return alive; }

    public int getSize(){
        return members.size();
    }

    public static Teams getTeamWithPlayer(Player player){
        for (Teams teams : Teams.values()){
            if(teams.getMembers().contains(player.getUniqueId())){
                return teams;
            }
        }
        return null;
    }

    public boolean getDeath(){
        return death;
    }
    public void toogleDeath(){
        this.death = !this.death;
    }
    public DyeColor getDyeColor(){
        return dyeColor;
    }
}

//ᐃ⚑
//§c §b §a §e §6 §4 §3 §2 §d