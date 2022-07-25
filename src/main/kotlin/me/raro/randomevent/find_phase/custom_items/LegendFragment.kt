package me.raro.randomevent.find_phase.custom_items

import me.raro.randomevent.Main
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType

enum class LegendFragment(private val itemType: Material, private val key: NamespacedKey, private val value: Byte) {
    FireFragment(Material.DIAMOND ,NamespacedKey(Main.instance, "FireFragment"), 1),
    VelocityFragment(Material.EMERALD ,NamespacedKey(Main.instance, "VelocityFragment"), 1),
    StoneFragment(Material.NETHERITE_INGOT ,NamespacedKey(Main.instance, "StoneFragment"), 1);

    fun isIt(item : ItemStack) : Boolean {
        return item.type == itemType && item.itemMeta?.persistentDataContainer?.has(key) == true
    }

    fun setIt(item : ItemStack) {
        item.itemMeta?.persistentDataContainer?.set(key, PersistentDataType.BYTE, value)
        item.addEnchantment(Enchantment.MENDING, 1)
    }
}