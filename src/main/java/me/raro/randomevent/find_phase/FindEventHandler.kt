package me.raro.randomevent.find_phase

import me.raro.randomevent.Main
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerAttemptPickupItemEvent

class FindEventHandler(plugin: Main) : Listener {
    fun handleFragmentPickUp(event: PlayerAttemptPickupItemEvent) {
        val PLAYER = event.player
        val ITEM = event.item.itemStack
    }
}