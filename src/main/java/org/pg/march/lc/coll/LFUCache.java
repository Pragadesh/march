package org.pg.march.lc.coll;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/lfu-cache/
 */
public class LFUCache {
    
    private Map<Integer, DNode> nodeMap;
    private Map<Integer, DNodeList> freqMap;
    private int minFreq;
    private int capacity;
    private int size;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.nodeMap = new HashMap<>(2 * capacity);
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        if(size == 0) {return -1;}
        DNode n;
        if ((n = nodeMap.get(key)) != null) {
            updateFrequency(n);
            return n.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(capacity == 0) {return;}
        DNode n;
        if ((n = nodeMap.get(key)) != null) {
            n.value = value;
            updateFrequency(n);
        }else {
            n = new DNode(key, value);
            if(size == capacity) {
                DNode delNode = freqMap.get(minFreq).deleteLast();
                this.nodeMap.remove(delNode.key);
                size--;
            }
            addNodeToFreqMap(n);
            this.nodeMap.put(key, n);
            size++;
            minFreq = Math.min(minFreq, n.freq);
        }
    }
    
    private void updateFrequency(DNode n) {
        DNodeList nodeList;
        if ((nodeList = freqMap.get(n.freq)) != null) {
            nodeList.delete(n);
//            if(nodeList.size == 0) {
//                freqMap.remove(n.freq);
//                if(n.freq == minFreq) {
//                    minFreq++;
//                }
//            }
            if(nodeList.size == 0 && n.freq == minFreq) {
                minFreq++;
            }
        }
        n.freq++;
        addNodeToFreqMap(n);
    }
    
    private void addNodeToFreqMap(DNode n) {
        DNodeList nodeList = freqMap.get(n.freq);
        if(nodeList == null) {
            nodeList = new DNodeList(n.freq);
            nodeList.freq = n.freq;
            freqMap.put(n.freq, nodeList);
        }
        nodeList.addFirst(n);
    }
    
    public static class DNode{
        private int key;
        private int value;
        public int freq;
        
        private DNode prev, next;
        
        public DNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "DNode [key=" + key + ", value=" + value + ", freq=" + freq + "]";
        }
    }
    
    public static class DNodeList{
        private DNode sentinel;
        private int size;
        private int freq;
        
        public DNodeList(int freq) {
             this.sentinel = new DNode(-1, -1);
             sentinel.prev = sentinel;
             sentinel.next = sentinel;
             this.freq = freq;
        }
        
        public void addFirst(DNode node) {
            node.next = sentinel.next;
            node.prev = sentinel;
            sentinel.next.prev = node;
            sentinel.next = node;
            size++;
        }
        
        public DNode deleteLast() {
            return delete(sentinel.prev);
        }
        
        public DNode deleteFirst() {
            return delete(sentinel.next);
        }
        
        public DNode delete(DNode node) {
            if(size > 0) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                size--;
                return node;
            }
            return null;
        }

        @Override
        public String toString() {
            return "DNodeList [sentinel=" + sentinel + ", size=" + size + ", freq=" + freq + "]";
        }
        
    }
}
