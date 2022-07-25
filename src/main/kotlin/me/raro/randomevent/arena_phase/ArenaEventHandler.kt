package me.raro.randomevent.arena_phase

import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent

class ArenaEventHandler : Listener {
    /*
    Handling Player BlockBreaking.
     */
    @EventHandler
    fun handlePlayerBlockBreak(event: BlockBreakEvent) {
        val player = event.player
        if (player.isOp) return
        event.isCancelled = true
        player.sendMessage(MiniMessage.miniMessage().deserialize("<red>Game_Master: <gray>You can't do that here."))
    }
    //---------------------------------------------------
}