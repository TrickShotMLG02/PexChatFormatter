package com.TrickShotDev.PexChatFormatter;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import ru.tehkode.permissions.bukkit.PermissionsEx;

@SuppressWarnings("deprecation")
public class PexChatFormatter extends JavaPlugin implements Listener{
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		PlayerChatEvent.getHandlerList().unregister((Plugin) this);
		super.onDisable();
	}

	@EventHandler
	public void onPlayerChat(PlayerChatEvent event) {
		
		String prefixString = PermissionsEx.getUser(event.getPlayer()).getPrefix();
		Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
				prefixString + event.getPlayer().getName() + ": " + event.getMessage()));
		
		event.setCancelled(true);
	}	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("pexchatformatter")) {
			if (args.length == 0)
			{
				sender.sendMessage("PexChatFormatter v1.0");
			}		
			else if (args[0].equalsIgnoreCase("reload"))
			{
				sender.sendMessage("Reloaded Plugin");
				
				//Do Reload Stuff
			}
			else
			{
				sender.sendMessage("Invalid Argument(s)");
			}
			return true;
		}
		else {
			return false;
		}
	}
}
