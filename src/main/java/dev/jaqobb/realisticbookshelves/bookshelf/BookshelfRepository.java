package dev.jaqobb.realisticbookshelves.bookshelf;

import dev.jaqobb.realisticbookshelves.RealisticBookshelvesPlugin;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.Location;

public class BookshelfRepository {

	private RealisticBookshelvesPlugin plugin;
	private Map<Location, Bookshelf> bookshelves = new HashMap<>(100, 0.85F);

	public BookshelfRepository(RealisticBookshelvesPlugin plugin) {
		this.plugin = plugin;
	}
}
