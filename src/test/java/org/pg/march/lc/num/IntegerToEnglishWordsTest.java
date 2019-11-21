package org.pg.march.lc.num;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class IntegerToEnglishWordsTest {

    private IntegerToEnglishWords integerToEnglishWords;

    @Before
    public void setup() {
        integerToEnglishWords = new IntegerToEnglishWords();
    }

    @Test
    public void testcase1() {
        Assert.assertEquals("One Hundred Twenty Three", integerToEnglishWords.numberToWords(123));
    }

    @Test
    public void testcase2() {
        Assert.assertEquals("Twelve Thousand Three Hundred Forty Five", integerToEnglishWords.numberToWords(12345));
    }

    @Test
    public void testcase3() {
        Assert.assertEquals("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven", 
                integerToEnglishWords.numberToWords(1234567));
    }

    @Test
    public void testcase4() {
        Assert.assertEquals("One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One",
                integerToEnglishWords.numberToWords(1234567891));
    }
}
