# 🌀 Warp Plugin (Spigot/Bukkit)

A lightweight and personal warp system for Minecraft servers. This plugin lets players easily **set**, **teleport to**, and **delete** their own warp points.

---

## 🌟 Features

- 🧭 Set warp points with `/setwarp`
- 🚀 Teleport to saved warps using `/warp`
- 🗑️ Delete warps with `/delwarp`
- 📜 View all your warp names with `/warps`
- 🔒 Each player's warps are saved using their **UUID**
- 💾 Warps stored in `warps.yml` and auto-loaded on startup
- ⚙️ Built using `ImprateCommand` framework for modular design

---

## 🧪 Commands & Usage

| Command           | Description                             | Example                       |
|-------------------|-----------------------------------------|-------------------------------|
| `/setwarp <name>` | Saves a new warp at your current location | `/setwarp home`              |
| `/warp <name>`    | Teleports you to the saved warp location | `/warp home`                 |
| `/delwarp <name>` | Deletes a previously set warp            | `/delwarp mine`              |
| `/warps`          | Lists all your warp names                | `/warps`                     |

---

## 💾 Warp Data Format

Warp points are saved in `warps.yml` under your Minecraft **UUID**.

### ✅ Example (`warps.yml`)

```yaml
warps:
  27df3769-66a0-4c8c-b491-91731ecb8454:
    home:
      world: world
      x: -2023.585317444769
      y: 73.0
      z: -958.0016334939007
    mine:
      world: world_nether
      x: 150.0
      y: 64.0
      z: -42.5
