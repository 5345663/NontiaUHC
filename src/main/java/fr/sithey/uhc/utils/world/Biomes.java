package fr.sithey.uhc.utils.world;

import net.minecraft.server.v1_8_R3.BiomeBase;

public class Biomes {

    public void removeBiomes(){
        try {
            java.lang.reflect.Field biomesField = BiomeBase.class.getDeclaredField("biomes");
            biomesField.setAccessible(true);
            if ((biomesField.get(null) instanceof BiomeBase[])) {
                BiomeBase[] biomes = (BiomeBase[]) biomesField.get(null);
                biomes[BiomeBase.DEEP_OCEAN.id] = BiomeBase.PLAINS;
                biomes[BiomeBase.FROZEN_OCEAN.id] = BiomeBase.FOREST;
                biomes[BiomeBase.OCEAN.id] = BiomeBase.FOREST;
                biomes[BiomeBase.JUNGLE.id] = BiomeBase.FOREST;
                biomes[BiomeBase.JUNGLE_EDGE.id] = BiomeBase.FOREST;
                biomes[BiomeBase.JUNGLE_HILLS.id] = BiomeBase.DESERT;
                biomes[BiomeBase.MEGA_TAIGA.id] = BiomeBase.BIRCH_FOREST;
                biomes[BiomeBase.MEGA_TAIGA_HILLS.id] = BiomeBase.BEACH;
                biomes[BiomeBase.MESA.id] = BiomeBase.SAVANNA;
                biomes[BiomeBase.MESA_PLATEAU.id] = BiomeBase.SAVANNA_PLATEAU;
                biomes[BiomeBase.MESA_PLATEAU_F.id] = BiomeBase.BIRCH_FOREST_HILLS;
                biomes[BiomeBase.ICE_PLAINS.id] = BiomeBase.PLAINS;
                biomes[BiomeBase.ICE_MOUNTAINS.id] = BiomeBase.ROOFED_FOREST;
                biomes[BiomeBase.ICE_MOUNTAINS.id] = BiomeBase.ROOFED_FOREST;
                biomesField.set(null, biomes);
            }
        } catch (Exception localException) {
        }
    }
}
