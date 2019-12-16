package org.pg.march.lc.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

/*
 * https://leetcode.com/problems/alien-dictionary/
 */
public class AlienDictionary {

    private static final int N = 26;

    public String alienOrder(String[] words) {
        return alienOrderBFS(words);
    }

    public String alienOrderBFS(String[] words) {
        Map<Character, Integer> degreeMap = new HashMap<>();
        Map<Character, Set<Character>> adjMap = new HashMap<>();
        buildBFSMap(words, degreeMap, adjMap);
        Queue<Character> queue = new LinkedList<>();
        for(Entry<Character, Integer> degree : degreeMap.entrySet()) {
            if(degree.getValue() == 0) {
                queue.add(degree.getKey());
            }
        }
        StringBuilder builder = new StringBuilder();
        while(!queue.isEmpty()) {
            Character ch = queue.poll();
            builder.append(ch);
            for(char adj : adjMap.getOrDefault(ch, new HashSet<>())) {
            	int degree = degreeMap.getOrDefault(adj, 0);
            	if(degree > 0) {
            	    degreeMap.put(adj, --degree);
            	    if(degree == 0)
            	        queue.add(adj);
            	}
            }
            
        }
        String ans = builder.toString();
        if(ans.length() != degreeMap.size()) return "";
        return ans;
    }

    private void buildBFSMap(String[] words, Map<Character, Integer> degreeMap, Map<Character, Set<Character>> adjMap) {
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                degreeMap.put(ch, 0);
            }
        }
        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String curr = words[i];
            int len = Math.min(prev.length(), curr.length());
            for (int j = 0; j < len; j++) {
                char ch1 = prev.charAt(j);
                char ch2 = curr.charAt(j);
                if (ch1 != ch2) {
                    Set<Character> adj = adjMap.getOrDefault(ch1, new HashSet<>());
                    if(!adj.contains(ch2)) {
                        adj.add(ch2);
                        degreeMap.put(ch2, degreeMap.getOrDefault(ch2, 0) + 1);
                        adjMap.put(ch1, adj);
                    }
                    break;
                }
            }
        }
    }

    public String alienOrderDFS(String[] words) {
        boolean[][] adj = new boolean[N][N];
        int visited[] = new int[N];
        buildGraph(words, adj, visited);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {
                if (!dfs(i, adj, visited, builder))
                    return "";
            }
        }
        return builder.toString();
    }

    private boolean dfs(int v, boolean[][] adj, int visited[], StringBuilder builder) {
        visited[v] = 1;

        for (int i = 0; i < N; i++) {
            if (adj[v][i]) {
                if (visited[i] == 1)
                    return false;
                if (visited[i] == 0) {
                    if (!dfs(i, adj, visited, builder))
                        return false;
                }
            }

        }
        visited[v] = 2;
        builder.append((char) (v + 'a'));
        return true;
    }

    private void buildGraph(String[] words, boolean[][] adj, int visited[]) {
        Arrays.fill(visited, -1);
        for (int i = 0; i < words.length; i++) {
            String curr = words[i];
            for (char ch : curr.toCharArray())
                visited[ch - 'a'] = 0;
            if (i > 0) {
                String prev = words[i - 1];
                int len = Math.min(prev.length(), curr.length());
                for (int j = 0; j < len; j++) {
                    int ch1 = prev.charAt(j) - 'a';
                    int ch2 = curr.charAt(j) - 'a';
                    if (ch1 != ch2) {
                        adj[ch2][ch1] = true;
                        break;
                    }
                }
            }
        }
    }

}
