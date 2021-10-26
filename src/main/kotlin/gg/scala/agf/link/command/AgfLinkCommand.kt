package gg.scala.agf.link.command

import gg.scala.agf.link.menu.AgfGameInfoDisplayMenu
import gg.scala.agf.link.type.AgfGameType
import net.evilblock.cubed.acf.BaseCommand
import net.evilblock.cubed.acf.annotation.CommandAlias
import net.evilblock.cubed.acf.annotation.Private
import org.bukkit.entity.Player

/**
 * @author GrowlyX
 * @since 10/26/2021
 */
class AgfLinkCommand : BaseCommand()
{
    @Private
    @CommandAlias("agf")
    fun onAgf(player: Player, impl: AgfGameType)
    {
        AgfGameInfoDisplayMenu(impl).openMenu(player)
    }
}
