
package technology.prior.talkandpaint

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.speech.RecognizerIntent
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.support.v4.app.ActivityCompat.startActivityForResult
import space.traversal.kapsule.Injects
import space.traversal.kapsule.required


/**
 * touch to paint, talk to change color
 */
class PaintView(context: Context, attrs: AttributeSet) : View(context, attrs)  {

    var interaction : ScreenInteraction = InteractionImpl()
    private fun Interaction() : ScreenInteraction
    {
        if (!interaction.ready())
        {
            interaction.resize(width, height)
        }
        return interaction
    }
    private var mHasTouch = false

    fun paintFromTouch(actionId: Int, motionEvent: MotionEvent) {
        Interaction().paint(motionEvent.getX(actionId), motionEvent.getY(actionId))
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        val action = event.action

        /*
         * Switch on the action. The action is extracted from the event by
         * applying the MotionEvent.ACTION_MASK. Alternatively a call to
         * event.getActionMasked() would yield in the action as well.
         */
        when (action and MotionEvent.ACTION_MASK) {

            MotionEvent.ACTION_DOWN -> {
                // first pressed gesture has started
                mHasTouch = true

                Interaction().paint(event.getX(0), event.getY(0))

            }

            MotionEvent.ACTION_POINTER_DOWN -> {
                val index = event.actionIndex
                val id = event.getPointerId(index)

                paintFromTouch(index, event)

            }

            MotionEvent.ACTION_UP -> {
                /*
                 * Final pointer has gone up and has ended the last pressed
                 * gesture.
                 */

                mHasTouch = false
            }

            MotionEvent.ACTION_MOVE -> {
                /*
                 * A change event happened during a pressed gesture. (Between
                 * ACTION_DOWN and ACTION_UP or ACTION_POINTER_DOWN and
                 * ACTION_POINTER_UP)
                 */

                /*
                 * Loop through all active pointers contained within this event.
                 * Data for each pointer is stored in a MotionEvent at an index
                 * (starting from 0 up to the number of active pointers). This
                 * loop goes through each of these active pointers, extracts its
                 * data (position and pressure) and updates its stored data. A
                 * pointer is identified by its pointer number which stays
                 * constant across touch events as long as it remains active.
                 * This identifier is used to keep track of a pointer across
                 * events.
                 */
                for (index in 0 until event.pointerCount) {
                    // get pointer id for data stored at this index
                    paintFromTouch(index, event)
                }
            }
        }

        // trigger redraw on UI thread
        this.postInvalidate()

        return true
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (interaction != null) {
            canvas.drawBitmap(Interaction().getBitmap(), 0F, 0F, null)
        }
    }
    companion object {
        /*
         * companion object required for activity to instantiate PaintView later than its own init
         */
    }
}