package fr.sithey.uhc.cmd;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.gui.Configuration;
import fr.sithey.uhc.gui.scenarios.Scenarios;
import fr.sithey.uhc.utils.register.GuiScenarioEnum;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("helpop")) {
            if (args.length == 0) {
                p.sendMessage("§cuse /helpop");
            }
            String message = "";
            for (int i = 0; i < args.length; i++) {
                message = message + args[i] + " ";
            }

            for (Player staff : Bukkit.getOnlinePlayers()) {
                if (staff.isOp()) {
                    staff.sendMessage("§8(§6Helpop§8) §7- §c" + p.getName() + "§7 : §4" + message);
                }
            }
        }
        if (cmd.getName().equalsIgnoreCase("oui")){
            if (Main.getInstance().games.vote.contains(p)){
                p.sendMessage(Main.getInstance().games.prefix + "§aVote pris en compte !");
                Main.getInstance().games.vote.remove(p);
                Main.getInstance().games.oui = Main.getInstance().games.oui + 1;
            }
        }
        if (cmd.getName().equalsIgnoreCase("non")){
            if (Main.getInstance().games.vote.contains(p)){
                p.sendMessage(Main.getInstance().games.prefix + "§aVote pris en compte !");
                Main.getInstance().games.vote.remove(p);
                Main.getInstance().games.non = Main.getInstance().games.non + 1;
            }
        }
        if (cmd.getName().equalsIgnoreCase("scenario")){
            if (args.length == 1) {
                for (GuiScenarioEnum scenario : GuiScenarioEnum.values()) {
                    if (scenario.isEnabled()) {
                        p.sendMessage("§7● §a" + scenario.getName() + " §8: §c" + scenario.getDesc());
                    }
                }
            }
            if (args.length == 0)
                Main.getInstance().gui.open(p, Scenarios.class);

        }
        if (cmd.getName().equalsIgnoreCase("rules")){
            Main.getInstance().gui.open(p, Configuration.class);
        }

        if (cmd.getName().equalsIgnoreCase("topkills")){

        }


        return false;
    }
}
