package org.pg.march.lc.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 */
public class SubstringConcatenationAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> indexes = new ArrayList<>();
        Map<String, Integer> wordMap = createWordMap(words);
        if (wordMap == null || wordMap.size() == 0) {
            return indexes;
        }
        int wordSize = wordMap.keySet().iterator().next().length();

        for (int i = 0; i < wordSize; i++) {
            int l = i;
            Map<String, Integer> counterMap = new HashMap<>();
            for (int r = i; r <= s.length() - wordSize; r += wordSize) {
                String word = s.substring(r, r + wordSize);
                if (wordMap.containsKey(word)) {
                    counterMap.put(word, counterMap.getOrDefault(word, 0) + 1);
                    while (counterMap.getOrDefault(word, 0) > wordMap.get(word)) {
                        String lWord = s.substring(l, l + wordSize);
                        counterMap.put(lWord, counterMap.getOrDefault(lWord, 1) - 1);
                        l += wordSize;
                    }
                } else {
                    counterMap.clear();
                    l = r + wordSize;
                }
                if(l + (words.length-1) * wordSize == r) {
                    indexes.add(l);
                }
            }
        }

        return indexes;
    }

    private Map<String, Integer> createWordMap(String[] words) {
        Map<String, Integer> wordMap = new HashMap<>();
        int wordSize = -1;
        for (String word : words) {
            if (wordSize < 0) {
                wordSize = word.length();
            } else if (wordSize != word.length()) {
                return null;
            }
            int count = wordMap.getOrDefault(word, 0);
            wordMap.put(word, count + 1);
        }
        return wordMap;
    }
}
