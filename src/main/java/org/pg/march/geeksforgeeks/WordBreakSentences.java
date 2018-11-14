package org.pg.march.geeksforgeeks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://practice.geeksforgeeks.org/problems/word-break-part-2/0/
 * @author Pragadesh Gopalakrishnan
 */
public class WordBreakSentences {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            int totalTestcases = scanner.nextInt();
            while (totalTestcases-- > 0) {
                int totalDictWords = scanner.nextInt();
                Set<String> dictWords = new HashSet<String>();
                while(totalDictWords-- > 0) {
                    dictWords.add(scanner.next());
                }
                String inputWord = scanner.next();
                List<String> result = recursiveSplit(0, inputWord, dictWords);
                if(result == null || result.isEmpty()) {
                    System.out.println("Empty");
                }else {
                    System.out.println(result.stream().map(s -> "(" + s + ")").collect(Collectors.joining("")));
                }
                
            } 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(scanner != null) {
                try {
                    scanner.close();
                }catch(Exception e) {}
            }
        }
    }
    
    public static List<String> recursiveSplit(int start, String inputWord, Set<String> dictWords) {
        List<String> result = new ArrayList<String>();
        for(int i=start; i < inputWord.length(); i++) {
            String currWord = inputWord.substring(start, i+1);
            if(dictWords.contains(currWord)) {
                if(i == inputWord.length()-1) {
                    result.add(currWord);
                    return result;
                }
                List<String> recursiveResult = recursiveSplit(i+1, inputWord, dictWords);
                if(recursiveResult != null && !recursiveResult.isEmpty()) {
                    result.addAll(recursiveResult.stream().map(s -> currWord + " " + s).collect(Collectors.toList()));
                }
            }
        }
        return result;
    }
}
