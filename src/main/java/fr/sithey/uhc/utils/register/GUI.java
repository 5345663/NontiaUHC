package fr.sithey.uhc.utils.register;

import fr.sithey.uhc.gui.*;
import fr.sithey.uhc.gui.scenarios.Scenario1;
import fr.sithey.uhc.gui.scenarios.Scenario2;
import fr.sithey.uhc.gui.scenarios.Scenarios;
import fr.sithey.uhc.gui.teams.TC1;
import fr.sithey.uhc.gui.teams.TC2;
import fr.sithey.uhc.gui.teams.TC3;
import fr.sithey.uhc.scenarios.special.TaupeGunGUI;
import fr.sithey.uhc.utils.api.CustomInventory;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;

public class GUI {

	public Map<Class<? extends CustomInventory>, CustomInventory> registeredMenus = new HashMap<>();

	private void addMenu(CustomInventory m) {
		this.registeredMenus.put(m.getClass(), m);
	}


	public void open(Player player, Class<? extends CustomInventory> gClass) {

		if (!this.registeredMenus.containsKey(gClass))
			return;

		CustomInventory menu = this.registeredMenus.get(gClass);
		Inventory inv = Bukkit.createInventory(null, menu.getSlots(), menu.getName());
		inv.setContents(menu.getContents(player).get());
		player.openInventory(inv);

	}

	public void registersGUI() {
		addMenu(new TC1());
		addMenu(new TC2());
		addMenu(new TC3());
		addMenu(new Configuration());
		addMenu(new Minage());
		addMenu(new Special());
		addMenu(new Bordure());
		addMenu(new Temps());
		addMenu(new Monde());
		addMenu(new Potion());
		addMenu(new Scenario1());
		addMenu(new Scenario2());
		addMenu(new Scenarios());
		addMenu(new fr.sithey.uhc.gui.scenarios.Special());
		addMenu(new Team());
		addMenu(new TaupeGunGUI());

		}
}
