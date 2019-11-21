package org.pg.march.lc.string;

import java.util.LinkedList;

/*
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 */
public class RemoveAdjacentDuplicatesInString2 {

    public String removeDuplicates(String s, int k) {
        if (s == null || k <= 0) {
            return s;
        }
        LinkedList<Pair> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Pair lastPair = list.peekLast();
            if (lastPair == null || lastPair.value != c) {
                list.addLast(new Pair(c));
            } else if (lastPair.count < k - 1) {
                lastPair.increment();
            } else {
                list.removeLast();
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!list.isEmpty()) {
            Pair pair = list.removeFirst();
            int count = pair.count;
            while (count-- > 0) {
                builder.append(pair.value);
            }
        }
        return builder.toString();

    }

    private static class Pair {
        private Character value;
        private int count;

        public Pair(char c) {
            this.value = c;
            this.count = 1;
        }

        public void increment() {
            count++;
        }

    }

}
