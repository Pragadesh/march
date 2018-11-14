package org.pg.march.geeksforgeeks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/longest-valid-parentheses/0/
 * @author Pragadesh Gopalakrishnan
 */
public class LongestValidParanthesis {

    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            int totalTestcases = scanner.nextInt();
            while (totalTestcases-- > 0) {
                String inputWord = scanner.next();
                System.out.println(calculateLength(inputWord));
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

    public static int calculateLength(String inputWord) {
        int result = 0;
        if(inputWord != null) {
            int height = 0;
            Map<Integer, Integer> heightMaxLengthMap = new HashMap<>();
            Map<Integer, Integer> heightStartIndexMap = new HashMap<>();
            char[] inputArr = inputWord.toCharArray();
            for(int i=0; i<inputArr.length; i++) {
                char c = inputArr[i];
                if(c == '(') {
                    height++;
                    if(!heightStartIndexMap.containsKey(height)) {
                        heightStartIndexMap.put(height, i);
                    }
                }else if(c == ')') {
                    if(height > 0) {
                        Integer startIdx = heightStartIndexMap.get(height);
                        if(startIdx != null) {
                            Integer previousMaxLength = heightMaxLengthMap.get(height);
                            if(previousMaxLength == null || previousMaxLength < (i - startIdx))
                                heightMaxLengthMap.put(height, (i - startIdx)+1);
                        }
                        heightStartIndexMap.remove(height+1);
                        height--;
                    }else {
                        height = 0;
                        heightStartIndexMap.clear();
                    }
                }
            }
            for(Integer value : heightMaxLengthMap.values()) {
                if(value > result) {
                    result = value;
                }
            }
        }
        return result;
    }
}
