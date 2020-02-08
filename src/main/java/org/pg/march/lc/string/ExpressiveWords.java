package org.pg.march.lc.string;

/*
 * https://leetcode.com/problems/expressive-words/
 */
public class ExpressiveWords {

    public int expressiveWords(String S, String[] words) {

        int[][] meta = new int[S.length()][2];
        int len = 0;
        int prev = S.charAt(0);
        int matchLength = 1;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) != prev) {
                meta[len++] = new int[] { prev, matchLength };
                prev = S.charAt(i);
                matchLength = 1;
            } else {
                matchLength++;
            }
        }
        meta[len++] = new int[] { prev, matchLength };

        int count = 0;
        for(String word : words) {
            
            int i = 1;
            int j = 0;
            prev = word.charAt(0);
            matchLength = 1;
            while( i < word.length() && j < len) {
//                System.out.println(String.format("Processing: %c of %d with meta %c of %d ", 
//                        prev, matchLength, meta[j][0], meta[j][1]));
                if (word.charAt(i) != prev) {
                    if(prev != meta[j][0] || matchLength > meta[j][1] || (matchLength < meta[j][1] && meta[j][1] < 3)) {
                        break;
                    }
                    prev = word.charAt(i);
                    matchLength = 1;
                    j++;
                } else {
                    matchLength++;
                }
                i++;
            }
            if(i == word.length() && j == len - 1 && prev == meta[j][0] && (matchLength == meta[j][1] || (matchLength < meta[j][1] && meta[j][1] >=3))) {
                count++;
            }
        }
        return count;
    }
    
    
}
