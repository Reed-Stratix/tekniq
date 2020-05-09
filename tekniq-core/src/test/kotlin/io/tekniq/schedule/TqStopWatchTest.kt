package io.tekniq.schedule

import org.junit.Assert.*
import org.junit.Test
import java.lang.IllegalStateException

class TqStopWatchTest {
    @Test
    fun doesItWork() {
        val sw = TqStopWatch("random info")
        sw.elapse { ms, ctx ->
            assertEquals("random info", ctx)
            assertTrue(ms < 10)
        }
        Thread.sleep(300)
        sw.mark("next")
        sw.elapse { ms, ctx ->
            assertEquals("random info", ctx)
            assertTrue(ms in 300..310)
        }
        sw.elapse("next") { ms, ctx ->
            assertEquals("random info", ctx)
            assertTrue(ms in 0..10)
        }

        sw.reset()
        try {
            sw.elapse("next") {_, _ -> }
            fail("Should not have found the 'next' marker")
        } catch (e: IllegalStateException) {
            assertTrue(e.message!!.contains("next"))
        }
        sw.elapse { ms, ctx ->
            assertEquals("random info", ctx)
            assertTrue(ms < 10)
        }
    }
}
