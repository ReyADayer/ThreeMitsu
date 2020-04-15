package net.atlantis.threemitsu.listener

import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.entity.LivingEntity
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.plugin.java.JavaPlugin

class MoveListener(private val plugin: JavaPlugin) : Listener {
    @EventHandler
    fun onMove(event: PlayerMoveEvent) {
        val player = event.player
        val livingEntities = player.getNearbyEntities(2.0, 2.0, 2.0)
                .filterIsInstance<LivingEntity>()
        if (livingEntities.isNotEmpty()) {
            player.damage(1000.0)
            return
        }

        val airs = getBlocks(player.location, 4).filter {
            it.type == Material.AIR
        }
        if (airs.size < 12) {
            player.damage(1000.0)
            return
        }
    }

    private fun getBlocks(location: Location, range: Int): List<Block> {
        val world = location.world ?: return emptyList()
        val x = location.x.toInt()
        val y = location.z.toInt()
        val z = location.z.toInt()
        val result = mutableListOf<Block>()
        for (i in (x - range)..(x + range)) {
            for (j in (y - range)..(y + range)) {
                for (k in (z - range)..(z + range)) {
                    val block = world.getBlockAt(i, j, k)
                    result.add(block)
                }
            }
        }
        return result
    }
}