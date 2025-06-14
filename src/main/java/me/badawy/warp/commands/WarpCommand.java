package me.badawy.warp.commands;

import dev.velix.imperat.BukkitSource;
import dev.velix.imperat.annotations.Command;
import dev.velix.imperat.annotations.Named;
import dev.velix.imperat.annotations.Usage;
import me.badawy.warp.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;

@Command("warp")
public class WarpCommand {

    @Usage
    public void usage(CommandSender sender) {
        sender.sendMessage(ChatColor.AQUA + "Usage: /warp <warp name>");
    }

    @Usage
    public void warp(BukkitSource sender, @Named("warpname") String name) {
        try {
            Location location = Main.ymapi.getLocation(sender.asPlayer().getUniqueId(), name);
            sender.asPlayer().teleport(location);
            sender.reply("Teleported to warp " + name);
        } catch (Exception e) {
                sender.reply(ChatColor.RED + "Could not find warp " + name);

        }
    }


}
