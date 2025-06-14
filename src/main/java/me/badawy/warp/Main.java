package me.badawy.warp;

import dev.velix.imperat.BukkitImperat;
import me.badawy.warp.commands.AllWarpCommand;
import me.badawy.warp.commands.DeleteWarpCommand;
import me.badawy.warp.commands.SetWarpCommand;
import me.badawy.warp.commands.WarpCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public static YmlData ymapi;
    private static Main plugin;
    private BukkitImperat imperat;

    @Override
    public void onEnable() {
        plugin = this;
        imperat = BukkitImperat.builder(this)
                .dependencyResolver(Main.class, () -> Main.this)
                .build();


        imperat.registerCommand(new SetWarpCommand());
        imperat.registerCommand(new WarpCommand());
        imperat.registerCommand(new DeleteWarpCommand());
        imperat.registerCommand(new AllWarpCommand());

        ymapi = new YmlData();


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static Main getPlugin() {
        return plugin;
    }
}
