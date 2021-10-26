package gg.scala.agf.link.menu

import gg.scala.agf.link.type.AgfGameState
import gg.scala.agf.link.type.AgfGameType
import gg.scala.agf.link.updater.AgfGameInfoUpdater
import gg.scala.lemon.server.ServerInstance
import net.evilblock.cubed.menu.Button
import net.evilblock.cubed.menu.Menu
import net.evilblock.cubed.util.CC
import net.evilblock.cubed.util.bukkit.Constants
import net.evilblock.cubed.util.bukkit.Tasks
import org.bukkit.Material
import org.bukkit.entity.Player

/**
 * @author GrowlyX
 * @since 10/26/2021
 */
class AgfGameInfoDisplayMenu(
    val agfGameType: AgfGameType
) : Menu("Servers ${Constants.DOUBLE_ARROW_RIGHT} ${agfGameType.formatted}")
{
    init
    {
        placeholdBorders = true
        autoUpdate = true
    }

    override fun size(buttons: Map<Int, Button>): Int
    {
        // TODO: 10/26/2021 change dynamically depending on amount of servers online
        return 27
    }

    override fun getButtons(player: Player): Map<Int, Button>
    {
        return hashMapOf<Int, Button>().also {
            val servers = AgfGameInfoUpdater.gameInfo[agfGameType]

            servers?.forEach { gameInfo ->
                it[it.size + 10] = GameInfoButton(gameInfo)
            }
        }
    }

    inner class GameInfoButton(
        private val serverInstance: ServerInstance
    ) : Button()
    {
        private val gameState = AgfGameState.valueOf(
            serverInstance.metaData["game-state"]!!
        )

        override fun getMaterial(player: Player): Material
        {
            return Material.WOOL
        }

        override fun getDamageValue(player: Player): Byte
        {
            return when (gameState)
            {
                AgfGameState.WAITING -> 5
                AgfGameState.IN_GAME -> 13
                AgfGameState.STARTING -> 4
                AgfGameState.ENDING -> 1
            }
        }

        override fun getName(player: Player): String
        {
            return "${CC.B_PRI}${serverInstance.serverId}"
        }

        override fun getDescription(player: Player): List<String>
        {
            return listOf(
                "${CC.GRAY}Players: ${CC.WHITE}${
                    serverInstance.onlinePlayers
                }/${serverInstance.maxPlayers}",
                "",
                getStatus(),
                "",
                "${CC.YELLOW}Click to connect."
            )
        }

        private fun getStatus() = when (gameState)
        {
            AgfGameState.WAITING -> "${CC.YELLOW}Waiting for players..."
            AgfGameState.IN_GAME -> "${CC.D_GREEN}Game running..."
            AgfGameState.STARTING -> "${CC.GREEN}Game starting..."
            AgfGameState.ENDING -> "${CC.GOLD}Booting up..."
        }
    }
}
