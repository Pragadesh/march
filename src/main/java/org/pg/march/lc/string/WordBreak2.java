package org.pg.march.lc.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

/*
 * https://leetcode.com/problems/word-break-ii/
 */
public class WordBreak2 {

	
	
	public List<String> wordBreak(String s, List<String> wordDictList) {
		Set<String> wordDict = new HashSet<>(wordDictList);
		HashMap<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
		List<String> words = DFS(s, wordDict, map);
		for(int i=s.length() - 1; i >= 0; i--) {
			String word = s.substring(i);
			int size = map.get(word) == null ? 0 : map.get(word).size();
			System.out.println(word + " -> " + size);
		}
		
		for(Entry<String, LinkedList<String>> entry : map.entrySet()) {
			int size = entry.getValue() == null ? 0 : entry.getValue().size();
			System.out.println(entry.getKey() + " -> " + size);
		}
		return words;
	}       

	// DFS function returns an array including all substrings derived from s.
	List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>>map) {
	    if (map.containsKey(s)) 
	        return map.get(s);
	        
	    LinkedList<String>res = new LinkedList<String>();     
	    if (s.length() == 0) {
	        res.add("");
	        return res;
	    }               
	    for (String word : wordDict) {
	        if (s.startsWith(word)) {
	            List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
	            for (String sub : sublist) 
	                res.add(word + (sub.isEmpty() ? "" : " ") + sub);               
	        }
	    }       
	    map.put(s, res);
	    return res;
	}
	
	public List<String> wordBreakDP(String s, List<String> wordDict) {
		LinkedList<String>[] dp = new LinkedList[s.length() + 1];
		LinkedList<String> start = new LinkedList<>();
		start.add("");
		dp[0] = start;
		Set<String> wordDictSet = new HashSet<>(wordDict);
		for (int i = 1; i <= s.length(); i++) {
			LinkedList<String> list = new LinkedList<>();
			for (int j = 0; j < i; j++) {
				String word = s.substring(j, i);
				if (!dp[j].isEmpty() && wordDictSet.contains(word)) {
					 for(String dpWord : dp[j]) {
						 list.add(dpWord.isEmpty() ? word : dpWord + " " + word);
					 }
				}
			}
			dp[i] = list;
		}
		return dp[s.length()];
	}

	public List<String> wordBreakByTrie(String s, List<String> wordDict) {
		Trie trie = new Trie();
		for (String word : wordDict) {
			trie.addWord(word);
		}
		List<Splitter> splitters = new ArrayList<>();
		splitters.add(new Splitter(trie.head));
		for (int i = 0; i < s.length(); i++) {
			List<Splitter> newSplitters = new ArrayList<>();
			System.out.println(String.format("Checking %d jobs for index %d", splitters.size(), i));
			int index = s.charAt(i) - 'a';
			for (Splitter splitter : splitters) {
				if (splitter.trieNode.next[index] != null) {
					TrieNode node = splitter.trieNode.next[index];
					if (node.value != null) {
						Splitter newSplitter = new Splitter(trie.head);
						newSplitter.addString(
								splitter.builder == null ? node.value : splitter.builder.toString() + " " + node.value);
						newSplitters.add(newSplitter);
					}
					splitter.trieNode = node;
					if (i != s.length() - 1)
						newSplitters.add(splitter);
				}
			}

			if (newSplitters.isEmpty()) {
				return new ArrayList<>();
			}
			splitters = newSplitters;
		}
		List<String> res = new ArrayList<>();
		for (Splitter splitter : splitters) {
			res.add(splitter.builder.toString());
		}
		return res;
	}

	private static class Splitter {
		private StringBuilder builder;
		private TrieNode trieNode;

		public Splitter(TrieNode trieNode) {
			this.trieNode = trieNode;
		}

		public void addString(String word) {
			if (builder == null) {
				builder = new StringBuilder();
				builder.append(word);
			} else {
				builder.append(" ").append(word);
			}
		}
	}

	private static class Trie {

		TrieNode head = new TrieNode();

		public void addWord(String word) {
			TrieNode node = head;
			for (char c : word.toCharArray()) {
				int index = c - 'a';
				if (node.next[index] == null) {
					node.next[index] = new TrieNode();
				}
				node = node.next[index];
			}
			node.value = word;
		}

	}

	private static class TrieNode {
		TrieNode[] next;
		String value;

		public TrieNode() {
			next = new TrieNode[26];
		}
	}
}
