package org.pg.march.lc.coll;

import java.util.Comparator;

public class IndexedPQ<V> {

    private IndexedPQNode<V>[] nodes;
    private int[] indexToPQ;
	private int size;
	private int capacity;
    
	private Comparator<IndexedPQNode<V>> comparator;
	
    public IndexedPQ(int size) {
        this.capacity = size;
        nodes = new IndexedPQNode[size + 1];
        indexToPQ = new int[size];
    }
    
    public IndexedPQNode<V> deleteMin(){
        IndexedPQNode<V> result = nodes[1];
        if(result != null) {
            indexToPQ[result.index] = 0;
        }
        if(size == 1) {
            nodes[size--] = null;
        }else if (size > 1) {
            nodes[1] = nodes[size];
            nodes[size--] = null;
            sink(1);
        }
        return result;
    }
    
    public IndexedPQNode<V> peek(){
        return nodes[1];
    }
    
    public boolean isEmpty() {
        return (size == 0);
    }
    
    public void add(Integer index, V value) {
        if(index >= capacity) {
            throw new IllegalStateException("Index beyond limit: " + index);
        }
        
        if(indexToPQ[index] > 0) {
            update(index, value);
            return;
        }
        IndexedPQNode<V> node = new IndexedPQNode<>(index, value);
        if(size >= capacity) {
            throw new IllegalStateException("Collection is full.");
        }
        if(node != null) {
            nodes[++size] = node;
            indexToPQ[index] = size;
            swim(size);
        }
    }
    
    private void update(Integer index, V value) {
        IndexedPQNode<V> currNode = nodes[indexToPQ[index]];
        V oldValue = currNode.value;
        currNode.value = value;
        if(value instanceof Comparable) {
            int compare = ((Comparable) value).compareTo(oldValue);
            if(compare > 0) {
                sink(indexToPQ[index]);
            }else if (compare < 0) {
                swim(indexToPQ[index]);
            }
        }
    }
    
    public V delete(Integer index) {
        if(index >= capacity || indexToPQ[index] <= 0) {
            return null;
        }
        int nodePos = indexToPQ[index];
        IndexedPQNode<V> currNode = nodes[nodePos];
        V oldValue = currNode.value;
        IndexedPQNode<V> replaceNode = nodes[size];
        nodes[size--] = null;
        nodes[nodePos] = replaceNode;
        V value = replaceNode.value;
        if(value instanceof Comparable) {
            int compare = ((Comparable) value).compareTo(oldValue);
            if(compare > 0) {
                sink(nodePos);
            }else if (compare < 0) {
                swim(nodePos);
            }
        }
        indexToPQ[index] = 0;
        return oldValue;
    }
	
    
    private void sink(int pos) {
        while (2 * pos <= size) {
            int parent = 2 * pos;
            if (parent < size && nodes[parent].compareTo(nodes[parent + 1]) > 0) {
                parent++;
            }
            if (nodes[pos].compareTo(nodes[parent]) <= 0) {
                break;
            }
            exchange(pos, parent);
            pos = parent;
        }
    }
    
    private void swim(int pos) {
        while (pos > 1) {
            int parent = pos / 2;
            if (nodes[pos].compareTo(nodes[parent]) > 0) {
                break;
            }
            exchange(pos, parent);
            pos = parent;
        }
    }
    
    private void exchange(int pos1, int pos2) {
        IndexedPQNode<V> temp = nodes[pos1];
        nodes[pos1] = nodes[pos2];
        nodes[pos2] = temp;
        
        indexToPQ[nodes[pos1].index] = pos1;
        indexToPQ[nodes[pos2].index] = pos2;
    }
    
	public static class IndexedPQNode<V> implements Comparable<IndexedPQNode<V>>{
	    
	    private static final String FMT = "[%s, %s]";
	    
	    public final Integer index;
	    public V value;
	    
	    public IndexedPQNode(Integer index, V value) {
	        this.index = index;
	        this.value = value;
	    }

        @Override
        public int compareTo(IndexedPQNode<V> other) {
            if(this.value instanceof Comparable) {
                Comparable<? super V> thisValue = (Comparable<? super V>) this.value;
                return (thisValue.compareTo(other.value));
            }else {
                return Integer.compare(index, other.index);
            }
        }
	    
        @Override
        public String toString() {
            return String.format(FMT, index, value);
        }
	}
}
