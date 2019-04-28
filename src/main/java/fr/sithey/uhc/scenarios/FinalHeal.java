package fr.sithey.uhc.scenarios;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.Scenarios;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.entity.Player;

public class FinalHeal extends Scenarios {





    public void configure() {
        scenario = GuiScenarioEnum.FINALHEAL;
    }


    public void activate(Player player) {
        player.sendMessage("§6 - /specialsc finalheal <" + Main.getInstance().games.healtime / 60 + ">(minutes)");
    }

    public void execute() {
    }

}
