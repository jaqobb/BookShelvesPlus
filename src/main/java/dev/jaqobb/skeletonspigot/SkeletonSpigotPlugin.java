package dev.jaqobb.skeletonspigot;

import dev.jaqobb.skeletonspigot.configuration.Configuration;
import dev.jaqobb.skeletonspigot.configuration.message.Messages;
import org.bukkit.plugin.java.JavaPlugin;

public class SkeletonSpigotPlugin extends JavaPlugin {

	private Configuration configuration;
	private Messages messages;

	@Override
	public void onEnable() {
		this.configuration = new Configuration(this, 1);
		this.messages = new Messages(this, 1);
	}

	public Configuration getConfiguration() {
		return this.configuration;
	}

	public Messages getMessages() {
		return this.messages;
	}
}
