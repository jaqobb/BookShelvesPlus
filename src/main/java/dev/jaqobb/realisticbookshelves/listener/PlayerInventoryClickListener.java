package dev.jaqobb.realisticbookshelves.listener;

import dev.jaqobb.realisticbookshelves.RealisticBookshelvesPlugin;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

public class PlayerInventoryClickListener implements Listener {

	private RealisticBookshelvesPlugin plugin;

	public PlayerInventoryClickListener(RealisticBookshelvesPlugin plugin) {
		this.plugin = plugin;
	}

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onPlayerInventoryClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		Inventory inventory = event.getInventory();
		InventoryView inventoryView = event.getView();
		if (this.plugin.getCurrentPages().containsKey(player.getUniqueId())) {
			int slot = event.getRawSlot();
			if (slot < 0 || slot > 53) {
				return;
			}
			if (slot == 49) {
				event.setCancelled(true);
				player.closeInventory();
				return;
			}
			ItemStack item = inventory.getItem(slot);
			if (item == null || item.getType() == Material.AIR) {
				return;
			}
			if (slot == 46 && item.isSimilar(this.plugin.getPreviousPageItem())) {
				event.setCancelled(true);
				this.plugin.openBookshelf(player, this.plugin.getCurrentBookshelves().get(player.getUniqueId()), this.plugin.getCurrentPages().get(player.getUniqueId()) - 1, false);
			} else if (slot == 52 && item.isSimilar(this.plugin.getNextPageItem())) {
				event.setCancelled(true);
				this.plugin.openBookshelf(player, this.plugin.getCurrentBookshelves().get(player.getUniqueId()), this.plugin.getCurrentPages().get(player.getUniqueId()) + 1, false);
			}
		}
	}
}