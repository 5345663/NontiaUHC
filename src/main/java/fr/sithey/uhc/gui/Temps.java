package fr.sithey.uhc.gui;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.CustomInventory;
import fr.sithey.uhc.utils.api.ItemCreator;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.function.Supplier;

public class Temps implements CustomInventory {
    private Main main = Main.getInstance();
    @Override
    public String getName() {
        return "§6Configuration Temps";
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

        slots[13] = new ItemCreator(Material.DIAMOND_SWORD).setName("§6PvP : §a" + main.timers.PvPTimer / 60).getItem();
        slots[12] = new ItemCreator(Material.BANNER).setPatterns(m50).setName("§6-1 §6--> §f" + (main.timers.PvPTimer / 60- 1)).getItem();
        slots[11] = new ItemCreator(Material.BANNER).setPatterns(m10).setName("§6-5 §6--> §f" + (main.timers.PvPTimer / 60- 5)).getItem();
        slots[10] = new ItemCreator(Material.BANNER).setPatterns(m5).setName("§6-10 §6--> §f" + (main.timers.PvPTimer / 60 - 10)).getItem();
        slots[14] = new ItemCreator(Material.BANNER).setPatterns(p50).setName("§6+1 §6--> §f" + (main.timers.PvPTimer / 60+ 1) ).getItem();
        slots[15] = new ItemCreator(Material.BANNER).setPatterns(p10).setName("§6+5  §6--> §f" + (main.timers.PvPTimer / 60+ 5)).getItem();
        slots[16] = new ItemCreator(Material.BANNER).setPatterns(p5).setName("§6+10 §6--> §f" + (main.timers.PvPTimer / 60+ 10)).getItem();
        slots[22] = new ItemCreator(Material.BARRIER).setName("§6Bordure  : §a" + main.timers.BorderTimer / 60).getItem();
        slots[21] = new ItemCreator(Material.BANNER).setPatterns(m50).setName("§e-1 §e--> §f" + (main.timers.BorderTimer / 60- 1)).getItem();
        slots[20] = new ItemCreator(Material.BANNER).setPatterns(m10).setName("§e-5 §e--> §f" + (main.timers.BorderTimer/ 60- 5)).getItem();
        slots[19] = new ItemCreator(Material.BANNER).setPatterns(m5).setName("§e-10 §e--> §f" + (main.timers.BorderTimer/ 60- 10)).getItem();
        slots[23] = new ItemCreator(Material.BANNER).setPatterns(p50).setName("§e+1 §e--> §f" + (main.timers.BorderTimer/ 60+ 1) ).getItem();
        slots[24] = new ItemCreator(Material.BANNER).setPatterns(p10).setName("§e+5  §e--> §f" + (main.timers.BorderTimer/ 60+ 5)).getItem();
        slots[25] = new ItemCreator(Material.BANNER).setPatterns(p5).setName("§e+10 §e--> §f" + (main.timers.BorderTimer/ 60 + 10)).getItem();
        slots [40] = new ItemCreator(Material.ARROW).setName("§cBack").getItem();

        return () -> slots;
    }

    @Override
    public void onClick(Player player, Inventory inv, ItemStack current, int slot) {
        if (player.isOp() || player.getUniqueId() == Main.getInstance().games.host) {
            if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§6-10 §6--> §f" + (main.timers.PvPTimer / 60 - 10))) {
                int i = Integer.parseInt(String.valueOf(main.timers.PvPTimer - 10 * 60));
                if (i >= 0)
                    main.timers.PvPTimer = i;
                else
                    main.timers.PvPTimer = 0;
            }
            if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§6-5 §6--> §f" + (main.timers.PvPTimer / 60 - 5))) {
                int i = Integer.parseInt(String.valueOf(main.timers.PvPTimer - 5 * 60));
                if (i >= 0)
                    main.timers.PvPTimer = i;
                else
                    main.timers.PvPTimer = 0;
            }
            if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§6-1 §6--> §f" + (main.timers.PvPTimer / 60 - 1))) {
                int i = Integer.parseInt(String.valueOf(main.timers.PvPTimer - 60));
                if (i >= 0)
                    main.timers.PvPTimer = i;
                else
                    main.timers.PvPTimer = 0;
            }
            if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§6+10 §6--> §f" + (main.timers.PvPTimer / 60 + 10))) {
                int i = Integer.parseInt(String.valueOf(main.timers.PvPTimer + 10 * 60));
                if (i >= 0)
                    main.timers.PvPTimer = i;
                else
                    main.timers.PvPTimer = 0;
            }
            if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§6+5 §6--> §f" + (main.timers.PvPTimer / 60 + 5))) {
                int i = Integer.parseInt(String.valueOf(main.timers.PvPTimer + 5 * 60));
                if (i >= 0)
                    main.timers.PvPTimer = i;
                else
                    main.timers.PvPTimer = 0;
            }
            if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§6+1 §6--> §f" + (main.timers.PvPTimer / 60 + 1))) {
                int i = Integer.parseInt(String.valueOf(main.timers.PvPTimer + 60));
                if (i >= 0)
                    main.timers.PvPTimer = i;
                else
                    main.timers.PvPTimer = 0;
            }

            if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§e-10 §e--> §f" + (main.timers.BorderTimer / 60 - 10))) {
                int i = Integer.parseInt(String.valueOf(main.timers.BorderTimer - 10 * 60));
                if (i >= 0)
                    main.timers.BorderTimer = i;
                else
                    main.timers.BorderTimer = 0;
            }
            if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§e-5 §e--> §f" + (main.timers.BorderTimer / 60 - 5))) {
                int i = Integer.parseInt(String.valueOf(main.timers.BorderTimer - 5 * 60));
                if (i >= 0)
                    main.timers.BorderTimer = i;
                else
                    main.timers.BorderTimer = 0;
            }
            if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§e-1 §e--> §f" + (main.timers.BorderTimer / 60 - 1))) {
                int i = Integer.parseInt(String.valueOf(main.timers.BorderTimer - 60));
                if (i >= 0)
                    main.timers.BorderTimer = i;
                else
                    main.timers.BorderTimer = 0;
            }
            if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§e+10 §e--> §f" + (main.timers.BorderTimer / 60 + 10))) {
                int i = Integer.parseInt(String.valueOf(main.timers.BorderTimer + 10 * 60));
                if (i >= 0)
                    main.timers.BorderTimer = i;
                else
                    main.timers.BorderTimer = 0;
            }
            if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§e+5 §e--> §f" + (main.timers.BorderTimer / 60 + 5))) {
                int i = Integer.parseInt(String.valueOf(main.timers.BorderTimer + 5 * 60));
                if (i >= 0)
                    main.timers.BorderTimer = i;
                else
                    main.timers.BorderTimer = 0;
            }
            if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§e+1 §e--> §f" + (main.timers.BorderTimer / 60 + 1))) {
                int i = Integer.parseInt(String.valueOf(main.timers.BorderTimer + 60));
                if (i >= 0)
                    main.timers.BorderTimer = i;
                else
                    main.timers.BorderTimer = 0;
            }
            main.gui.open(player, Temps.class);
        }
        switch (current.getType()) {
            default:
                break;
            case ARROW:
                main.gui.open(player, Configuration.class);
                break;


        }
    }

    @Override
    public int getRows() {
        return 5;
    }



}
