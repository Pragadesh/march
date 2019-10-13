package org.pg.march.lc.coll;


import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.pg.march.lc.coll.LFUCache.DNode;
import org.pg.march.lc.coll.LFUCache.DNodeList;

import junit.framework.Assert;

public class LRUCacheTest {


    @Test
    public void testcase1() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        Assert.assertEquals(1, cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        Assert.assertEquals(-1, cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        Assert.assertEquals(-1, cache.get(1));       // returns -1 (not found)
        Assert.assertEquals(3, cache.get(3));       // returns 3
        Assert.assertEquals(4, cache.get(4));       // returns 4
    }
    
    @Test
    public void testcase2() {
        Map<Integer, DNodeList> freqMap = new HashMap<>();
        DNode n = new DNode(-1, -1);
        n.freq = 3;
        freqMap.getOrDefault(++n.freq, new DNodeList(n.freq)).addFirst(n);
    }
    
    public static enum Test2{
        ONE, TWO;
    }
}
