package org.cerion.stocklist.overlays

import org.cerion.stocklist.TestBase
import org.cerion.stocklist.overlays.ExpMovingAverage
import org.junit.Assert.*
import org.junit.Test

class ExpMovingAverageTest : TestBase() {

    @Test
    fun ema_tests() {
        // Not verified online although many other indicators use this so its tested indirectly
        var ema = ExpMovingAverage().eval(priceList)
        assertEquals(priceList.close.first, ema.first)
        assertEqual(2054.47, ema.last)

        ema = ExpMovingAverage(123).eval(priceList)
        assertEquals(priceList.close.first, ema.first)
        assertEqual(2047.90, ema.last)
    }
}