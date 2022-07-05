package org.pg.march.lc.datastructure;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StockPriceTest {

    StockPrice stockPrice;

    @Before
    public void setup() {
        stockPrice = new StockPrice();
    }

    @Test
    public void testcase1() {
        stockPrice.update(1, 10); // Timestamps are [1] with corresponding prices [10].
        stockPrice.update(2, 5);  // Timestamps are [1,2] with corresponding prices [10,5].
        Assert.assertEquals(5, stockPrice.current());     // return 5, the latest timestamp is 2 with the price being 5.
        Assert.assertEquals(10, stockPrice.maximum());     // return 10, the maximum price is 10 at timestamp 1.
        stockPrice.update(1, 3);  // The previous timestamp 1 had the wrong price, so it is updated to 3.
        // Timestamps are [1,2] with corresponding prices [3,5].
        Assert.assertEquals(5, stockPrice.maximum());     // return 5, the maximum price is 5 after the correction.
        stockPrice.update(4, 2);  // Timestamps are [1,2,4] with corresponding prices [3,5,2].
        Assert.assertEquals(2, stockPrice.minimum());     // return 2, the minimum price is 2 at timestamp 4.
    }
}
