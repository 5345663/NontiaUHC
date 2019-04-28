package fr.sithey.uhc.gui.teams;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.teams.Teams;
import fr.sithey.uhc.utils.api.CustomInventory;
import fr.sithey.uhc.utils.api.ItemCreator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.function.Supplier;

public class TC3 implements CustomInventory {

    private Main main = Main.getInstance();

    @Override
    public String getName() {
        return "§6Teams §8(page 3)";
    }

    @Override
    public Supplier<ItemStack[]> getContents(Player player) {
        ItemStack[] slots = new ItemStack[getSlots()];
        for (int i = 0; i <= 8; i++)
            slots [i] = new ItemCreator(Material.STAINED_GLASS_PANE).setDurability(14).setName("§8").getItem();
        for (int i = 44; i <= 53; i++)
            slots [i] = new ItemCreator(Material.STAINED_GLASS_PANE).setDurability(14).setName("§8").getItem();
        slots [9] = new ItemCreator(Material.STAINED_GLASS_PANE).setDurability(14).setName("§8").getItem();
        slots [17] = new ItemCreator(Material.STAINED_GLASS_PANE).setDurability(14).setName("§8").getItem();
        slots [18] = new ItemCreator(Material.STAINED_GLASS_PANE).setDurability(14).setName("§8").getItem();
        slots [26] = new ItemCreator(Material.STAINED_GLASS_PANE).setDurability(14).setName("§8").getItem();
        slots [27] = new ItemCreator(Material.STAINED_GLASS_PANE).setDurability(14).setName("§8").getItem();
        slots [35] = new ItemCreator(Material.STAINED_GLASS_PANE).setDurability(14).setName("§8").getItem();
        slots [36] = new ItemCreator(Material.STAINED_GLASS_PANE).setDurability(14).setName("§8").getItem();
        slots [45] = new ItemCreator(Material.STAINED_GLASS_PANE).setDurability(14).setName("§8").getItem();

        for (Teams teams : Teams.values()) {
            if (teams.getPage() == 3)
                if (teams.getAlive().size() == 0)
                    slots[teams.getSlots()] = new ItemCreator(Material.BANNER).setBasecolor(teams.getDyeColor()).setName(teams.getColor() + teams.getName())
                            .getItem();
                else if (teams.getAlive().size() == 1)
                    slots[teams.getSlots()] = new ItemCreator(Material.BANNER).setBasecolor(teams.getDyeColor()).setName(teams.getColor() + teams.getName()).setGlow(true).addLore("")
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(0)).getName())
                            .getItem();
                else if (teams.getAlive().size() == 2)
                    slots[teams.getSlots()] = new ItemCreator(Material.BANNER).setBasecolor(teams.getDyeColor()).setName(teams.getColor() + teams.getName()).setGlow(true).addLore("")
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(0)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(1)).getName())
                            .getItem();
                else if (teams.getAlive().size() == 3)
                    slots[teams.getSlots()] = new ItemCreator(Material.BANNER).setBasecolor(teams.getDyeColor()).setName(teams.getColor() + teams.getName()).setGlow(true).addLore("")
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(0)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(1)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(2)).getName())
                            .getItem();
                else if (teams.getAlive().size() == 4)
                    slots[teams.getSlots()] = new ItemCreator(Material.BANNER).setBasecolor(teams.getDyeColor()).setName(teams.getColor() + teams.getName()).setGlow(true).addLore("")
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(0)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(1)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(2)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(3)).getName())
                            .getItem();
                else if (teams.getAlive().size() == 5)
                    slots[teams.getSlots()] = new ItemCreator(Material.BANNER).setBasecolor(teams.getDyeColor()).setName(teams.getColor() + teams.getName()).setGlow(true).addLore("")
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(0)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(1)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(2)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(3)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(4)).getName())
                            .getItem();
                else if (teams.getAlive().size() == 6)
                    slots[teams.getSlots()] = new ItemCreator(Material.BANNER).setBasecolor(teams.getDyeColor()).setName(teams.getColor() + teams.getName()).setGlow(true).addLore("")
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(0)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(1)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(2)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(3)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(4)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(5)).getName())
                            .getItem();
                else if (teams.getAlive().size() == 7)
                    slots[teams.getSlots()] = new ItemCreator(Material.BANNER).setBasecolor(teams.getDyeColor()).setName(teams.getColor() + teams.getName()).setGlow(true).addLore("")
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(0)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(1)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(2)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(3)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(4)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(5)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(6)).getName())

                            .getItem();
                else if (teams.getAlive().size() == 8)
                    slots[teams.getSlots()] = new ItemCreator(Material.BANNER).setBasecolor(teams.getDyeColor()).setName(teams.getColor() + teams.getName()).setGlow(true).addLore("")
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(0)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(1)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(2)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(3)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(4)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(5)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(6)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(7)).getName())
                            .getItem();
                else if (teams.getAlive().size() == 9)
                    slots[teams.getSlots()] = new ItemCreator(Material.BANNER).setBasecolor(teams.getDyeColor()).setName(teams.getColor() + teams.getName()).setGlow(true).addLore("")
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(0)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(1)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(2)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(3)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(4)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(5)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(6)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(7)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(8)).getName())
                            .getItem();
                else  {
                    slots[teams.getSlots()] = new ItemCreator(Material.BANNER).setBasecolor(teams.getDyeColor()).setName(teams.getColor() + teams.getName()).setGlow(true).addLore("")
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(0)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(1)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(2)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(3)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(4)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(5)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(6)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(7)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(8)).getName())
                            .addLore("§6- §f" + Bukkit.getPlayer(teams.getAlive().get(9)).getName())
                            .getItem();
                }
        }
        slots [47] = new ItemCreator(Material.REDSTONE).setName("§8Page 2").getItem();
        slots [49] = new ItemCreator(Material.ARROW).setName("§cBack").getItem();

        return () -> slots;
    }

    @Override
    public void onClick(Player player, Inventory inv, ItemStack current, int slot) {
        switch (current.getType()) {
            case BANNER:
                for (Teams teams : Teams.values()) {
                    if (current.getItemMeta().getDisplayName().equals(teams.getColor()+teams.getName())) {
                        main.teamsManager.addPlayer(teams, player);
                    }
                }
                main.gui.open(player, TC3.class);
                break;
            case ARROW:
                player.closeInventory();
                break;
            case REDSTONE:
                main.gui.open(player, TC2.class);
                break;
            default:
                break;
        }
    }

    @Override
    public int getRows() {
        return 6;
    }

}