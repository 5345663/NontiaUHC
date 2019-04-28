package fr.sithey.uhc.gui.scenarios;

import fr.sithey.uhc.utils.api.CustomInventory;
import fr.sithey.uhc.utils.api.ItemCreator;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.function.Supplier;

public class Scenarios implements CustomInventory {

    @Override
    public String getName() {
        return "Scenarios";
    }

    @Override
    public Supplier<ItemStack[]> getContents(Player player) {
        ItemStack[] slots = new ItemStack[getSlots()];

        int size = -1;
        for (GuiScenarioEnum scenarios : GuiScenarioEnum.values()){
            if (scenarios.isEnabled()) {
                size++;
                slots[size] = new ItemCreator(scenarios.getMaterial()).setName("§7● §a"+scenarios.getName()).getItem();
            }
        }
        return () -> slots;
    }

    @Override
    public void onClick(Player player, Inventory inventory, ItemStack current, int slot) {
        for (GuiScenarioEnum scenarios : GuiScenarioEnum.values())
        if (current.getItemMeta().getDisplayName().equals("§7● §a"+scenarios.getName()))
            player.sendMessage("§7● §a" + scenarios.getName() +" §8: §c" + scenarios.getDesc());
        switch (current.getType()) {
            default:
                break;
        }
    }

    @Override
    public int getRows() {
        return 6;
    }
}
