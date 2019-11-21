package org.pg.march.lc.num;

/*
 * https://leetcode.com/problems/integer-to-english-words/
 */
public class IntegerToEnglishWords {

    private static final String[] digitConversionMap;
    
    static {
        digitConversionMap = new String[100];
        digitConversionMap[1] = "One";
        digitConversionMap[2] = "Two";
        digitConversionMap[3] = "Three";
        digitConversionMap[4] = "Four";
        digitConversionMap[5] = "Five";
        digitConversionMap[6] = "Six";
        digitConversionMap[7] = "Seven";
        digitConversionMap[8] = "Eight";
        digitConversionMap[9] = "Nine";
        digitConversionMap[10] = "Ten";
        digitConversionMap[11] = "Eleven";
        digitConversionMap[12] = "Twelve";
        digitConversionMap[13] = "Thirteen";
        digitConversionMap[14] = "Fourteen";
        digitConversionMap[15] = "Fifteen";
        digitConversionMap[16] = "Sixteen";
        digitConversionMap[17] = "Seventeen";
        digitConversionMap[18] = "Eighteen";
        digitConversionMap[19] = "Nineteen";
        digitConversionMap[20] = "Twenty";
        digitConversionMap[30] = "Thirty";
        digitConversionMap[40] = "Forty";
        digitConversionMap[50] = "Fifty";
        digitConversionMap[60] = "Sixty";
        digitConversionMap[70] = "Seventy";
        digitConversionMap[80] = "Eighty";
        digitConversionMap[90] = "Ninety";
    }
    
    public String numberToWords(int num) {
        if(num == 0) {
            return "Zero";
        }
        StringBuilder builder = new StringBuilder();
        String number = Integer.toString(num);
        int length = number.length();
        
        for (int i = 0; i < number.length();) {
            int endIndex = i + 1 + ((length - 1 - i) % 3);
            int triplet = Integer.parseInt(number.substring(i, endIndex));
            if(triplet > 0) {
                builder.append(threeDigit(triplet));
                String level = getLevel((length - 1 - i) / 3);
                if(level != null) {
                    builder.append(" ").append(level).append(" ");
                }
            }
            i = endIndex;
        }
        return builder.toString().trim();
    }
    
    private String threeDigit(int num) {
        int hundreds = num / 100;
        int twoDigits = num % 100;
        String val = "";
        if(hundreds > 0) {
            val = digitConversionMap[hundreds] + " Hundred" + (twoDigits > 0? " " : "");
        }
        if(twoDigits > 0) {
            val += twoDigit(twoDigits);
        }
        return val;
    }
    
    private String twoDigit(int num) {
        int onesDigit = num % 10;
        if (onesDigit == 0 || digitConversionMap[num] != null) {
            return digitConversionMap[num];
        }
        return digitConversionMap[num / 10 * 10] + " " + digitConversionMap[onesDigit];
    }
    
    private String getLevel(int level) {
        if(level == 1) {
            return "Thousand";
        }else if (level == 2) {
            return "Million";
        }else if(level == 3) {
            return "Billion";
        }
        return null;
    }
}
