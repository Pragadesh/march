package org.pg.march.lc.string;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/concatenated-words/
 */
public class ConcatenatedWords {

    private static final char a = 'a';

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie trie = new Trie();
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (word.isEmpty())
                continue;
            trie.addWord(word);
        }
        for (String word : words) {
            if (!word.isEmpty() && isConcatenatedWord(word.toCharArray(), 0, trie.root, 0)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean isConcatenatedWord(char[] charArray, int start, TrieNode root, int count) {
        TrieNode curr = root;
        for (int i = start; i < charArray.length; i++) {
            curr = curr.next[charArray[i] - a];
            if (curr == null) {
                return false;
            }
            if (curr.isEnd) {
                if (i == charArray.length - 1) {
                    return count >= 1;
                } else
                    if (isConcatenatedWord(charArray, i + 1, root, count + 1)) {
                        return true;
                    }

            }
        }
        return false;
    }

    private static class Trie {
        private final TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public TrieNode addWord(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (node.next[ch - a] == null) {
                    node.next[ch - a] = new TrieNode();
                }
                node = node.next[ch - a];
            }
            node.isEnd = true;
            return node;
        }

    }

    private static class TrieNode {
        final TrieNode[] next;
        boolean isEnd;

        public TrieNode() {
            next = new TrieNode[26];
        }

    }
}
