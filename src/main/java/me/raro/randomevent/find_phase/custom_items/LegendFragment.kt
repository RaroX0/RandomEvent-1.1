package me.raro.randomevent.find_phase.custom_items

import me.raro.randomevent.Main
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType

val FIRE_KEY = NamespacedKey(Main.instance, "FireFragment")
val VELOCITY_KEY = NamespacedKey(Main.instance, "VelocityFragment")
val STONE_KEY = NamespacedKey(Main.instance, "StoneFragment")

fun ItemStack.isFireFragment() : Boolean {
    return this.type == Material.DIAMOND && this.itemMeta?.persistentDataContainer?.has(FIRE_KEY) == true
}

fun ItemStack.isVelocityFragment() : Boolean {
    return this.type == Material.DIAMOND && this.itemMeta?.persistentDataContainer?.has(VELOCITY_KEY) == true
}

fun ItemStack.isStoneFragment() : Boolean {
    return this.type == Material.DIAMOND && this.itemMeta?.persistentDataContainer?.has(STONE_KEY) == true
}

fun ItemStack.setFireFragment() {
    this.itemMeta?.persistentDataContainer?.set(FIRE_KEY, PersistentDataType.BYTE, 1)
}

fun ItemStack.setVelocityFragment() {
    this.itemMeta?.persistentDataContainer?.set(VELOCITY_KEY, PersistentDataType.BYTE, 1)
}

fun ItemStack.setStoneFragment() {
    this.itemMeta?.persistentDataContainer?.set(STONE_KEY, PersistentDataType.BYTE, 1)
}