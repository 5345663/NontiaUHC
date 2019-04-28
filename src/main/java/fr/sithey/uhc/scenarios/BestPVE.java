package fr.sithey.uhc.scenarios;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.Scenarios;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class BestPVE extends Scenarios implements Listener {
    private Main main = Main.getInstance();

    @EventHandler
    public void onDamage(EntityDamageEvent event){
        if (GuiScenarioEnum.BESTPVE.isEnabled()) {
            if (!(event.getEntity() instanceof Player)) return;
            Player player = (Player) event.getEntity();
            if (main.games.bestpve.contains(player.getUniqueId())) {
                player.sendMessage(main.games.prefix + "Tu es retiré de la 'meilleure liste PvE'");
                main.games.bestpve.remove(event.getEntity().getUniqueId());
            }
        }
    }

    @EventHandler
    public void onKill(PlayerDeathEvent event) {
        String message = event.getDeathMessage();
        if (GuiScenarioEnum.BESTPVE.isEnabled()) {
            if (message.contains("burned") || message.contains("drowned") || message.contains("lava") || message.contains("ground") || message.contains("fall") || message.contains("fell")
                    || message.contains("Zombie") || message.contains("Blaze") || message.contains("Creeper") || message.contains("Enderman") || message.contains("Skeleton")
                    || message.contains("Spider") || message.contains("Silverfish") || message.contains("Witch") || message.contains("suffocated") || message.contains("died"))
                return;
            if (!main.games.bestpve.contains(event.getEntity().getKiller().getUniqueId())) {
                event.getEntity().sendMessage(main.games.prefix + "Tu es de nouveau ajouté dans la 'meilleure liste PvE'");
                main.games.bestpve.add(event.getEntity().getKiller().getUniqueId());
            }
        }
    }

    public void configure() {
        scenario = GuiScenarioEnum.BESTPVE;
    }


    public void activate(Player player) {
        org.bukkit.Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
    }

    public void execute() {
    }

}
