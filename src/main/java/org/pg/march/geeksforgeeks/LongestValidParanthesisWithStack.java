package org.pg.march.geeksforgeeks;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://practice.geeksforgeeks.org/problems/longest-valid-parentheses/0/
 * @author Pragadesh Gopalakrishnan
 */
public class LongestValidParanthesisWithStack {
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
        char[] inputArr = inputWord.toCharArray();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i=0; i<inputArr.length; i++) {
            if(inputArr[i] == '(') {
                stack.push(i);
            }else {
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                }else {
                    result = Math.max(result, (i - stack.peek()));
                }
            }
        }
        return result;
    }
}
