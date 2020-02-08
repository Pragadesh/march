package org.pg.march.lc.coll;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * https://leetcode.com/problems/maximum-frequency-stack/
 */


/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
public class FreqStack {

	Map<Integer, Stack<Integer>> stacks;
	Map<Integer, Integer> nodeFrequency;
	private int maxFrequency;
	
	
    public FreqStack() {
    	stacks = new HashMap<>();
    	nodeFrequency = new HashMap<>();
    	maxFrequency = 0;
    }
    
    public void push(int x) {
        int freq = nodeFrequency.getOrDefault(x, 0) + 1;
        nodeFrequency.put(x, freq);
        maxFrequency = Math.max(maxFrequency, freq);
        stacks.putIfAbsent(freq, new Stack<>());
        stacks.get(freq).push(x);
    }
    
    public int pop() {
    	Stack<Integer> stack = stacks.get(maxFrequency);
    	int x = stack.pop();
    	nodeFrequency.put(x, maxFrequency - 1);
    	if(stack.isEmpty()) {
    		maxFrequency--;
    	}
        return x;
    }
}
