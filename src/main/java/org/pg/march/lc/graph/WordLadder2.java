package org.pg.march.lc.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * https://leetcode.com/problems/word-ladder-ii/
 */
public class WordLadder2 {

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		Map<String, Set<String>> transformationMap = createTransformationMap(wordList);
		return bfs(beginWord, endWord, transformationMap);
	}

	private List<List<String>> bfs(String beginWord, String endWord, Map<String, Set<String>> transformationMap) {
		Set<String> visited = new HashSet<>();
		Set<String> levelVisited = new HashSet<>();
		Set<String> empty = new HashSet<>();
		Queue<WordNode> queue = new LinkedList<>();
		queue.add(new WordNode(0, beginWord));
		visited.add(beginWord);
		levelVisited.add(beginWord);
		int finishIndex = Integer.MAX_VALUE;
		List<List<String>> result = new ArrayList<>();
		int level = 0;
		while (!queue.isEmpty() && queue.peek().index <= finishIndex) {
			
			WordNode node = queue.poll();
//			System.out.println(String.format("Processing word: *** %s ***", node.word));
			if(level != node.index) {
				levelVisited.clear();
				level = node.index;
			}
			if(node.word.equals(endWord)) {
				node.traversedList.add(node.word);
				finishIndex = node.index;
				result.add(node.traversedList);
			}else {
				for(String transformWord : generateTransformedList(node.word)) {
					for(String neighborWord : transformationMap.getOrDefault(transformWord, empty)) {
						if(!visited.contains(neighborWord) || levelVisited.contains(neighborWord)) {
							visited.add(neighborWord);
							levelVisited.add(neighborWord);
							WordNode newNode = new WordNode(node.index+1, neighborWord, node.traversedList);
							newNode.traversedList.add(node.word);
							queue.add(newNode);
//							System.out.println("Adding node: " + newNode);
						}
					}
				}
			}
		}
		return result;
	}

	protected Map<String, Set<String>> createTransformationMap(List<String> wordList) {
		Map<String, Set<String>> transformationMap = new HashMap<>();
		for (String word : wordList) {
			for(String transformWord : generateTransformedList(word)) {
				transformationMap.putIfAbsent(transformWord, new HashSet<>());
				transformationMap.get(transformWord).add(word);
			}
		}
		return transformationMap;
	}
	
	private List<String> generateTransformedList(String word){
		List<String> transformList = new ArrayList<>();
		for (int i = 0; i < word.length(); i++) {
			String transformWord = word.substring(0, i) + "*" + word.substring(i + 1);
			transformList.add(transformWord);
		}
		return transformList;
	}

	private static class WordNode {
		final int index;
		final String word;
		final List<String> traversedList;

		public WordNode(int index, String word) {
			this.index = index;
			this.word = word;
			this.traversedList = new ArrayList<>();
		}

		public WordNode(int index, String word, List<String> traversedList) {
			this(index, word);
			this.traversedList.addAll(traversedList);
		}

		@Override
		public String toString() {
			return "WordNode [index=" + index + ", word=" + word + ", traversedList=" + traversedList + "]";
		}

	}
}
