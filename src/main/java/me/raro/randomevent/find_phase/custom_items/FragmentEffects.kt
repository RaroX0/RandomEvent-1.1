package me.raro.randomevent.find_phase.custom_items

import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

enum class FragmentEffects {
    FireFragment {
        private val FIRE_BUFFS = arrayListOf<PotionEffectType>(
            PotionEffectType.FIRE_RESISTANCE,
            PotionEffectType.INCREASE_DAMAGE,
            PotionEffectType.REGENERATION
        )

        fun addBuffs(player: Player) {
            FIRE_BUFFS.forEach {
                if (it == PotionEffectType.INCREASE_DAMAGE) {
                    PotionEffect(it, Int.MAX_VALUE, 3)
                } else player.addPotionEffect(PotionEffect(it, Int.MAX_VALUE, 1))
            }
        }

        fun removeBuffs(player: Player) {
            FIRE_BUFFS.forEach {
                player.removePotionEffect(it)
            }
        }
    },

    VelocityFragment {
        private val VELOCITY_BUFFS = arrayListOf<PotionEffectType>(
            PotionEffectType.SPEED,
            PotionEffectType.REGENERATION,
            PotionEffectType.FAST_DIGGING
        )

        fun addBuffs(player: Player) {
            VELOCITY_BUFFS.forEach {
                if (it == PotionEffectType.SPEED) {
                    PotionEffect(it, Int.MAX_VALUE, 3)
                } else player.addPotionEffect(PotionEffect(it, Int.MAX_VALUE, 1))
            }
        }

        fun removeBuffs(player: Player) {
            VELOCITY_BUFFS.forEach {
                player.removePotionEffect(it)
            }
        }
    },

    StoneFragment {
        private val STONE_BUFFS = arrayListOf<PotionEffectType>(
            PotionEffectType.DAMAGE_RESISTANCE,
            PotionEffectType.HEALTH_BOOST,
            PotionEffectType.INCREASE_DAMAGE
        )

        fun addBuffs(player: Player) {
            STONE_BUFFS.forEach {
                if (it == PotionEffectType.DAMAGE_RESISTANCE) {
                    PotionEffect(it, Int.MAX_VALUE, 3)
                } else player.addPotionEffect(PotionEffect(it, Int.MAX_VALUE, 1))
            }
        }

        fun removeBuffs(player: Player) {
            STONE_BUFFS.forEach {
                player.removePotionEffect(it)
            }
        }
    }
}