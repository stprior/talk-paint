package technology.prior.talkandpaint

import android.graphics.Bitmap
import android.graphics.Canvas

/**
 * Created by Stephen on 30/10/2017.
 */
class CanvasWrapper {

    var mBitmap : Bitmap? = null

    var mCanvas : Canvas? = null

    fun loadBitmap(width: Int, height: Int) {
        mBitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888)
    }

    fun getCanvas() : Canvas{
        if (mBitmap == null)
        {
            throw IllegalStateException("Must first load bitmap")
        }
        if (mCanvas == null)
        {
            mCanvas = Canvas(mBitmap)
        }
        return mCanvas as Canvas
    }

}