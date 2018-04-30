package technology.prior.talkandpaint

import org.junit.Test
import org.junit.Assert

/**
 * Created by Stephen on 01/11/2017.
 */
class TestColourRecogniser {

    private val mTarget = ColourRecogniser()
    @Test
    fun testExact()
    {
        Assert.assertTrue(mTarget.recognises("red"))
        Assert.assertEquals(mTarget.mFoundColour, 0xe6194b)
    }

    @Test
    fun testContains()
    {
        Assert.assertTrue(mTarget.recognises("paint blue please"))
        Assert.assertEquals(mTarget.mFoundColour, 0x0082c8)
    }

    @Test
    fun testNoMatch()
    {
        Assert.assertFalse(mTarget.recognises("what"))
    }
}