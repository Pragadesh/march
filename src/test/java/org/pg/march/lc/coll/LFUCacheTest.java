package org.pg.march.lc.coll;

import org.junit.Test;

import junit.framework.Assert;

public class LFUCacheTest {

    @Test
    public void testcase1() {
        LFUCache cache = new LFUCache( 2 /* capacity */ );
        cache.put(1, 1);
        cache.put(2, 2);
        Assert.assertEquals(1, cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        Assert.assertEquals(-1, cache.get(2));       // returns -1 (not found)
        Assert.assertEquals(3, cache.get(3));       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        Assert.assertEquals(-1, cache.get(1));       // returns -1 (not found)
        Assert.assertEquals(3, cache.get(3));       // returns 3
        Assert.assertEquals(4, cache.get(4));       // returns 4
    }
    
    @Test
    public void testcase2() {
        LFUCache cache = new LFUCache( 0 /* capacity */ );
        cache.put(0, 0);
        Assert.assertEquals(-1, cache.get(0));
    }
}
