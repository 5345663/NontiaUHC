package fr.sithey.uhc.cmd;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.api.ItemCreator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player))
            return true;
        Player player = (Player) sender;
        if (player.isOp()) {
            if (cmd.getName().equalsIgnoreCase("whitelist")|| Main.getInstance().games.host == player.getUniqueId()){
                if (args.length == 1){
                    if (args[0].equalsIgnoreCase("on"))
                        Bukkit.getServer().setWhitelist(true);
                    if (args[0].equalsIgnoreCase("off"))
                        Bukkit.getServer().setWhitelist(false);
                }else{
                    player.sendMessage("/whitelist on/off");
                }
            }
        }

        if (Bukkit.getPlayer(Main.getInstance().games.host) == player || player.isOp()){
        if (cmd.getName().equalsIgnoreCase("sethost")){
            if (args.length == 1){

                    Player cible = Bukkit.getPlayer(args[0]);
                    Main.getInstance().games.host = cible.getUniqueId();
                    Bukkit.getPlayer(Main.getInstance().games.host).sendMessage(
                            "§8§m----------------------------------------------------\n"+
                                    "\n"+
                                    "§cBienvenue a vous en tant que Host, voici quelle que commande utile pour votre host: \n" +
                                    "\n"+
                                    "/specialsc - Commande special pour des scenarios speciaux .\n"+
                                    "/htp - Se teleporter a un joueur .\n"+
                                    "/hrez - Refait vivre un joueur mort .\n"+
                                    "/hsay - Faire une annonce dans votre serveur.\n"+
                                    "/hgamemode - Changer de gamemode .\n"+
                                    "/hstop - Stop le serveur .\n"+
                                    "/hchat - Activer ou desactiver le chat .\n"+
                                    "/hvote - Faire un vote .\n"+
                                    "/hforce - Force le PvP ou la Bordure .\n"+
                                    "/hscoreboard - Change le titre du scoreboard .\n"+
                                    "/hmaxplayers - Mettre un nombre maximum de joueur .\n"+
                                    "/sethost - Donner le host .\n"+
                                    "/whitelist on/off - Activer ou desactiver la whitelist .\n\n"+
                                    "§8§m----------------------------------------------------\n");
                    Bukkit.getPlayer(Main.getInstance().games.host).getInventory().setItem(0, new ItemCreator(Material.REDSTONE_COMPARATOR).setName("§cConfig de la partie").getItem());
                    Bukkit.getPlayer(Main.getInstance().games.host).getInventory().setItem(1, new ItemCreator(Material.ANVIL).setName("§cScénario").getItem());
                    if (!player.isOp()){
                        player.getInventory().setItem(0, new ItemCreator(Material.AIR).getItem());
                        player.getInventory().setItem(1, new ItemCreator(Material.AIR).getItem());
                    }
                }
            }
        }
        return false;
    }
}
