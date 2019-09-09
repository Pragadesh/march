package org.pg.march.lc.arr;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class RussianDollEnvelopesTest {

    private RussianDollEnvelopes russianDollEnvelopes;

    @Before
    public void setup() {
        russianDollEnvelopes = new RussianDollEnvelopes();
    }

    @Test
    public void testCase1() {
        int[][] envelopes = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };
        Assert.assertEquals(3, russianDollEnvelopes.maxEnvelopes(envelopes));
    }

}
