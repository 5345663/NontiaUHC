package fr.sithey.uhc.gui.scenarios;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.CustomInventory;
import fr.sithey.uhc.utils.api.ItemCreator;
import fr.sithey.uhc.utils.api.Scenarios;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class Scenario2 implements CustomInventory {

    private Main main = Main.getInstance();

    @Override
    public String getName() {
        return "§cScénario 2";
    }

    @Override
    public Supplier<ItemStack[]> getContents(Player player) {
        ItemStack[] slots = new ItemStack[getSlots()];
        ItemCreator white = new ItemCreator(Material.STAINED_GLASS_PANE).setDurability(0);
        ItemCreator orange = new ItemCreator(Material.STAINED_GLASS_PANE).setDurability(1);
        ItemCreator yellow = new ItemCreator(Material.STAINED_GLASS_PANE).setDurability(4);

        slots[0] = orange.getItem();
        slots[1] = orange.getItem();
        slots[7] = orange.getItem();
        slots[8] = orange.getItem();
        slots[9] = orange.getItem();
        slots[17] = orange.getItem();
        slots[36] = orange.getItem();
        slots[44] = orange.getItem();
        slots[45] = orange.getItem();
        slots[46] = orange.getItem();
        slots[52] = orange.getItem();
        slots[53] = orange.getItem();

        slots[2] = white.getItem();
        slots[3] = white.getItem();
        slots[5] = white.getItem();
        slots[6] = white.getItem();
        slots[10] = white.getItem();
        slots[16] = white.getItem();
        slots[18] = white.getItem();
        slots[26] = white.getItem();
        slots[27] = white.getItem();
        slots[35] = white.getItem();

        slots[4] = yellow.getItem();
        slots[40] = yellow.getItem();
        slots[48] = yellow.getItem();
        slots[50] = yellow.getItem();
        Stream.of(GuiScenarioEnum.values()).filter(scenario -> scenario.getPage() == 2).forEach(scenario -> slots[scenario.getSlot()] = new ItemCreator(scenario.getMaterial()).setName("§8◆ §e" + scenario.getName() + " §8(" + (scenario.isEnabled() ? "§aon" : "§coff") + "§8)").getItem());
        slots[49] = new ItemCreator(Material.BOOK).setName("§cModes de jeux").getItem();
        slots[53] = new ItemCreator(Material.PAPER).setName("§cPage 1").getItem();

        return () -> slots;

    }

    @Override
    public void onClick(Player player, Inventory inv, ItemStack current, int slot) {

        for (GuiScenarioEnum scenario : GuiScenarioEnum.values()) {
            if (current.getItemMeta().getDisplayName() != null && current.getItemMeta().getDisplayName().startsWith("§8◆ §e" + scenario.getName()) ) {
                try {
                    Class<? extends Scenarios> scenariosClass = scenario.getScenarioClass();
                    scenariosClass.newInstance().activeScenario(player);
                    main.gui.open(player, Scenario2.class);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        switch (current.getType()) {
            default:
                break;
            case PAPER:
                main.gui.open(player, Scenario1.class);
                break;
            case BOOK:
                if (current.getItemMeta().getDisplayName().equalsIgnoreCase("§cModes de jeux"))
                main.gui.open(player, Special.class);
        }
    }

    @Override
    public int getRows () {
        return 6;
    }
}
