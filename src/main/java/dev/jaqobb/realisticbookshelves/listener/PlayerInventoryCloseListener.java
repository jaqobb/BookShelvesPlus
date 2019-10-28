package dev.jaqobb.realisticbookshelves.listener;

import dev.jaqobb.realisticbookshelves.RealisticBookshelvesPlugin;
import java.util.UUID;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class PlayerInventoryCloseListener implements Listener {

	private RealisticBookshelvesPlugin plugin;

	public PlayerInventoryCloseListener(RealisticBookshelvesPlugin plugin) {
		this.plugin = plugin;
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerInventoryClose(InventoryCloseEvent event) {
		UUID uniqueId = event.getPlayer().getUniqueId();
		this.plugin.getCurrentPages().remove(uniqueId);
		this.plugin.getCurrentBookshelves().remove(uniqueId);
	}
}