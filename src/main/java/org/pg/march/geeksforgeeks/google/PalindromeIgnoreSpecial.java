package org.pg.march.geeksforgeeks.google;

import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/save-ironman/0
 * @author Pragadesh Gopalakrishnan
 */
public class PalindromeIgnoreSpecial {

    public static final String NO = "NO";
    public static final String YES = "YES";
    
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            int totalTestcases = scanner.nextInt();
            scanner.nextLine();
            while (totalTestcases-- > 0) {
                String inputWord = scanner.nextLine();
                System.out.println(isPalindrome(inputWord));
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
    
    
    public static String isPalindrome(String inputWord) {
        if(inputWord == null) {
            return NO;
        }
        char[] input = inputWord.toCharArray();
        int i=0, j=input.length-1;
        while(i<j) {
            while(i<j && !isAlphabetOrNumeric(input[i])) {
                i++;
            }
            while(i<j && !isAlphabetOrNumeric(input[j])) {
                j--;
            }
            if(i<j) {
                if(!compareIgnoreCase(input[i], input[j])) {
//                    System.out.println(String.format("Mismatch between index %d[%s] and index %d[%s].", i, input[i], j, input[j]));
                    return NO;
                }
                i++; j--;
            }
        }
        return YES;
    }
    
    public static boolean isAlphabetOrNumeric(char c) {
        return ((c >= 65 && c <= 90) || (c >= 97 && c <= 122) || (c >= 48 && c <= 57)); 
    }
    
    public static boolean compareIgnoreCase(char c1, char c2) {
        if(c1 != c2) {
            if(c1 >= 65 && c1 <= 90) {
                return (c1+32 == c2);
            }else if(c1 >= 97 && c1 <= 122) {
                return (c1-32 == c2);
            }
            return false;
        }
        return true;
    }
}
