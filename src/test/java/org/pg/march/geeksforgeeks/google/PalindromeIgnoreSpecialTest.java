package org.pg.march.geeksforgeeks.google;

import static org.pg.march.geeksforgeeks.google.PalindromeIgnoreSpecial.isPalindrome;
import static org.pg.march.geeksforgeeks.google.PalindromeIgnoreSpecial.YES;

import org.junit.Test;

import junit.framework.Assert;

public class PalindromeIgnoreSpecialTest {
    
    @Test
    public void testcase1() {
        Assert.assertEquals(YES, isPalindrome("Ab?/Ba"));
        Assert.assertEquals(YES, isPalindrome("I am :IronnorI Ma, i"));
        Assert.assertEquals(YES, isPalindrome("I am :IronnorI Ma, i"));
    }
}
