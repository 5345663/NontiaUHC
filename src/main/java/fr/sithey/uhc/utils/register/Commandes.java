package fr.sithey.uhc.utils.register;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.cmd.HCMD;
import fr.sithey.uhc.cmd.PlayerCMD;
import fr.sithey.uhc.cmd.SetCMD;
import fr.sithey.uhc.cmd.SpecialSCCMD;
import fr.sithey.uhc.gui.Configuration;
import fr.sithey.uhc.scenarios.special.TaupeGun;

public class Commandes {
    private Main main = Main.getInstance();
    public void registerCommands() {
        main.getCommand("saveinv").setExecutor(new Configuration());
        main.getCommand("savedeath").setExecutor(new Configuration());
        main.getCommand("whitelist").setExecutor(new SetCMD());
        main.getCommand("sethost").setExecutor(new SetCMD());
        main.getCommand("specialsc").setExecutor(new SpecialSCCMD());
        main.getCommand("htp").setExecutor(new HCMD());
        main.getCommand("hkick").setExecutor(new HCMD());
        main.getCommand("hsay").setExecutor(new HCMD());
        main.getCommand("hgamemode").setExecutor(new HCMD());
        main.getCommand("hstop").setExecutor(new HCMD());
        main.getCommand("hmaxplayers").setExecutor(new HCMD());
        main.getCommand("hchat").setExecutor(new HCMD());
        main.getCommand("hwhitelist").setExecutor(new HCMD());
        main.getCommand("hscoreboard").setExecutor(new HCMD());
        main.getCommand("hvote").setExecutor(new HCMD());
        main.getCommand("hforce").setExecutor(new HCMD());
        main.getCommand("hrez").setExecutor(new HCMD());
        main.getCommand("oui").setExecutor(new PlayerCMD());
        main.getCommand("non").setExecutor(new PlayerCMD());
        main.getCommand("helpop").setExecutor(new PlayerCMD());
        main.getCommand("scenario").setExecutor(new PlayerCMD());
        main.getCommand("rules").setExecutor(new PlayerCMD());

        main.getCommand("taupe").setExecutor(new TaupeGun());
        main.getCommand("kit").setExecutor(new TaupeGun());
        main.getCommand("reveal").setExecutor(new TaupeGun());

    }
}
