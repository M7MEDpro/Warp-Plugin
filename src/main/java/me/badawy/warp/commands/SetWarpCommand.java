package me.badawy.warp.commands;

import dev.velix.imperat.BukkitSource;
import dev.velix.imperat.annotations.Command;
import dev.velix.imperat.annotations.Named;
import dev.velix.imperat.annotations.Usage;
import me.badawy.warp.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.io.IOException;


@Command({"setwarp","sw"})
public class SetWarpCommand {
@Usage
public void usage(CommandSender sender) {
 sender.sendMessage(ChatColor.AQUA + "Usage: /setwarp <warpname>");
}

@Usage
public void setwarp(BukkitSource sender, @Named("warpname") String warpname) {

    try {
        Main.ymapi.save(sender.asPlayer().getUniqueId(),sender.asPlayer().getLocation(),warpname);
        sender.asPlayer().sendMessage(ChatColor.AQUA + "Set warp " + warpname + " successfully");
    } catch (IOException e) {
        sender.asPlayer().sendMessage(ChatColor.RED + "Could not save warp");
    }
}
}
