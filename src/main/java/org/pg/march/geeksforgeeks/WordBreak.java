package org.pg.march.geeksforgeeks;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://practice.geeksforgeeks.org/problems/word-break/0
 * @author Pragadesh Gopalakrishnan
 */
public class WordBreak {

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
                System.out.println(recursiveSplit(0, inputWord, dictWords));
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
    
    public static int recursiveSplit(int start, String inputWord, Set<String> dictWords) {
        for(int i=start; i < inputWord.length(); i++) {
            String currWord = inputWord.substring(start, i+1);
            if(dictWords.contains(currWord)) {
                if(i == inputWord.length()-1) {
                    return 1;
                }
                if(recursiveSplit(i+1, inputWord, dictWords) == 1) {
                    return 1;
                }
            }
        }
        return 0;
    }
}
