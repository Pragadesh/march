package org.pg.march.lc.design;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


/**
 * 
 * https://leetcode.com/problems/design-search-autocomplete-system/
 * 
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
public class AutocompleteSystem {

	private static Comparator<Map.Entry<String, Integer>> comparator = (a,b) ->  {
		int compare = Integer.compare(a.getValue(), b.getValue());
		if(compare == 0) {
			return a.getKey().compareTo(b.getKey());
		}
		return compare;
	};
	
	private TrieNode root;
	private TrieNode matchedNode;
	private StringBuilder inputBuffer;
	private int matchedIndex;
	private boolean matchFailed;
	
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        matchedNode = root;
        inputBuffer = new StringBuilder();
        for(int i = 0; i<sentences.length; i++) {
			createEntry(sentences[i], root, 0, times[i]);
        }
        
    }
    
    private List<Map.Entry<String, Integer>> createEntry(String sentence, TrieNode node, int index, int hitDelta){
    	List<Map.Entry<String, Integer>> result = new ArrayList<Map.Entry<String,Integer>>();
    	if(index >= sentence.length()) return result;
    	char ch = sentence.charAt(index);
    	TrieNode childNode = node;
    	if(ch == '#' || index == sentence.length()-1) {
    		node.value = sentence.substring(0, index+1);
        	node.hits += hitDelta;
        	node.pq.add(new AbstractMap.SimpleEntry<String,Integer>(node.value, node.hits));
    	}else {
    		int cIdx = sentence.charAt(index) == ' ' ? 26 : sentence.charAt(index) - 'a';
        	if(node.next[cIdx] == null) {
        		node.next[cIdx] = new TrieNode();
        	}
        	childNode = node.next[cIdx];
    	}
    	List<Map.Entry<String, Integer>> childTopHits = createEntry(sentence, childNode, index + 1, hitDelta);
    	node.pq.addAll(childTopHits);
    	while(node.pq.size() > 3) node.pq.poll();
    	Iterator<Map.Entry<String, Integer>> itr = node.pq.iterator();
    	while(itr.hasNext()) {
    		result.add(itr.next());
    	}
    	return result;
    }
    
    public List<String> input(char c) {
    	List<Map.Entry<String, Integer>> result = new ArrayList<Map.Entry<String,Integer>>();
    	if(c != '#')
    		inputBuffer.append(c);
    	if(c == '#') {
    		createEntry(inputBuffer.toString(), root, 0, 1);
    	}else if (matchedNode != null){
    		int cIdx = c == ' ' ? 26 : c - 'a';
    		matchedNode = matchedNode.next[cIdx];
    	}
    	if(matchedNode != null) {
    		Iterator<Map.Entry<String, Integer>> itr = matchedNode.pq.iterator();
        	while(itr.hasNext()) {
        		result.add(itr.next());
        	}
    	}
        Collections.sort(result, comparator);
        List<String> r = new ArrayList<>();
        for(Map.Entry<String, Integer> rs : result) {
        	r.add(rs.getKey());
        }
        return r;
    }
    
    public static class TrieNode{
    	
    	private String value;
    	private int hits;
    	
    	private TrieNode[] next;
    	private PriorityQueue<Map.Entry<String, Integer>> pq;
    	
    	public TrieNode() {
    		next = new TrieNode[27];
    		pq = new PriorityQueue<>(comparator);
    	}
    }
}
