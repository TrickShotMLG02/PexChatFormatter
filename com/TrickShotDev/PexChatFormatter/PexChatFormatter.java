package com.TrickShotDev.PexChatFormatter;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.text.StrSubstitutor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import ru.tehkode.permissions.PermissionGroup;
import ru.tehkode.permissions.bukkit.PermissionsEx;

@SuppressWarnings("deprecation")
public class PexChatFormatter extends JavaPlugin implements Listener {

	FileConfiguration config = this.getConfig();

	String prefixString = "";
	String suffixString = "";
	String messageString = "";

	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);
		createConfig();
		super.onEnable();
	}

	@Override
	public void onDisable() {
		PlayerChatEvent.getHandlerList().unregister((Plugin) this);
		super.onDisable();
	}

	@EventHandler
	public void onPlayerChat(PlayerChatEvent event) {

		String prefixString = "";
		String suffixString = "";
		String messageString = "";

		int currentRank = Integer.MAX_VALUE;
		PermissionGroup[] playerGroups = PermissionsEx.getUser(event.getPlayer()).getGroups();

		for (int i = 0; i < playerGroups.length; i++) {
			if (playerGroups[i].getRank() < currentRank) {
				currentRank = playerGroups[i].getRank();
				prefixString = playerGroups[i].getPrefix();
				suffixString = playerGroups[i].getSuffix();
			}
		}

		Map<String, String> data = new HashMap<String, String>();

		if (config.getBoolean("ShowPrefix")) {
			data.put("Prefix", prefixString);
		} else {
			data.put("Prefix", "");
		}

		if (config.getBoolean("ShowSuffix")) {
			data.put("Suffix", suffixString);
		} else {
			data.put("Suffix", "");
		}

		data.put("Playername", event.getPlayer().getName());
		data.put("Divider", config.getString("ChatDivider"));
		data.put("Message", event.getMessage());
		messageString = StrSubstitutor.replace(config.getString("ChatFormat"), data);

		messageString = removeSpaces(messageString);

		Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', messageString));

		event.setCancelled(true);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("pexchatformatter")) {
			if (args.length == 0) {
				sender.sendMessage("PexChatFormatter v1.1");
			} else if (args[0].equalsIgnoreCase("reload")) {
				reloadConfig();
				sender.sendMessage("Successfully Reloaded Plugin");
			} else {
				sender.sendMessage("Invalid Argument(s)");
			}
			return true;
		} else {
			return false;
		}
	}

	public void createConfig() {
		config.addDefault("ShowPrefix", true);
		config.addDefault("ShowSuffix", true);
		config.addDefault("ChatFormat", "${Prefix} ${Playername} ${Suffix} ${Divider} ${Message}");
		config.addDefault("ChatDivider", ":");

		config.options().copyDefaults(true);
		saveConfig();
	}

	@Override
	public void reloadConfig() {
		super.reloadConfig();
		File file = new File(this.getDataFolder().getAbsolutePath() + "/config.yml");
		config = YamlConfiguration.loadConfiguration(file);
	}

	public String removeSpaces(String returnString) {
		returnString = returnString.trim().replaceAll("^ +| +$|( )+", " ");
		return returnString;
	}
}
