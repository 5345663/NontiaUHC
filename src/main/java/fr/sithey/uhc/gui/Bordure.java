package fr.sithey.uhc.gui;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.CustomInventory;
import fr.sithey.uhc.utils.api.ItemCreator;
import org.bukkit.*;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.function.Supplier;

public class Bordure implements CustomInventory {
    private Main main = Main.getInstance();
    @Override
    public String getName() {
        return "§6Configuration Bordure";
    }

    @Override
    public Supplier<ItemStack[]> getContents(Player player) {

        ArrayList<Pattern> m50 = new ArrayList<Pattern>();
        m50.add(new Pattern(DyeColor.RED, PatternType.BASE));
        m50.add(new Pattern(DyeColor.BLACK, PatternType.STRIPE_MIDDLE));
        m50.add(new Pattern(DyeColor.RED, PatternType.BORDER));
        ArrayList<Pattern> m10 = new ArrayList<Pattern>();
        m10.add(new Pattern(DyeColor.ORANGE, PatternType.BASE));
        m10.add(new Pattern(DyeColor.BLACK, PatternType.STRIPE_MIDDLE));
        m10.add(new Pattern(DyeColor.ORANGE, PatternType.BORDER));
        ArrayList<Pattern> m5 = new ArrayList<Pattern>();
        m5.add(new Pattern(DyeColor.YELLOW, PatternType.BASE));
        m5.add(new Pattern(DyeColor.BLACK, PatternType.STRIPE_MIDDLE));
        m5.add(new Pattern(DyeColor.YELLOW, PatternType.BORDER));
        ArrayList<Pattern> p50 = new ArrayList<Pattern>();
        p50.add(new Pattern(DyeColor.BLUE, PatternType.BASE));
        p50.add(new Pattern(DyeColor.BLACK, PatternType.STRAIGHT_CROSS));
        p50.add(new Pattern(DyeColor.BLUE, PatternType.STRIPE_TOP));
        p50.add(new Pattern(DyeColor.BLUE, PatternType.STRIPE_BOTTOM));
        ArrayList<Pattern> p10 = new ArrayList<Pattern>();
        p10.add(new Pattern(DyeColor.GREEN, PatternType.BASE));
        p10.add(new Pattern(DyeColor.BLACK, PatternType.STRAIGHT_CROSS));
        p10.add(new Pattern(DyeColor.GREEN, PatternType.STRIPE_TOP));
        p10.add(new Pattern(DyeColor.GREEN, PatternType.STRIPE_BOTTOM));
        ArrayList<Pattern> p5 = new ArrayList<Pattern>();
        p5.add(new Pattern(DyeColor.GRAY, PatternType.BASE));
        p5.add(new Pattern(DyeColor.BLACK, PatternType.STRAIGHT_CROSS));
        p5.add(new Pattern(DyeColor.GRAY, PatternType.BORDER));
        p5.add(new Pattern(DyeColor.GRAY, PatternType.STRIPE_TOP));
        p5.add(new Pattern(DyeColor.GRAY, PatternType.STRIPE_BOTTOM));
        ItemStack[] slots = new ItemStack[getSlots()];
        slots[0] = new ItemCreator(Material.STAINED_GLASS_PANE).setDurability(0).setName("§8").getItem();
        slots[8] = new ItemCreator(Material.STAINED_GLASS_PANE).setDurability(0).setName("§8").getItem();
        slots[9] = new ItemCreator(Material.STAINED_GLASS_PANE).setDurability(0).setName("§8").getItem();
        slots[17] = new ItemCreator(Material.STAINED_GLASS_PANE).setDurability(0).setName("§8").getItem();
        slots[18] = new ItemCreator(Material.STAINED_GLASS_PANE).setDurability(0).setName("§8").getItem();
        slots[26] = new ItemCreator(Material.STAINED_GLASS_PANE).setDurability(0).setName("§8").getItem();
        slots[27] = new ItemCreator(Material.STAINED_GLASS_PANE).setDurability(0).setName("§8").getItem();
        slots[35] = new ItemCreator(Material.STAINED_GLASS_PANE).setDurability(0).setName("§8").getItem();
        for (int i = 36; i <= 44; i++)
            slots [i] = new ItemCreator(Material.STAINED_GLASS_PANE).setDurability(0).setName("§8").getItem();

        slots[1] = new ItemCreator(Material.BANNER).setPatterns(m50).setName("§6-50 §6--> §f" + ((int) Bukkit.getWorld("world").getWorldBorder().getSize() / 2 - 50)).getItem();
        slots[2] = new ItemCreator(Material.BANNER).setPatterns(m10).setName("§6-10 §6--> §f" + ((int) Bukkit.getWorld("world").getWorldBorder().getSize() / 2 - 10)).getItem();
        slots[3] = new ItemCreator(Material.BANNER).setPatterns(m5).setName("§6-5 §6--> §f" + ((int) Bukkit.getWorld("world").getWorldBorder().getSize() / 2 - 5)).getItem();
        slots[5] = new ItemCreator(Material.BANNER).setPatterns(p50).setName("§6+5 §6--> §f" + ((int) Bukkit.getWorld("world").getWorldBorder().getSize() / 2 + 5)).getItem();
        slots[6] = new ItemCreator(Material.BANNER).setPatterns(p10).setName("§6+10 §6--> §f" + ((int) Bukkit.getWorld("world").getWorldBorder().getSize() / 2 + 10)).getItem();
        slots[7] = new ItemCreator(Material.BANNER).setPatterns(p5).setName("§6+50 §6--> §f" + ((int) Bukkit.getWorld("world").getWorldBorder().getSize() / 2 + 50)).getItem();
        slots[4] = new ItemCreator(Material.BARRIER).addLore(ChatColor.AQUA+ String.valueOf((int) Bukkit.getWorld("world").getWorldBorder().getSize())).setName("§6Bordure initiale : §a" + ((int) Bukkit.getWorld("world").getWorldBorder().getSize() / 2)).getItem();
        slots[10] = new ItemCreator(Material.BANNER).setPatterns(m50).setName("§e-50 §e--> §f" + (main.games.borderfinal - 50)).getItem();
        slots[11] = new ItemCreator(Material.BANNER).setPatterns(m10).setName("§e-10 §e--> §f" + (main.games.borderfinal - 10)).getItem();
        slots[12] = new ItemCreator(Material.BANNER).setPatterns(m5).setName("§e-5 §e--> §f" + (main.games.borderfinal - 5)).getItem();
        slots[14] = new ItemCreator(Material.BANNER).setPatterns(p50).setName("§e+5 §e--> §f" + (main.games.borderfinal + 5)).getItem();
        slots[15] = new ItemCreator(Material.BANNER).setPatterns(p10).setName("§e+10 §e--> §f" + (main.games.borderfinal + 10)).getItem();
        slots[16] = new ItemCreator(Material.BANNER).setPatterns(p5).setName("§e+50 §e--> §f" + (main.games.borderfinal + 50)).getItem();
        slots[13] = new ItemCreator(Material.DIRT).setName("§6Bordure finale : §a" + main.games.borderfinal).getItem();
        slots[19] = new ItemCreator(Material.BANNER).setPatterns(m50).setName("§4-5 §4--> §f" + (main.games.bordertime - 5)).getItem();
        slots[20] = new ItemCreator(Material.BANNER).setPatterns(m10).setName("§4-30 §4--> §f" + (main.games.bordertime - 30)).getItem();
        slots[21] = new ItemCreator(Material.BANNER).setPatterns(m5).setName("§4-60 §4--> §f" + (main.games.bordertime - 60)).getItem();
        slots[23] = new ItemCreator(Material.BANNER).setPatterns(p50).setName("§4+5 §4--> §f" + (main.games.bordertime + 5) ).getItem();
        slots[24] = new ItemCreator(Material.BANNER).setPatterns(p10).setName("§4+30  §4--> §f" + (main.games.bordertime + 30)).getItem();
        slots[25] = new ItemCreator(Material.BANNER).setPatterns(p5).setName("§4+60 §4--> §f" + (main.games.bordertime + 60)).getItem();
        slots[22] = new ItemCreator(Material.POTION).setName("§6Temps du shrink : §a" + main.games.bordertime / 60).getItem();
        slots [40] = new ItemCreator(Material.ARROW).setName("§cBack").getItem();



        return () -> slots;
    }

