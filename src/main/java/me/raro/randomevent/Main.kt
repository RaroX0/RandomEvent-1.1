package me.raro.randomevent

import me.raro.randomevent.arena_phase.ArenaEventHandler
import me.raro.randomevent.find_phase.FindEventHandler
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {

    companion object {
        lateinit var instance: Main
    }

    override fun onEnable() {
        // Plugin startup logic
        instance = this
        server.pluginManager.registerEvents(ArenaEventHandler(this), this)
        server.pluginManager.registerEvents(FindEventHandler(this), this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}