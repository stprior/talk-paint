package technology.prior.talkandpaint

import android.graphics.Bitmap
import android.graphics.Canvas


/**
 * Created by Stephen on 28/10/2017.
 */
fun startup(activity:PaintActivity)
{
    val b = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888)
    val c = Canvas(b)
    //Create canvas
    //wire up event handlers
}