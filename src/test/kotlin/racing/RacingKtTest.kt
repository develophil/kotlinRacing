package racing

import org.junit.Assert
import org.junit.Test

/**
 * Created by hkpking on 2018. 1. 24..
 */
class RacingKtTest {
    @Test
    fun scannerTest() {
        val input = getInputData("test : ")
        Assert.assertEquals("test", input)

    }
}