    @Override
    public void onClick(Player player, Inventory inv, ItemStack current, int slot) {
        if (player.isOp() || player.getUniqueId() == Main.getInstance().games.host) {
        World world = Bukkit.getWorld("world");
        WorldBorder wb = world.getWorldBorder();
        if (current.getItemMeta().getDisplayName().contains("§6-->") && current.getItemMeta().getDisplayName().contains("§6")) {
            if (current.getItemMeta().getDisplayName().contains(String.valueOf((((int) ((int) wb.getSize())) / 2) - 50))) {
                int i = Integer.parseInt(String.valueOf((((int) ((int) wb.getSize())) / 2) - 50));
                if (i >= 25)
                    wb.setSize(i * 2);
            }
            if (current.getItemMeta().getDisplayName().contains(String.valueOf((((int) ((int) wb.getSize())) / 2) - 10))) {
                int i = Integer.parseInt(String.valueOf((((int) ((int) wb.getSize())) / 2) - 10));
                if (i >= 25)
                    wb.setSize(i * 2);
            }
            if (current.getItemMeta().getDisplayName().contains(String.valueOf((((int) ((int) wb.getSize())) / 2) - 5))) {
                int i = Integer.parseInt(String.valueOf((((int) ((int) wb.getSize())) / 2) - 5));
                if (i >= 25)
                    wb.setSize(i * 2);
            }
            if (current.getItemMeta().getDisplayName().contains(String.valueOf((((int) ((int) wb.getSize())) / 2) + 5))) {
                int i = Integer.parseInt(String.valueOf((((int) ((int) wb.getSize())) / 2) + 5));
                if (i >= 25)
                    wb.setSize(i * 2);
            }
            if (current.getItemMeta().getDisplayName().contains(String.valueOf((((int) ((int) wb.getSize())) / 2) + 10))) {
                int i = Integer.parseInt(String.valueOf((((int) ((int) wb.getSize())) / 2) + 10));
                if (i >= 25)
                    wb.setSize(i * 2);
            }
            if (current.getItemMeta().getDisplayName().contains(String.valueOf((((int) ((int) wb.getSize())) / 2) + 50))) {
                int i = Integer.parseInt(String.valueOf((((int) ((int) wb.getSize())) / 2) + 50));
                if (i >= 25)
                    wb.setSize(i * 2);
            }
        }


        if (current.getItemMeta().getDisplayName().contains("§e-->") && current.getItemMeta().getDisplayName().contains("§e")) {
            if (current.getItemMeta().getDisplayName().contains(String.valueOf(main.games.borderfinal + 50))) {
                int i = Integer.parseInt(String.valueOf(main.games.borderfinal + 50));
                if (i >= 25)
                    main.games.borderfinal = i;
            }
            if (current.getItemMeta().getDisplayName().contains(String.valueOf(main.games.borderfinal - 50))) {
                int i = Integer.parseInt(String.valueOf(main.games.borderfinal - 50));
                if (i >= 25)
                    main.games.borderfinal = i;
            }
            if (current.getItemMeta().getDisplayName().contains(String.valueOf(main.games.borderfinal - 10))) {
                int i = Integer.parseInt(String.valueOf(main.games.borderfinal - 10));
                if (i >= 25)
                    main.games.borderfinal = i;
            }
            if (current.getItemMeta().getDisplayName().contains(String.valueOf(main.games.borderfinal - 5))) {
                int i = Integer.parseInt(String.valueOf(main.games.borderfinal - 5));
                if (i >= 25)
                    main.games.borderfinal = i;
            }
            if (current.getItemMeta().getDisplayName().contains(String.valueOf(main.games.borderfinal + 5))) {
                int i = Integer.parseInt(String.valueOf(main.games.borderfinal + 5));
                if (i >= 25)
                    main.games.borderfinal = i;
            }
            if (current.getItemMeta().getDisplayName().contains(String.valueOf(main.games.borderfinal + 10))) {
                int i = Integer.parseInt(String.valueOf(main.games.borderfinal + 10));
                if (i >= 25)
                    main.games.borderfinal = i;
            }
        }


        if (current.getItemMeta().getDisplayName().contains("§4-->") && current.getItemMeta().getDisplayName().contains("§4")) {
            if (current.getItemMeta().getDisplayName().contains(String.valueOf(main.games.bordertime + 60))) {
                int i = Integer.parseInt(String.valueOf(main.games.bordertime + 60));
                if (i >= 300)
                    main.games.bordertime = i;
            }
            if (current.getItemMeta().getDisplayName().contains(String.valueOf(main.games.bordertime - 60))) {
                int i = Integer.parseInt(String.valueOf(main.games.bordertime - 60));
                if (i >= 300)
                    main.games.bordertime = i;
            }
            if (current.getItemMeta().getDisplayName().contains(String.valueOf(main.games.bordertime - 30))) {
                int i = Integer.parseInt(String.valueOf(main.games.bordertime - 30));
                if (i >= 300)
                    main.games.bordertime = i;
            }
            if (current.getItemMeta().getDisplayName().contains(String.valueOf(main.games.bordertime - 5))) {
                int i = Integer.parseInt(String.valueOf(main.games.bordertime - 5));
                if (i >= 300)
                    main.games.bordertime = i;
            }
            if (current.getItemMeta().getDisplayName().contains(String.valueOf(main.games.bordertime + 5))) {
                int i = Integer.parseInt(String.valueOf(main.games.bordertime + 5));
                if (i >= 300)
                    main.games.bordertime = i;
            }
            if (current.getItemMeta().getDisplayName().contains(String.valueOf(main.games.bordertime + 30))) {
                int i = Integer.parseInt(String.valueOf(main.games.bordertime + 30));
                if (i >= 300)
                    main.games.bordertime = i;
            }
        }
        }
        main.gui.open(player, Bordure.class);

        switch (current.getType()) {
            case ARROW:
                main.gui.open(player, Configuration.class);
                break;
            default:
                break;
        }
    }

    @Override
    public int getRows() {
        return 5;
    }



}
