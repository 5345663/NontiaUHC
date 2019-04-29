package fr.sithey.uhc.scenarios.special;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.CustomInventory;
import fr.sithey.uhc.utils.api.ItemCreator;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.text.SimpleDateFormat;
import java.util.function.Supplier;

public class TaupeGunGUI implements CustomInventory {
    @Override
    public String getName() {
        return "Configuration du TaupeGun";
    }

    @Override
    public Supplier<ItemStack[]> getContents(Player player) {
        ItemStack[] slots = new ItemStack[getSlots()];
        slots[0] = new ItemCreator(Material.REDSTONE).setName("-5").getItem();
        slots[1] = new ItemCreator(Material.REDSTONE).setName("-1").getItem();
        slots[2] = new ItemCreator(Material.PAPER).setName(new SimpleDateFormat("mm:ss").format(Main.getInstance().games.taupetime * 1000)).getItem();
        slots[3] = new ItemCreator(Material.SLIME_BALL).setName("+1").getItem();
        slots[4] = new ItemCreator(Material.SLIME_BALL).setName("+5").getItem();
        slots[6] = new ItemCreator(Material.ANVIL).setName(Main.getInstance().games.supertaupe ? "On" : "Off").getItem();
            return () -> slots;
    }

    @Override
    public void onClick(Player player, Inventory inventory, ItemStack current, int slot) {
        switch (current.getType()) {
            case REDSTONE:
            if (slot == 0)
                Main.getInstance().games.taupetime = Main.getInstance().games.taupetime - 60 * 5;
            if (slot == 1)
                Main.getInstance().games.taupetime = Main.getInstance().games.taupetime - 60;
            Main.getInstance().gui.open(player, TaupeGunGUI.class);
            break;

            case SLIME_BALL:
                if (slot == 3)
                    Main.getInstance().games.taupetime = Main.getInstance().games.taupetime + 60 ;
                if (slot == 4)
                    Main.getInstance().games.taupetime = Main.getInstance().games.taupetime + 60 * 5;
                Main.getInstance().gui.open(player, TaupeGunGUI.class);
                break;

            case ANVIL:
                Main.getInstance().games.supertaupe = !Main.getInstance().games.supertaupe;
                Main.getInstance().gui.open(player, TaupeGunGUI.class);
                break;
            default:
                break;

        }
    }

    @Override
    public int getRows() {
        return 3;
    }
}
