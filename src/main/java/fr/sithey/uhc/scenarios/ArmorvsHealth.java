package fr.sithey.uhc.scenarios;


import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.Scenarios;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.inventory.CraftItemEvent;

public class ArmorvsHealth extends Scenarios implements Listener {

    public ArmorvsHealth() {
    }

    @org.bukkit.event.EventHandler
    public void GodApple(CraftItemEvent event) {
        if (GuiScenarioEnum.ARMORVSHEALTH.isEnabled()) {
            Player p = (Player) event.getView().getPlayer();

            org.bukkit.Material itemType = event.getInventory().getResult().getType();
            if (itemType == null) {
                return;
            }
            switch (itemType) {
                case PACKED_ICE:
                    damage(p, 1.0D);
                    break;
                case PAINTING:
                    damage(p, 3.0D);
                    break;
                case PAPER:
                    damage(p, 2.0D);
                    break;
                case PISTON_BASE:
                    damage(p, 1.0D);
                    break;
                case PRISMARINE_CRYSTALS:
                    damage(p, 2.0D);
                    break;
                case PRISMARINE_SHARD:
                    damage(p, 5.0D);
                    break;
                case PUMPKIN:
                    damage(p, 3.0D);
                    break;
                case PUMPKIN_PIE:
                    damage(p, 1.0D);
                    break;
                case PORK:
                    damage(p, 2.0D);
                    break;
                case PORTAL:
                    damage(p, 3.0D);
                    break;
                case POTATO:
                    damage(p, 5.0D);
                    break;
                case POTATO_ITEM:
                    damage(p, 2.0D);
                    break;
                case POTION:
                    damage(p, 3.0D);
                    break;
                case POWERED_MINECART:
                    damage(p, 8.0D);
                    break;
                case POWERED_RAIL:
                    damage(p, 6.0D);
                    break;
                case PRISMARINE:
                    damage(p, 3.0D);
                    break;
            }

        }
    }


    private void damage(Player player, double amount) {
        EntityDamageEvent event = new EntityDamageEvent(player, DamageCause.CUSTOM, amount);
        Bukkit.getPluginManager().callEvent(event);
        player.damage(event.getDamage());
    }

    public void configure() {
        scenario = GuiScenarioEnum.ARMORVSHEALTH;
    }


    public void activate(Player player) {
        Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
    }

    public void execute() {
    }
}
