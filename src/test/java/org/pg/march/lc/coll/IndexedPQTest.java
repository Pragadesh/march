package org.pg.march.lc.coll;

import org.junit.Test;

public class IndexedPQTest {

    @Test
    public void testcase1() {
        IndexedPQ<Integer> indexedPQ = new IndexedPQ<>(5);
        indexedPQ.add(2,2);
        indexedPQ.add(4,4);
        indexedPQ.add(1,1);
        indexedPQ.add(0,5);
        indexedPQ.add(3,3);
        
        System.out.println("Peeked -> "+ indexedPQ.peek());
        indexedPQ.add(1,3);
        System.out.println("Peeked -> "+ indexedPQ.peek());
        indexedPQ.add(3,10);
        System.out.println("Peeked -> "+ indexedPQ.peek());
        indexedPQ.add(2,20);
        System.out.println("Peeked -> "+ indexedPQ.peek());
        
        System.out.println(indexedPQ.delete(0));
        
        System.out.println("Peeked -> "+ indexedPQ.peek());
        System.out.println(indexedPQ.delete(1));
        
        
        int i = 10;
        while(i-- > 0) {
            System.out.println(indexedPQ.deleteMin());
        }
    }
    
    public void testcase2() {
        IndexedPQ<IndexTest> indexedPQ = new IndexedPQ<>(5);
        indexedPQ.add(2,new IndexTest(2));
        indexedPQ.add(4,new IndexTest(4));
        indexedPQ.add(9,new IndexTest(1));
        indexedPQ.add(5,new IndexTest(5));
        indexedPQ.add(3,new IndexTest(3));
        int i = 10;
        while(i-- > 0) {
            System.out.println(indexedPQ.deleteMin());
        }
    }
    
    
    private static class IndexTest{
        public final int value;
        public IndexTest(int value) {
            this.value = value;
        }
        
        @Override
        public String toString() {
            return Integer.toString(value);
        }
    }
}
