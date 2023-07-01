package fr.frakass.recyclingfoundry.commands;

import fr.frakass.recyclingfoundry.RecyclingFoundry;
import fr.frakass.recyclingfoundry.Utils;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {
    RecyclingFoundry plugin;

    public MainCommand(RecyclingFoundry plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (s.equalsIgnoreCase("recyclingfoundry") || s.equalsIgnoreCase("rf")) {
            if (sender.hasPermission("recyclingfoundry.admin")) {
                if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
                    sender.sendMessage(Utils.chat("&2&lRecyclingFoundry"));
                    sender.sendMessage("");
                    sender.sendMessage(Utils.chat("&2Commands:"));
                    sender.sendMessage(Utils.chat("&a/recyclingfoundry help &7- Shows this page."));
                    sender.sendMessage(Utils.chat("&a/recyclingfoundry reload &7- Reload the plugin config."));
                    sender.sendMessage("");
                    sender.sendMessage(Utils.chat("&8Version 1.2.0 by Creepercraft_67"));
                    return true;
                }
                if (args[0].equalsIgnoreCase("reload")) {
                    plugin.reloadConfig();
                    plugin.loadRecipes();
                    sender.sendMessage(ChatColor.GREEN + "Config file successfully reloaded.");
                    if (sender instanceof Player) {
                        Player p = (Player) sender;
                        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2F, 2);
                    }
                }

            } else {
                sender.sendMessage(Utils.chat(plugin.getConfig().getString("messages.no-permission")));
            }
        }
        return true;
    }

}
