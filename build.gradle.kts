import net.mcparkour.migle.attributes.ApiVersion

plugins {
	`java-library`
	id("net.mcparkour.migle.migle-bukkit") version "1.1.0"
}

group = "dev.jaqobb"
version = "1.0.0"
description = "Minecraft plugin that makes bookshelves more realistic"

java {
	sourceCompatibility = JavaVersion.VERSION_1_8
	targetCompatibility = JavaVersion.VERSION_1_8
}

defaultTasks("clean", "build")

migleBukkit {
	var newName = ""
	for (newNamePart in project.name.split("-")) {
		var first = true
		for (newNamePartCharacter in newNamePart.toCharArray()) {
			if (first) {
				first = false
				newName += newNamePartCharacter.toUpperCase()
			} else {
				newName += newNamePartCharacter.toLowerCase()
			}
		}
	}
	name = newName
	main = "${project.group}.${project.name.toLowerCase().replace("-", "")}.${newName}Plugin"
	version = project.version as String
	apiVersion = ApiVersion.VERSION_1_14
	description = project.description
	author = "jaqobb"
	website = "https://jaqobb.dev"
	commands = mapOf()
}

repositories {
	jcenter()
	maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/") {
		content {
			includeGroup("org.spigotmc")
		}
	}
	maven("https://oss.sonatype.org/content/repositories/snapshots/") {
		content {
			includeGroup("net.md-5")
		}
	}
}

dependencies {
	compileOnly("org.spigotmc:spigot-api:1.14.4-R0.1-SNAPSHOT")
}
