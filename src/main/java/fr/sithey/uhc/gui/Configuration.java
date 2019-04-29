package fr.sithey.uhc.gui;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.scenarios.special.TaupeGunGUI;
import fr.sithey.uhc.tasks.Start;
import fr.sithey.uhc.utils.api.CustomInventory;
import fr.sithey.uhc.utils.api.DeathInventoryAPI;
import fr.sithey.uhc.utils.api.InventoryAPI;
import fr.sithey.uhc.utils.api.ItemCreator;
import fr.sithey.uhc.utils.uhcgame.Status;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

public class Configuration implements CustomInventory, Listener, CommandExecutor {
    @Override
    public String getName() {
        return "§6Configuration Principal";
    }

    @Override
    public Supplier<ItemStack[]> getContents(Player player) {
        ItemStack[] slots = new ItemStack[getSlots()];
        for (int i = 0; i <= 26; i++)
            slots [i] = new ItemCreator(Material.STAINED_GLASS_PANE).setDurability(0).setName("§8").getItem();
        slots[1] = new ItemCreator(Material.DIAMOND_PICKAXE).setName("§6Types de minages").getItem();
        slots[3] = new ItemCreator(Material.SKULL_ITEM).setName("§6Special").getItem();
        slots[5] = new ItemCreator(Material.NETHERRACK).setName("§6Nether "+ (NetherE.NETHER.isEnabled() ? "§a✔" : "§4✖")).getItem();
        slots[7] = new ItemCreator(Material.POTION).setName("§6Potions").getItem();
        slots[9] = new ItemCreator(Material.ENDER_CHEST).setName("§6Items de morts").getItem();
        slots[11] = new ItemCreator(Material.GRASS).setName("§6Configuration du monde").getItem();
        slots[13] = new ItemCreator(Material.COMPASS).setName("§6Temps").getItem();
        slots[15] = new ItemCreator(Material.IRON_BARDING).setName("§6Bordure").getItem();
        slots[17] = new ItemCreator(Material.CHEST).setName("§6Items de démarrage").getItem();
        slots[19] = new ItemCreator(Material.BANNER).setName("§6Teams").setDurability(0).getItem();
        slots[21] = new ItemCreator(Material.SLIME_BALL).setName("§6Démarrage").getItem();
        slots[23] = new ItemCreator(Material.WOOL).setName("§6Commandes").setDurability(5).getItem();
        slots[25] = new ItemCreator(Material.NAME_TAG).setName((!Bukkit.getServer().hasWhitelist() ? "§a" : "§c") + "Whitelist").getItem();
        slots[26] = new ItemCreator(Material.TNT).setName("§6Configuration TaupeGun").getItem();

        return () -> slots;
    }

