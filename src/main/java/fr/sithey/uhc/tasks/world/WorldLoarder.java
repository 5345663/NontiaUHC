package fr.sithey.uhc.tasks.world;

import fr.sithey.uhc.Main;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;

public class WorldLoarder implements Runnable
{
    private World world;
    private int width;
    private int depth;
    private int x;
    private int z;
    private int loaded;
    private int area;
    private long sprint;
    private Thread thread;
    private int offset;
    private boolean pause;

    public WorldLoarder(final World world, final int width, final int depth) {
        this(world, width, depth, 0);
    }

    public WorldLoarder(final World world, final int width, final int depth, final int offset) {
        this.pause = false;
        this.world = world;
        this.width = width;
        this.depth = depth;
        this.x = -this.width;
        this.z = -this.depth;
        this.loaded = 0;
        this.sprint = System.currentTimeMillis();
        this.area = (this.width >> 4) * 2 * ((this.depth >> 4) * 2);
        this.offset = offset;
    }

    @Override
    public void run() {
        (this.thread = new Thread()).start();
        try {
            this.thread.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this.thread) {
            this.sprint = System.currentTimeMillis();
            this.setPause(false);
            while (this.z < this.depth) {
                this.x = -this.width;
                while (this.x < this.width) {
                    if (System.currentTimeMillis() - this.sprint > 8000L) {
                        this.setPause(true);
                    }
                    if (this.isPause()) {
                        return;
                    }
                    final Chunk chunk = this.world.getChunkAt(this.offset + this.x >> 4, this.z >> 4);
                        chunk.load(true);
                    ++this.loaded;
                    if (this.loaded % 100 == 0) {
                        Bukkit.broadcastMessage(this.loaded + "/" + this.area + " chunks | Memoire(s) restante(s) : " + Runtime.getRuntime().freeMemory() / 1024L + " MB");
                    }
                    if (this.loaded % 5000 == 0) {
                        try {
                            this.world.save();
                            Chunk[] chunks;
                            for (int j = (chunks = this.world.getLoadedChunks()).length, i = 0; i < j; ++i) {
                                final Chunk c = chunks[i];
                                c.load();
                            }
                        }
                        catch (Exception ignored) {}
                    }
                    this.x += 16;
                }
                this.z += 16;
            }
        }
        if (loaded >= area){
            Main.getInstance().isPregen = false;
            setPause(true);
        }
    }

    public boolean isPause() {
        return this.pause;
    }

    public void setPause(final boolean pause) {
        this.pause = pause;
    }
}
