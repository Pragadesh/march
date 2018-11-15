package org.pg.march.geeksforgeeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://practice.geeksforgeeks.org/problems/jumping-numbers/0/
 * @author Pragadesh Gopalakrishnan
 */
public class JumpingNumbers {

    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            int totalTestcases = scanner.nextInt();
            while (totalTestcases-- > 0) {
                int inputValue = scanner.nextInt();
                List<Integer> result = getJumpingNumbers(inputValue);
                System.out.println(result.stream().map(s -> s.toString()).collect(Collectors.joining(" ")));
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
    
    public static List<Integer> getJumpingNumbers(int value){
        List<Integer> result = new ArrayList<>();
        result.add(0);
        for(int i=1; i<=9 ;i++) {
            if(shouldContinue(i, value, result)) {
                populateJumpingNumber(i, value, result);
            }
        }
        Collections.sort(result);
        return result;
    }

    
    public static void populateJumpingNumber(int index, int maxNumber, List<Integer> result) {
        int lastDigit = index % 10;
        if(lastDigit != 0) {
            int newIndex = (index*10) + (lastDigit - 1);
            if(shouldContinue(newIndex, maxNumber, result)) {
                populateJumpingNumber(newIndex, maxNumber, result);
            }
            
        }
        if(lastDigit != 9) {
            int newIndex = (index*10) + (lastDigit + 1);
            if(shouldContinue(newIndex, maxNumber, result)) {
                populateJumpingNumber(newIndex, maxNumber, result);
            }
        }
    }
    
    public static boolean shouldContinue(int newIndex, int maxNumber, List<Integer> result) {
        if(newIndex <= maxNumber) {
            result.add(newIndex);
            return (newIndex < maxNumber);
        }
        return false;
    }
    
}
