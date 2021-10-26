package gg.scala.agf.link

import gg.scala.agf.link.command.AgfLinkCommand
import gg.scala.agf.link.updater.AgfGameInfoUpdater
import gg.scala.commons.ExtendedScalaPlugin
import net.evilblock.cubed.command.manager.CubedCommandManager

/**
 * @author GrowlyX
 * @since 10/26/2021
 */
class AgfLinkSpigotPlugin : ExtendedScalaPlugin()
{

    override fun enable()
    {
        val commandManager = CubedCommandManager(this)
        commandManager.registerCommand(AgfLinkCommand())

        AgfGameInfoUpdater.start()
    }
}
