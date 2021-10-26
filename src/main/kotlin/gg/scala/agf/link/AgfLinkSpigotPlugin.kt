package gg.scala.agf.link

import gg.scala.agf.link.updater.AgfGameInfoUpdater
import gg.scala.commons.ExtendedScalaPlugin

/**
 * @author GrowlyX
 * @since 10/26/2021
 */
class AgfLinkSpigotPlugin : ExtendedScalaPlugin()
{

    override fun enable()
    {
        AgfGameInfoUpdater.start()
    }
}
