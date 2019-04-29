package fr.sithey.uhc.cmd;

import fr.sithey.uhc.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpecialSCCMD implements CommandExecutor {
    private Main main = Main.getInstance();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player))
            return true;
        Player player = (Player) sender;

        if (player.isOp() || Main.getInstance().games.host == player.getUniqueId()) {
            if (args.length == 0)
                player.sendMessage("§cConfiguration des scenarios :" +
                        "\n§6 - /specialsc taupe <" + Main.getInstance().games.taupetime / 60 + ">(minutes) <" + Main.getInstance().games.supertaupe +"> (supertaupes ? true:false)"+
                        "\n§6 - /specialsc diamondless <" + main.games.diamondkill + ">" +
                        "\n§6 - /specialsc skyhigh <" + main.games.skyhigh / 60 + ">(minutes) <" + main.games.skydamage + ">  <" + main.games.skydtime / 20 + ">" +
                        "\n§6 - /specialsc nocleanup <" + main.games.healclean + ">" +
                        "\n§6 - /specialsc blooddiamond <" + main.games.blooddamage + ">" +
                        "\n§6 - /specialsc bowswap <" + main.games.pourswap + ">%" +
                        "\n§6 - /specialsc finalheal <" + main.games.healtime / 60 + ">(minutes)" +
                        "\n§6 - /specialsc diamondlimite <" + main.games.diamondlimite + ">" +
                        "\n§6 - /specialsc goldlimite <" + main.games.goldlimite + ">" +
                        "\n§6 - /specialsc netheribus <" + main.games.nethertime / 60 + ">(minutes) <" + main.games.overdamage + ">  <" + main.games.overdtime / 20 + ">");

            if (args.length == 2) {
                if (args[0].equalsIgnoreCase("diamondless")) {
                    int i = Integer.parseInt(args[1]);
                    main.games.diamondkill = i;
                    player.sendMessage(main.games.prefix + "§8Votre demande viens d'etre enregistrer ! §e--> §f" + i);
                }
                if (args[0].equalsIgnoreCase("nocleanup")) {
                    double i = Double.parseDouble(args[1]);
                    main.games.healclean = i;
                    player.sendMessage(main.games.prefix + "§8Votre demande viens d'etre enregistrer ! §e--> §f" + i);
                }
                if (args[0].equalsIgnoreCase("blooddiamond")) {
                    double i = Double.parseDouble(args[1]);
                    main.games.blooddamage = i;
                    player.sendMessage(main.games.prefix + "§8Votre demande viens d'etre enregistrer ! §e--> §f" + i);
                }
                if (args[0].equalsIgnoreCase("bowswap")) {
                    int i = Integer.parseInt(args[1]);
                    main.games.pourswap = i;
                    player.sendMessage(main.games.prefix + "§8Votre demande viens d'etre enregistrer ! §e--> §f" + i);
                }
                if (args[0].equalsIgnoreCase("finalheal")) {
                    int i = Integer.parseInt(args[1]);
                    main.games.healtime = i * 60;
                    player.sendMessage(main.games.prefix + "§8Votre demande viens d'etre enregistrer ! §e--> §f" + i);
                }
                if (args[0].equalsIgnoreCase("diamondlimite")) {
                    int i = Integer.parseInt(args[1]);
                    main.games.diamondlimite = i;
                    player.sendMessage(main.games.prefix + "§8Votre demande viens d'etre enregistrer ! §e--> §f" + i);
                }
                if (args[0].equalsIgnoreCase("goldlimite")) {
                    int i = Integer.parseInt(args[1]);
                    main.games.goldlimite = i;
                    player.sendMessage(main.games.prefix + "§8Votre demande viens d'etre enregistrer ! §e--> §f" + i);
                }
            }

            if (args.length == 3){
                if (args[0].equalsIgnoreCase("taupe")){
                    int i = Integer.parseInt(args[1]) * 60;
                    boolean a = Boolean.parseBoolean(args[2]);
                    main.games.taupetime = i;
                    main.games.supertaupe = a;
                    player.sendMessage(main.games.prefix + "§8Votre demande viens d'etre enregistrer ! §e--> §f" + i / 60 + " et " + a);
                }
            }

            if (args.length == 4) {
                if (args[0].equalsIgnoreCase("skyhigh")) {
                    int a = Integer.parseInt(args[1]);
                    double b = Double.parseDouble(args[2]);
                    int c = Integer.parseInt(args[3]);
                    main.games.skyhigh = a * 60;
                    main.games.skydamage = b;
                    main.games.skydtime = c * 20;
                    player.sendMessage(main.games.prefix + "§8Votre demande viens d'etre enregistrer ! §e--> §f\nTemps : " + main.games.skyhigh / 60 + "\nDegat : " + main.games.skydamage + "\nTemps entre degat : " + main.games.skydtime / 20);
                }
                if (args[0].equalsIgnoreCase("netheribus")) {
                    int a = Integer.parseInt(args[1]);
                    double b = Double.parseDouble(args[2]);
                    int c = Integer.parseInt(args[3]);
                    main.games.nethertime = a * 60;
                    main.games.overdamage = b;
                    main.games.overdtime = c * 20;
                    player.sendMessage(main.games.prefix + "§8Votre demande viens d'etre enregistrer ! §e--> §f\nTemps : " + main.games.nethertime / 60 + "\nDegat : " + main.games.overdamage + "\nTemps entre degat : " + main.games.overdtime / 20);
                }
            }
        }
        return false;
    }
}
