package me.raro.randomevent.arena_phase

import me.raro.randomevent.Main
import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.PlayerDeathEvent

class ArenaEventHandler(plugin: Main) : Listener {
    private val deadPlayer: MutableList<Player> = ArrayList()

    /*
    Handling Inventory Drops according to cause of death.
     */
    @EventHandler
    fun handlePlayerDamage(event: EntityDamageByEntityEvent) {
        if (event.entity !is Player) return
        if (event.damager !is Player) return
        val remainingHealth = (event.entity as Player).health - event.damage
        if (remainingHealth <= 0) {
            deadPlayer.add(event.entity as Player)
        }
    }

    @EventHandler
    fun handlePlayerDeath(event: PlayerDeathEvent) {
        if (deadPlayer.contains(event.entity)) {
            event.keepInventory = false
            deadPlayer.remove(event.entity)
            event.deathMessage(MiniMessage.miniMessage().deserialize("<green>${event.entity.name} <gray>was <red>ELIMINATED!!"))
        } else {
            event.keepInventory = true
            event.drops.clear()
        }
    }
    //---------------------------------------------------
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