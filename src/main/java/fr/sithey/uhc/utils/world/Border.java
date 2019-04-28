package fr.sithey.uhc.utils.world;

import org.bukkit.Bukkit;
import org.bukkit.World;

public class Border {

    public void createBorder(){
        for (World world : Bukkit.getWorlds()){
            world.getWorldBorder().setSize(1500);
            world.getWorldBorder().setCenter(0, 0);
            world.getWorldBorder().setDamageAmount(2.0);
            world.getWorldBorder().setDamageBuffer(5.0);
            world.getWorldBorder().setWarningDistance(20);
        }
    }
}
