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

public class Special implements CustomInventory {

    private Main main = Main.getInstance();

    @Override
    public String getName() {
        return "§cModes de jeux";
    }

    @Override
    public Supplier<ItemStack[]> getContents(Player player) {
        ItemStack[] slots = new ItemStack[getSlots()];

        Stream.of(GuiScenarioEnum.values()).filter(scenario -> scenario.getPage() == 3).forEach(scenario -> slots[scenario.getSlot()] = new ItemCreator(scenario.getMaterial()).setName("§8◆ §e" + scenario.getName() + " §8(" + (scenario.isEnabled() ? "§aon" : "§coff") + "§8)").getItem());

        slots[8] = new ItemCreator(Material.ARROW).setName("§cPage 1").getItem();
        return () -> slots;

    }

    @Override
    public void onClick(Player player, Inventory inv, ItemStack current, int slot) {

        for (GuiScenarioEnum scenario : GuiScenarioEnum.values()) {
            if (current.getItemMeta().getDisplayName() != null && current.getItemMeta().getDisplayName().startsWith("§8◆ §e" + scenario.getName()) ) {
                try {
                    Class<? extends Scenarios> scenariosClass = scenario.getScenarioClass();
                    scenariosClass.newInstance().activeScenario(player);
                    main.gui.open(player, Special.class);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        switch (current.getType()) {
            default:
                break;
            case ARROW:
                main.gui.open(player, Scenario1.class);
                break;
        }
    }

    @Override
    public int getRows () {
        return 1;
    }
}
