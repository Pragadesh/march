package org.pg.march.lc.coll;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/lru-cache/submissions/
 */
public class LRUCache {

    private int size;
    private int capacity;
    private Map<Integer, Node> elementMap;
    private Node head, tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.elementMap = new HashMap<>(capacity);
        initLinkedList();
    }
    
    private void initLinkedList() {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node n;
        if ((n = elementMap.get(key)) != null)
            moveFirst(n);
        return (n != null ? n.value : -1);
    }

    public void put(int key, int value) {
        Node n;
        if((n = elementMap.get(key)) != null) {
            n.value = value;
            moveFirst(n);
            return;
        }
        while (size >= capacity) {
            n = deleteLast();
            elementMap.remove(n.key);
            size--;
        }
        Node newNode = new Node(key, value);
        elementMap.put(key, newNode);
        addFirst(newNode);
        size++;
    }
    
    private void delete(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }
    
    private void addFirst(Node n) {
        n.next = head.next;
        n.prev = head;
        head.next.prev = n;
        head.next = n;
    }
    
    private Node deleteLast() {
        Node n = tail.prev;
        delete(n);
        return n;
    }
    
    private void moveFirst(Node n) {
        delete(n);
        addFirst(n);
    }
    
    private static class Node{
        private int key;
        private int value;
        
        private Node prev;
        private Node next;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
}
