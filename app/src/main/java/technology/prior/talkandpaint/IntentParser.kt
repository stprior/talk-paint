package technology.prior.talkandpaint

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.util.Log

/**
 * Created by Stephen on 01/11/2017.
 */
class IntentParser(interaction : VoiceInteraction) : RecognitionListener
{
    override fun onReadyForSpeech(p0: Bundle?) {
        Log.v("IntentParser","onReadyForSpeech")
    }

    override fun onRmsChanged(p0: Float) {
        Log.v("IntentParser","onReadyForSpeech")
    }

    override fun onBufferReceived(p0: ByteArray?) {
        Log.v("IntentParser","onReadyForSpeech")
    }

    override fun onPartialResults(p0: Bundle?) {
        Log.v("IntentParser","onReadyForSpeech")
    }

    override fun onEvent(p0: Int, p1: Bundle?) {
        Log.v("IntentParser","onReadyForSpeech")
    }

    override fun onBeginningOfSpeech() {
        Log.v("IntentParser","onReadyForSpeech")
    }

    override fun onEndOfSpeech() {
        Log.v("IntentParser","onReadyForSpeech")
    }

    override fun onError(p0: Int) {
        Log.w("IntentParser","onError: $p0")
    }

    override fun onResults(p0: Bundle?) {
        Log.v("IntentParser","onResults")
        if (p0 == null) return
        val results = p0.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
        val confidence = p0.getStringArrayList(SpeechRecognizer.CONFIDENCE_SCORES)
        for(i in results.indices)
        {

            Log.d("IntentParser", "$i: \"${results[i]}\" (${confidence[i]})")
        }
        parseIntent(results[0])
    }

    val mInteraction = interaction
    val colourRecogniser = ColourRecogniser()
    fun parseIntent(spokenText: String)
    {
        if (colourRecogniser.recognises(spokenText))
        {
            mInteraction.setColor(colourRecogniser.mFoundColour!!)
        }
    }

}
