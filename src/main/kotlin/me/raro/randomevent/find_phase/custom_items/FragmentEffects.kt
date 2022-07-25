package me.raro.randomevent.find_phase.custom_items

import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

enum class FragmentEffects (private val specialEffect: PotionEffectType, private vararg val effects: PotionEffectType) {
    FireFragment(
        PotionEffectType.INCREASE_DAMAGE,
        PotionEffectType.FIRE_RESISTANCE,
        PotionEffectType.REGENERATION
    ),

    VelocityFragment(
        PotionEffectType.SPEED,
        PotionEffectType.REGENERATION,
        PotionEffectType.FAST_DIGGING
    ),

    StoneFragment(
        PotionEffectType.DAMAGE_RESISTANCE,
        PotionEffectType.HEALTH_BOOST,
        PotionEffectType.INCREASE_DAMAGE
    );

    fun addBuffs(player: Player) {
        player.addPotionEffect(PotionEffect(specialEffect, Int.MAX_VALUE, 3))
        effects.forEach { player.addPotionEffect(PotionEffect(it, Int.MAX_VALUE, 1)) }
    }

    fun removeBuffs(player: Player) {
        player.removePotionEffect(specialEffect)
        effects.forEach { player.removePotionEffect(it) }
    }
}