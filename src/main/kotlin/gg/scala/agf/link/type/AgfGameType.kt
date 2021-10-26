package gg.scala.agf.link.type

/**
 * @author GrowlyX
 * @since 10/26/2021
 */
enum class AgfGameType(
    val formatted: String,
    val group: String
)
{
    UHC_MEETUP("UHC Meetup", "uhc_meetup");

    companion object
    {
        @JvmStatic
        val ALL = values()
    }
}
