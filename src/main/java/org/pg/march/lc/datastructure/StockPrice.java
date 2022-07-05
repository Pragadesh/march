package org.pg.march.lc.datastructure;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/stock-price-fluctuation/
 */
public class StockPrice {

    private final SortedMap<Integer, Integer> timeMap;
    private final SortedMap<Integer, Set<Integer>> priceMap;


    public StockPrice() {
        timeMap = new TreeMap<>();
        priceMap = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        if (timeMap.containsKey(timestamp)) {
            int oldPrice = timeMap.remove(timestamp);
            Set<Integer> allTimeStamps = priceMap.get(oldPrice);
            allTimeStamps.remove(timestamp);
            if (allTimeStamps.isEmpty()) {
                priceMap.remove(oldPrice);
            }
        }
        timeMap.put(timestamp, price);
        priceMap.put(price, priceMap.getOrDefault(price, new HashSet<>()));
        priceMap.get(price).add(timestamp);
    }

    public int current() {
        return timeMap.get(timeMap.lastKey());
    }

    public int maximum() {
        return priceMap.lastKey();
    }

    public int minimum() {
        return priceMap.firstKey();
    }
}
