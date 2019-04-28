package fr.sithey.uhc.scenarios;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.Scenarios;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class NetheriBus extends Scenarios implements Listener {

    private Main main = Main.getInstance();


    public NetheriBus(){

    }


    public void configure() {
        scenario = GuiScenarioEnum.NETHERIBUS;
    }


    public void activate(Player player) {
                org.bukkit.Bukkit.getServer().getPluginManager().registerEvents(this, Main.getInstance());
        player.sendMessage( "§6 - /specialsc netheribus <" + main.games.nethertime / 60 + ">(minutes) <" + main.games.overdamage + ">  <" + main.games.overdtime / 20 + ">");

    }

    public void execute() {
    }


}


