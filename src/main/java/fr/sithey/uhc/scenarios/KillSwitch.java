package fr.sithey.uhc.scenarios;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.Scenarios;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class KillSwitch extends Scenarios implements Listener {
    private Main main = Main.getInstance();


    @EventHandler
    public void onKill(PlayerDeathEvent event) {
        String message = event.getDeathMessage();
        if (GuiScenarioEnum.KILLSWITCH.isEnabled()) {
            if (message.contains("burned") || message.contains("drowned") || message.contains("lava") || message.contains("ground") || message.contains("fall") || message.contains("fell")
                    || message.contains("Zombie") || message.contains("Blaze") || message.contains("Creeper") || message.contains("Enderman") || message.contains("Skeleton")
                    || message.contains("Spider") || message.contains("Silverfish") || message.contains("Witch") || message.contains("suffocated") || message.contains("died"))
                return;
            event.setKeepInventory(true);
            KillSwitchAPI killSwitchAPI = new KillSwitchAPI(event.getEntity(), null);
            killSwitchAPI.saveInventory();
            KillSwitchAPI killSwitchAPI2 = new KillSwitchAPI(event.getEntity().getKiller(), null);
            killSwitchAPI2.giveInvent();
        }
    }

    public void configure() {
        scenario = GuiScenarioEnum.KILLSWITCH;
    }


    public void activate(Player player) {
        org.bukkit.Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
    }

    public void execute() {
    }

}
