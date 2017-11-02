package technology.prior.talkandpaint

import android.app.Activity
import android.content.Intent
import android.speech.RecognizerIntent

/**
 * Created by Stephen on 01/11/2017.
 */
class IntentParser(interaction : VoiceInteraction)
{
    val mInteraction = interaction
    val colourRecogniser = ColourRecogniser()
    fun parseIntent(data: Intent)
    {
        val results = data.getStringArrayListExtra(
                RecognizerIntent.EXTRA_RESULTS)
        val spokenText = results[0]

        if (colourRecogniser.recognises(spokenText))
        {
            mInteraction.setColor(colourRecogniser.mFoundColour!!)
        }
    }

}
