package org.cerion.stocks.core.overlays

import org.cerion.stocks.core.PriceList
import org.cerion.stocks.core.arrays.FloatArray
import org.cerion.stocks.core.arrays.PairArray
import org.cerion.stocks.core.arrays.ValueArray
import org.cerion.stocks.core.functions.types.PriceOverlay
import org.cerion.stocks.core.indicators.AverageTrueRange

class ChandelierExit(period: Int, multiplier: Double) : PriceOverlayBase(PriceOverlay.CEXIT, period, multiplier) {

    constructor() : this(22, 3.0)

    override fun eval(list: PriceList): PairArray {
        return chandelierExit(list, getInt(0), getFloat(1))
    }

    override val name: String = "Chandelier Exit"

    private fun chandelierExit(list: PriceList, period: Int, multiplier: Float): PairArray {
        val size = list.size

        val high = FloatArray(size)
        val low = FloatArray(size)
        val atr = AverageTrueRange(period).eval(list)

        for (i in 0 until size) {
            val p = ValueArray.maxPeriod(i, period)

            val h = list.high.max(i - p + 1, i) // highest high
            val l = list.low.min(i - p + 1, i) // lowest low

            high[i] = h - atr[i] * multiplier
            low[i] = l + atr[i] * multiplier
        }

        return PairArray(high, low)
    }
}
