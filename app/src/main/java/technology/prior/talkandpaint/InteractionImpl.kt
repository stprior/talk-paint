package technology.prior.talkandpaint

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

/**
 * Central object for coordinating interaction between user and image
 */
class InteractionImpl : ScreenInteraction, VoiceInteraction {
    private var mBitmap : Bitmap?=null
    private var mCanvas : Canvas?=null
    private val mBrushPaint = Paint()
    private val mBackgroundPaint = Paint()
    private var mBrushWidth: Float = 7.0F

    override fun setWeight(weight: Float) {
        mBrushWidth = weight
    }

    override fun setColor(color: Int) {
        mBrushPaint.color = color
    }

    init {
        mBrushPaint.color = Color.BLUE
        mBackgroundPaint.color = Color.GRAY
    }

    override fun ready() : Boolean
    {
        return (mCanvas != null)
    }

    private fun initCanvas(width: Int, height: Int)
    {
        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(mBitmap)
        canvas.drawPaint(mBackgroundPaint)
        mCanvas = canvas
    }

    override fun resize(width: Int, height: Int)
    {
        val bitmap = mBitmap ?: return initCanvas(width, height)
        val newBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val newCanvas = Canvas(newBitmap)
        newCanvas.drawBitmap(bitmap,0F,0F, mBackgroundPaint)
        mBitmap = newBitmap
        mCanvas = newCanvas
    }

    override fun paint(x: Float, y: Float) {
        mCanvas?.drawCircle(x,y,mBrushWidth,mBrushPaint)
    }

    override fun getBitmap() : Bitmap {
        return mBitmap ?: Bitmap.createBitmap(10,10,null)
    }
}
