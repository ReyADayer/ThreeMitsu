package net.atlantis.threemitsu

import net.atlantis.threemitsu.listener.MoveListener
import org.bukkit.plugin.java.JavaPlugin

class ThreeMitsu : JavaPlugin() {
    override fun onEnable() {
        server.pluginManager.registerEvents(MoveListener(this), this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}