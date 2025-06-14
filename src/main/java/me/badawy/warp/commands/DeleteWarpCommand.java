package me.badawy.warp.commands;

import dev.velix.imperat.BukkitSource;
import dev.velix.imperat.annotations.Command;
import dev.velix.imperat.annotations.Named;
import dev.velix.imperat.annotations.Usage;
import me.badawy.warp.Main;
import org.bukkit.ChatColor;

import java.io.IOException;

@Command("delwarp")
public class DeleteWarpCommand {
    @Usage
    public void usage(BukkitSource source){
        source.reply("/delwarp <warp>");
    }

    @Usage
    public void setwarp(BukkitSource sender, @Named("warpname") String warpname) {

        try {
          Main.ymapi.deleteWarp(sender.asPlayer().getUniqueId(), warpname);
          sender.asPlayer().sendMessage(ChatColor.AQUA + "Warp deleted!");
        } catch (IOException e) {
            sender.asPlayer().sendMessage(ChatColor.RED + "Could not delete warp");
        }
    }
}
