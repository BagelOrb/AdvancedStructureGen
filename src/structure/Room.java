package structure;

import org.bukkit.block.Block;

public class Room {
	public int width, height, depth;
	public Block corner;
	public Room(Block cornerBlock, int w, int h, int d) { width = w; height = h; depth = d; corner = cornerBlock; }
	public Room(int w, int h, int d) { width = w; height = h; depth = d; }

}
