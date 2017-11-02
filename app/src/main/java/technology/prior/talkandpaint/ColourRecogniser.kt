package technology.prior.talkandpaint

import android.graphics.Color
/**
 * Created by Stephen on 01/11/2017.
 */
class ColourRecogniser {

    var mFoundColour : Int? = null
    fun recognises(spokenText:String) : Boolean
    {
        for (colour in mColourMap.keys)
        {
            if (spokenText.contains(colour, ignoreCase = true))
            {
                mFoundColour = mColourMap[colour]
                return true
            }
        }
        return false
    }


    val mColourMap = hashMapOf(
            "Red" to 0xe6194b,
            "Green" to 0x3cb44b,
            "Yellow" to 0xffe119,
            "Blue" to 0x0082c8,
            "Orange" to 0xf58231,
            "Purple" to 0x911eb4,
            "Cyan" to 0x46f0f0,
            "Magenta" to 0xf032e6,
            "Lime" to 0xd2f53c,
            "Pink" to 0xfabebe,
            "Teal" to 0x008080,
            "Lavender" to 0xe6beff,
            "Brown" to 0xaa6e28,
            "Beige" to 0xfffac8,
            "Maroon" to 0x800000,
            "Mint" to 0xaaffc3,
            "Olive" to 0x808000,
            "Coral" to 0xffd8b1,
            "Navy" to 0x000080,
            "Grey" to 0x808080,
            "White" to 0xFFFFFF,
            "Black" to 0x000000)


}