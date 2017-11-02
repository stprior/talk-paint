package technology.prior.talkandpaint

import android.graphics.Bitmap
import android.graphics.Color

/**
 * Created Stephen on 28/10/2017.
 */
interface ScreenInteraction {

    fun paint(x: Float, y: Float): Unit
    fun getBitmap(): Bitmap
    fun ready() : Boolean
    fun resize(width: Int, height: Int)
}

interface VoiceInteraction {

    fun setColor(color: Int): Unit
    fun setWeight(weight: Float): Unit
}