package fr.sithey.uhc.utils.api;

import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.entity.Player;

public abstract class Scenarios {

    protected GuiScenarioEnum scenario;

    public Scenarios() {
    }

    public void activeScenario(Player player) {
        configure();
        this.scenario.toggleEnabled();

        if (this.scenario.isEnabled())
            activate(player);
        else
            disable(player);
    }

    public void executeScenario() {
        configure();

        if (this.scenario.isEnabled())
            execute();
    }

    public abstract void configure();

    public abstract void activate(Player player);

    public abstract void execute();

    public void disable(Player player) {
        configure();
    }
}