    @Override
    public void onClick(Player player, Inventory inv, ItemStack current, int slot) {
        switch (current.getType()) {
            default:
                break;
            case SLIME_BALL:
                if (player.isOp() || player.getUniqueId() == Main.getInstance().games.host) {
                    if (!(Main.getInstance().isStatus(Status.ATTENTE))) {
                        player.sendMessage("§cImpossible");
                    } else {
                        Start start = new Start();
                        start.runTaskTimer(Main.getInstance(), 0, 20);
                        Main.getInstance().setStatus(Status.TP);
                        ArrayList<Player> random = new ArrayList<>();
                        if (Team.TeamsE.RANDOM.isEnabled())
                            for (UUID players : Main.getInstance().games.alive)
                                random.add(Bukkit.getPlayer(players));
                        Collections.shuffle(random);
                        for (Player randoms : random)
                            Main.getInstance().teamsManager.randomTeam(randoms);

                    }
                }
                break;
            case DIAMOND_PICKAXE:
                Main.getInstance().gui.open(player, Minage.class);
                break;
            case SKULL_ITEM:
                Main.getInstance().gui.open(player, Special.class);
                break;
            case NETHERRACK:
                if (player.isOp() ||  player.getUniqueId() == Main.getInstance().games.host) {
                    NetherE.NETHER.toggleEnabled();
                    Main.getInstance().gui.open(player, Configuration.class);
                }
                break;
            case IRON_BARDING:
                Main.getInstance().gui.open(player, Bordure.class);
                break;
            case COMPASS:
                Main.getInstance().gui.open(player, Temps.class);
                break;
            case GRASS:
                Main.getInstance().gui.open(player, Monde.class);
                break;
            case BANNER:
                Main.getInstance().gui.open(player, Team.class);
                break;
            case POTION:
                Main.getInstance().gui.open(player, Potion.class);
                break;
            case NAME_TAG:
                if (player.isOp() || player.getUniqueId() == Main.getInstance().games.host) {
                    if (Bukkit.getServer().hasWhitelist()) {
                        Bukkit.getServer().setWhitelist(false);
                        player.sendMessage(Main.getInstance().games.prefix + "La whitelist est maintenant off");
                    } else {
                        Bukkit.getServer().setWhitelist(true);
                        player.sendMessage(Main.getInstance().games.prefix + "La whitelist est maintenant on");
                    }
                    Main.getInstance().gui.open(player, Configuration.class);
                }
                break;
            case WOOL:
                if (player.isOp() || player.getUniqueId() == Main.getInstance().games.host) {
                    player.sendMessage(
                            "§8§m----------------------------------------------------\n" +
                                    "\n" +
                                    "§cCommandes: \n" +
                                    "\n" +
                                    "/specialsc - Commande spéciale pour des scénarios spéciaux.\n" +
                                    "/htp - Se téléporter à un joueur.\n" +
                                    "/hrez - Refait vivre un joueur mort .\n"+
                                    "/hsay - Faire une annonce dans votre serveur.\n" +
                                    "/hgamemode - Changer de gamemode.\n" +
                                    "/hstop - Stop le serveur.\n" +
                                    "/hchat - Activer ou désactiver le chat.\n" +
                                    "/hvote - Faire un vote.\n" +
                                    "/hforce - Force le PvP ou la Bordure .\n" +
                                    "/hscoreboard - Change le titre du scoreboard .\n" +
                                    "/hmaxplayers - Mettre un nombre maximum de joueur .\n" +
                                    "/sethost - Donner l'host .\n" +
                                    "/whitelist on/off - Activer ou désactiver la whitelist .\n\n" +
                                    "§8§m----------------------------------------------------\n");
                }
                break;
            case CHEST:
                InventoryAPI inventaire = new InventoryAPI(player, null);
                if (player.isOp() || player.getUniqueId() == Main.getInstance().games.host) {
                    if (Main.getInstance().isLobby()) {
                        player.getInventory().clear();
                        player.getInventory().setLeggings(null);
                        player.getInventory().setBoots(null);
                        player.getInventory().setChestplate(null);
                        player.getInventory().setHelmet(null);
                        inventaire.giveInvent();
                        player.closeInventory();

                        player.sendMessage("§bUtilise §6§l§o/saveinv§b pour sauvegardé l'inventaire !");
                        player.setGameMode(GameMode.CREATIVE);
                    }
                }else{
                    inventaire.giveforInv(player);
                }
                break;
            case ENDER_CHEST:
                DeathInventoryAPI inventairedeath = new DeathInventoryAPI(player, null);
                if (player.isOp() || player.getUniqueId() == Main.getInstance().games.host){
                    if (Main.getInstance().isLobby()) {
                        player.getInventory().clear();
                        player.getInventory().setLeggings(null);
                        player.getInventory().setBoots(null);
                        player.getInventory().setChestplate(null);
                        player.getInventory().setHelmet(null);
                        inventairedeath.giveInvent();
                        player.closeInventory();

                        player.sendMessage("§bUtilise §6§l§o/savedeath§b pour sauvegardé l'inventaire !");
                        player.setGameMode(GameMode.CREATIVE);
                    }
                }else{
                    inventairedeath.giveforInv(player);
                }
                break;

            case TNT:
                Main.getInstance().gui.open(player, TaupeGunGUI.class);
                break;
        }
    }

    @Override
    public int getRows() {
        return 3;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player))
            return true;
        Player player = (Player) sender;
        InventoryAPI inventaire = new InventoryAPI(player, null);
        DeathInventoryAPI inventairedeath = new DeathInventoryAPI(player, null);
        if (player.isOp() || player.getUniqueId() == Main.getInstance().games.host) {
            if (cmd.getName().equalsIgnoreCase("saveinv")){
                inventaire.saveInventory();
                player.sendMessage("§4§nInventaire sauvegardé");
                player.setGameMode(GameMode.ADVENTURE);
                Main.getInstance().getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                    @Override
                    public void run() {
                        if (player.isOp()|| player.getUniqueId() == Main.getInstance().games.host){
                            player.getInventory().setItem(0, new ItemCreator(Material.REDSTONE_COMPARATOR).setName("§cConfig de la partie").getItem());
                            player.getInventory().setItem(1, new ItemCreator(Material.ANVIL).setName("§cScenarios").getItem());
                        }
                    }
                }, 1);
                if (Main.getInstance().games.maxparteams > 1)
                player.getInventory().setItem(4, new ItemCreator(Material.BANNER).setName("§6Menu des Team").getItem());
                player.getInventory().setItem(8, new ItemCreator(Material.BED).setName("§4Retour au lobby").getItem());
            }
            if (cmd.getName().equalsIgnoreCase("savedeath")){
                inventairedeath.saveInventory();
                player.sendMessage("§4§nInventaire sauvegardé");
                player.setGameMode(GameMode.ADVENTURE);
                Main.getInstance().getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                    @Override
                    public void run() {
                        if (player.isOp()|| player.getUniqueId() == Main.getInstance().games.host){
                            player.getInventory().setItem(0, new ItemCreator(Material.REDSTONE_COMPARATOR).setName("§cConfig de la partie").getItem());
                            player.getInventory().setItem(1, new ItemCreator(Material.ANVIL).setName("§cScenarios").getItem());
                        }
                    }
                }, 1);
                if (Main.getInstance().games.maxparteams > 1)
                player.getInventory().setItem(4, new ItemCreator(Material.BANNER).setName("§6Menu des Team").getItem());
            }
        }
        return false;
    }

    public enum NetherE{
        NETHER(true);
        private boolean enabled;
        NetherE(boolean enabled){
            this.enabled = enabled;
        }
        public boolean isEnabled() {
            return this.enabled;
        }
        public void toggleEnabled() { this.enabled = !this.enabled; }
    }

    @EventHandler
    public void goNether(PlayerPortalEvent event){
        if (!NetherE.NETHER.isEnabled())
            event.setCancelled(true);
    }

}
