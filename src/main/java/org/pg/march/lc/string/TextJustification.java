package org.pg.march.lc.string;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/text-justification/
 */
public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> justifiedWords = new ArrayList<>();
        int len = 0;
        for (int start = 0, i = 0; i < words.length;) {

            while (i < words.length && len + words[i].length() <= maxWidth) {
                len += (words[i].length() + 1);
                i++;
            }
            int noOfWords = i - start;
            int extraSpaces = maxWidth - (len - 1);
            boolean lastLine = (i == words.length);
            if(noOfWords == 1) {
                StringBuilder builder = new StringBuilder(words[start]);
                appendSpace(builder, maxWidth - words[start].length());
                justifiedWords.add(builder.toString());
            }else {
                int minSpace = extraSpaces / (noOfWords - 1);
                int remainingSpace = extraSpaces - (noOfWords - 1) * minSpace;
                
                StringBuilder builder = new StringBuilder();
                for (int j = start; j < i - 1; j++) {
                    builder.append(words[j]);
                    int space = minSpace + 1 + (remainingSpace-- > 0? 1 : 0);
                    if(lastLine) {
                        space = 1;
                    }
                    appendSpace(builder, space);
                }
                builder.append(words[i-1]);
                if(lastLine) appendSpace(builder, maxWidth - builder.length());
                justifiedWords.add(builder.toString());
            }
            
            start = i;
            len = 0;
//            i--;
        }

        return justifiedWords;
    }

    private void appendSpace(StringBuilder builder, int noOfSpaces) {
        while (noOfSpaces-- > 0) {
            builder.append(" ");
        }
    }
}
