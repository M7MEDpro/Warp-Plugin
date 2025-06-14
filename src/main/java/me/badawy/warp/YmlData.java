package me.badawy.warp;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
public class YmlData {
    private final File warpFile;
    private final FileConfiguration warpConfig;

    public YmlData() {
        warpFile = new File(Main.getPlugin().getDataFolder(), "warp.yml");
        warpConfig = YamlConfiguration.loadConfiguration(warpFile);
    }

    public void save(UUID playerUUID, Location location, String warpname) throws IOException {
        Bukkit.getScheduler().runTaskAsynchronously(Main.getPlugin(), () -> {
            String path = "warps." + playerUUID + "." + warpname;
            warpConfig.set(path + ".world", location.getWorld().getName());
            warpConfig.set(path + ".x", location.getX());
            warpConfig.set(path + ".y", location.getY());
            warpConfig.set(path + ".z", location.getZ());
            try {
                warpConfig.save(warpFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }

    public Location getLocation(UUID playerUUID, String warpname) {
        String path = "warps." + playerUUID + "." + warpname;
        String world = warpConfig.getString(path + ".world");
        double x = warpConfig.getDouble(path + ".x");
        double y = warpConfig.getDouble(path + ".y");
        double z = warpConfig.getDouble(path + ".z");
        return new Location(Bukkit.getWorld(world), x, y, z);
    }

    public List<String> getWarps(UUID playerUUID) {
        String path = "warps." + playerUUID;
        if (!warpConfig.isConfigurationSection(path)) return new ArrayList<>();
        return new ArrayList<>(warpConfig.getConfigurationSection(path).getKeys(false));
    }

    public void deleteWarp(UUID playerUUID, String warpname) throws IOException {
        String path = "warps." + playerUUID + "." + warpname;
        warpConfig.set(path, null);
        warpConfig.save(warpFile);
    }
}
