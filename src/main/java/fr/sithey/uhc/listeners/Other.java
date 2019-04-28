package fr.sithey.uhc.listeners;

import fr.sithey.uhc.Main;
import fr.sithey.uhc.utils.uhcgame.Status;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;

public class Other implements Listener {

    @EventHandler
    public void onPing(ServerListPingEvent event){
        if (Main.getInstance().isPregen)
            event.setMotd("Pregen ");
        if (Main.getInstance().isStatus(Status.ATTENTE) && Bukkit.getServer().hasWhitelist() && Main.getInstance().games.alive.size() == 0)
            event.setMotd("§cEn attente de host...");
        if (Main.getInstance().isStatus(Status.ATTENTE) && Bukkit.getServer().hasWhitelist() && Main.getInstance().games.alive.size() > 0)
            event.setMotd("§cWhitelist fermée");
        if (Main.getInstance().games.alive.size() > Main.getInstance().games.maxplayers)
            event.setMotd("§4Serveur full");
        if (Main.getInstance().isStatus(Status.ATTENTE) && !Bukkit.getServer().hasWhitelist())
            event.setMotd("§aWhitelist ouverte");
        if (Main.getInstance().isStatus(Status.JEU))
            event.setMotd("§6En Jeu");
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event){
        if (event.getPlayer().getGameMode().equals(GameMode.SPECTATOR))
            if (event.getPlayer().getLocation().getX() >= Bukkit.getWorld("world").getWorldBorder().getSize() / 2 || event.getPlayer().getLocation().getZ() >= Bukkit.getWorld("world").getWorldBorder().getSize() / 2 || event.getPlayer().getLocation().getX() <= - Bukkit.getWorld("world").getWorldBorder().getSize() / 2 || event.getPlayer().getLocation().getZ() <=  - Bukkit.getWorld("world").getWorldBorder().getSize() / 2 || event.getPlayer().getLocation().getY() <= 0)
                event.getPlayer().teleport(new Location(Bukkit.getWorld("world"), 0, 100, 0));
    }

    @EventHandler
    public void onWeather(WeatherChangeEvent event){
        event.setCancelled(true);
    }
    @EventHandler
    public void onCraft(PrepareItemCraftEvent event) {
        ItemStack AIR = new ItemStack(Material.AIR);
        CraftingInventory inv = event.getInventory();

        if (inv.getResult().getType() == Material.GOLDEN_APPLE) {
            if (inv.getResult().getDurability() == (short) 0x1) {
                inv.setResult(AIR);
            }
        }
    }
}