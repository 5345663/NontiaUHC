package fr.sithey.uhc.utils.api;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.function.Supplier;

public interface CustomInventory {

	String getName();

	Supplier<ItemStack[]> getContents(Player player);

	void onClick(Player player, Inventory inventory, ItemStack clickedItem, int slot);

	int getRows();

	default int getSlots() {
		return getRows() * 9;
	}
}
