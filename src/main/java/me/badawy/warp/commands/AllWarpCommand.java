package me.badawy.warp.commands;

import dev.velix.imperat.annotations.Command;
import dev.velix.imperat.annotations.Usage;
import me.badawy.warp.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

@Command("warps")
public class AllWarpCommand {
    @Usage
    public void usage(CommandSender sender) {
        if (sender instanceof Player) {
            UUID uuid = ((Player) sender).getUniqueId();
            List<String> warpsList = Main.ymapi.getWarps(uuid);
            sender.sendMessage(ChatColor.AQUA + "Warps:");
            for (String warp : warpsList) {
                sender.sendMessage(ChatColor.AQUA + warp);
            }
        } else {
            sender.sendMessage("Error: Only players can use this command");
        }
    }
}
