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
 * https://leetcode.com/problems/word-ladder/
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> transformationMap = createTransformationMap(wordList);
        return bfs(beginWord, endWord, transformationMap);
    }

    private int bfs(String beginWord, String endWord, Map<String, Set<String>> transformationMap) {
        Set<String> visited = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        visited.add(beginWord);

        Set<String> emptySet = new HashSet<>();
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (String generic : getSingleChangeGenerics(pair.word)) {
                for (String mappedWord : transformationMap.getOrDefault(generic, emptySet)) {
                    if (mappedWord.equals(endWord)) {
                        return pair.level + 1;
                    }
                    if (!visited.contains(mappedWord)) {
                        visited.add(mappedWord);
                        queue.add(new Pair(mappedWord, pair.level + 1));
                    }
                }
            }
        }

        return 0;
    }

    private Map<String, Set<String>> createTransformationMap(List<String> wordList) {
        Map<String, Set<String>> transformationMap = new HashMap<>();
        for (String word : wordList) {
            for (String generic : getSingleChangeGenerics(word)) {
                transformationMap.putIfAbsent(generic, new HashSet<>());
                transformationMap.get(generic).add(word);
            }
        }
        return transformationMap;
    }

    private List<String> getSingleChangeGenerics(String word) {
        List<String> generics = new ArrayList<>();
        int len = word.length();
        for (int i = 0; i < len; i++) {
            String generic = word.substring(0, i) + "*" + word.substring(Math.min(i + 1, len));
            generics.add(generic);
        }
        return generics;
    }

    private static class Pair {

        public Pair(String word, int level) {
            this.word = word;
            this.level = level;
        }

        private String word;
        private int level;
    }

}
