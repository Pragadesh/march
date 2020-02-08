package org.pg.march.lc.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * https://leetcode.com/problems/palindrome-pairs/
 */
public class PalindromePairs {

    private static final int N = 26;
    private static final char char_a = 'a';

    public List<List<Integer>> palindromePairs(String[] words) {

        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.addWord(words[i], i);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            searchPairs(words[i], i, res, trie.root);
        }
        return res;
    }

    private void searchPairs(String word, int index, List<List<Integer>> res, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            if (node.index >= 0 && node.index != index && isPalindrome(word, i, word.length() - 1)) {
                res.add(Arrays.asList(index, node.index));
            }
            node = node.next[word.charAt(i) - char_a];
            if (node == null) return;

        }
        for (int mIndex : node.matchIndexes) {
            if (mIndex == index)
                continue;
            res.add(Arrays.asList(index, mIndex));
        }
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        }
        return true;
    }

    private static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void addWord(String word, int index) {
            TrieNode node = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char ch = word.charAt(i);
                if (node.next[ch - char_a] == null) {
                    node.next[ch - char_a] = new TrieNode();
                }
                if (isPalindrome(word, 0, i)) {
                    node.matchIndexes.add(index);
                }
                node = node.next[ch - char_a];
            }
            node.matchIndexes.add(index);
            node.index = index;
        }

    }

    private static class TrieNode {
        final TrieNode[] next;
        int index;
        final Set<Integer> matchIndexes;

        public TrieNode() {
            next = new TrieNode[N];
            index = -1;
            matchIndexes = new HashSet<>();
        }
    }
}
