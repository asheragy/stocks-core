package org.cerion.stocklist.web;

import org.cerion.stocklist.Price;
import org.cerion.stocklist.web.api.YahooFinance;
import org.junit.Test;

import static org.junit.Assert.*;

public class YahooFinanceTest {

    @Test
    public void parseLine_allPricesEqual() {
        Price p = YahooFinance.parseLine("2017-02-17,12.01,12.01,12.01,12.01,12.01,000");

        assertEquals(12.01, p.getOpen(), 0.0000005);
        assertEquals(12.01, p.getHigh(), 0.0000005);
        assertEquals(12.01, p.getLow(), 0.0000005);
        assertEquals(12.01, p.getClose(), 0.0000005);
    }

    @Test
    public void parseLine_allPricesEqual_adjClose() {
        Price p = YahooFinance.parseLine("2017-02-17,12.01,12.01,12.01,12.01,11.973215,000");

        assertEquals(11.973215, p.getOpen(), 0.0000005);
        assertEquals(11.973215, p.getHigh(), 0.0000005);
        assertEquals(11.973215, p.getLow(), 0.0000005);
        assertEquals(11.973215, p.getClose(), 0.0000005);
    }
}