package dev.jaqobb.realisticbookshelves.command;

import dev.jaqobb.realisticbookshelves.RealisticBookshelvesPlugin;
import dev.jaqobb.realisticbookshelves.bookshelf.Bookshelf;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SetPagesCommand implements CommandExecutor {

	private RealisticBookshelvesPlugin plugin;

	public SetPagesCommand(RealisticBookshelvesPlugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments) {
		if (!(sender instanceof Player)) {
			this.plugin.getMessages().getChatMessage("not-player")
				.color()
				.target(sender)
				.send();
			return true;
		}
		Player player = (Player) sender;
		if (!player.hasPermission("realisticbookshelves.command.setpages")) {
			this.plugin.getMessages().getChatMessage("no-permissions")
				.color()
				.target(player)
				.send();
			return true;
		}
		Block block = player.getTargetBlockExact(5);
		if (block.getType() != Material.BOOKSHELF) {
			this.plugin.getMessages().getChatMessage("not-looking-at-bookshelf")
				.color()
				.target(player)
				.send();
			return true;
		}
		if (arguments.length != 1) {
			this.plugin.getMessages().getChatMessage("set-pages-usage")
				.color()
				.target(player)
				.send();
			return true;
		}
		int pages;
		try {
			pages = Integer.parseInt(arguments[0]);
		} catch (NumberFormatException exception) {
			this.plugin.getMessages().getChatMessage("could-not-parse-argument-to-integer")
				.color()
				.transform(message -> message.replace("{argument}", arguments[0]))
				.target(player)
				.send();
			return true;
		}
		if (pages < 1 || pages > 100) {
			this.plugin.getMessages().getChatMessage("wrong-pages-amount")
				.color()
				.target(player)
				.send();
			return true;
		}
		Bookshelf bookshelf = this.plugin.getBookshelfRepository().get(block.getLocation());
		if (bookshelf == null) {
			bookshelf = new Bookshelf(block.getLocation(), this.plugin.getConfiguration().getInt("default.rows"), pages, new ItemStack[0]);
		} else {
			// TODO: Check if by changing pages, current items can still fit in.
			bookshelf.setPages(pages);
		}
		return true;
	}
}
