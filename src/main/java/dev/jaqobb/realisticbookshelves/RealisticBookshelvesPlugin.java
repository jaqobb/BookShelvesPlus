package dev.jaqobb.realisticbookshelves;

import dev.jaqobb.realisticbookshelves.bookshelf.BookshelfRepository;
import dev.jaqobb.realisticbookshelves.command.SetPagesCommand;
import dev.jaqobb.realisticbookshelves.command.SetRowsCommand;
import dev.jaqobb.realisticbookshelves.configuration.Configuration;
import dev.jaqobb.realisticbookshelves.configuration.bookshelf.Bookshelves;
import dev.jaqobb.realisticbookshelves.configuration.message.Messages;
import org.bukkit.plugin.java.JavaPlugin;

public class RealisticBookshelvesPlugin extends JavaPlugin {

	private Configuration configuration;
	private Messages messages;
	private Bookshelves bookshelves;
	private BookshelfRepository bookshelfRepository;

	@Override
	public void onEnable() {
		this.configuration = new Configuration(this, 1);
		this.messages = new Messages(this, 1);
		this.bookshelves = new Bookshelves(this);
		this.bookshelfRepository = new BookshelfRepository(this);
		this.getCommand("setrows").setExecutor(new SetRowsCommand(this));
		this.getCommand("setpages").setExecutor(new SetPagesCommand(this));
	}

	public Configuration getConfiguration() {
		return this.configuration;
	}

	public Messages getMessages() {
		return this.messages;
	}

	public Bookshelves getBookshelves() {
		return this.bookshelves;
	}

	public BookshelfRepository getBookshelfRepository() {
		return this.bookshelfRepository;
	}
}
