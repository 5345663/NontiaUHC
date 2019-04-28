package fr.sithey.uhc.utils.world;

import java.io.File;

public class RemoveWorlds {
    public void deleteWorld(File path)
    {
        System.out.println("Deleting... world");

        if (path.exists()) {
            File[] files = path.listFiles();

            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    deleteWorld(files[i]);
                } else {
                    files[i].delete();
                }
            }
        }
    }
}
