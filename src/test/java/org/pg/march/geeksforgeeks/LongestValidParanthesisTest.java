package org.pg.march.geeksforgeeks;

import static org.pg.march.geeksforgeeks.LongestValidParanthesis.calculateLength;

import org.junit.Test;

import junit.framework.Assert;

public class LongestValidParanthesisTest {

    @Test
    public void testCase1() {
        Assert.assertEquals(4, calculateLength(")(()()(()"));
        Assert.assertEquals(2, calculateLength("()(()"));
        Assert.assertEquals(6, calculateLength("()(((()())"));
        
        Assert.assertEquals(2, calculateLength("((()"));
        Assert.assertEquals(4, calculateLength(")()())"));
        Assert.assertEquals(6, calculateLength(")(())())"));
        Assert.assertEquals(4, calculateLength(")(()))())"));
        Assert.assertEquals(1974, calculateLength("))))()))()))))(())())())())))))))()(()(()(()()(((((()((()())())(())()()))()()()()()((()())()((()()((((()(((()))(()))()((()()(())()()()))()())((((())(()))()()()((())))(())())))(())(()((()()((())()))()))(())((((())())()((())())(()(()()(())))()))())))(((())())))(())))())())(()(()()((()()(())((((((()))())(())()((())(()))))(()()())())))(()()))((())))(((())(((()())()())(())))(())()()()()))(())(()))))())())(()()()())))))((()())())(()(()))()()((()(())()()))))())))()(()(())()()))()))))())()))())))(()))()(((((()()()))))(()()(()()()))()()((((()())()(()))()(())(())(()(()))((())(())))))))(())))))()()(())))()))()(((()()())()))())))(((((()((()()()(((((()))))())(()))((()))()((())(())())()()((()(()()(()()))(()())()((())))((((()()))()(()()()())()()(()(((())))())(())))))()(()))((()(((()(()(()()((((((()())(()))()()()))))(())((()))(())))(()(()()))(()((())((())))((()((())(())))(((()(()()()(()(())(())))(())()())))(()))))((())((()())(()(((())(()))())((()))((()()))()))((()((()((()))(()((()))())(()(()(()))()()(()()))(((()(())))))()())()()))(()())(())())))))))))(()((((((())(()))))(()(()(((()()(()))((()))(()())(((()))()()))(((()))(()(((()(())))))))()(()()))())(()(((()()())())()))(((())(((((((())(())(()))))(((()))(()()))(((((()(()))())((()))))()((((((()())))())()()((()((()())((()()((((()()))))()()()))()(()))(((()(())((((((((((()(())(((()()(()()(())((()))((((())())((((())))()(()()))))))))(()(((())((((((()()()(()())())(()))(()((()()()(()(())))())))()(()))()()(((()))()())(())()))()())()((()))(()(()())(((((())(()))()))()))))(((((((()(()))))((((()())()(()()()()(()))())()()()(()(())(((()((((())()))))()(()(((())))((()))(((((())(()))(()((())())(())())(()))())(((())))(((())()())(()()(())(()))(()(())((((()()))())()))()())()))(()()((()))(()()))(())))())())(()(()))())()()())((((((((())))(()())()))(())(())()()(()))))))))(()()(())())))()(()()(((((())()()))(()((())()()())))()()(()()))((())(())()(((()(((()((())())))((((()(())()))()((((()))())())()((()()))(()()((()())()))))(()((()))(()()((((()(((((())())((())))()())()))(((()(()))))()()))))))(()(((((()(()()(()((()))())())))()(((())(((((()))()())(()())())()))(())))()(()(()())(((()()()))))))(())(())))(()(()))())())())(((())()(()((()((()))(()())(())((())()))((())(((()((((()(()(())(()())()()()))()((()))(())(()((()()))()()(()(()())(()())(((())))))))))()(()))(()(((()()()(())()))))))()())))((()))))))))(((()(())())())(()))((()(()(()))(()))())((()((()((()))))((()(()())(()((())()())))(()(())))))((()()((()))(())))())))((())()))(()((()))()())()())()()))))(()()()()())((()(()))))((()(()()(())))()(()()(()(()())(()()((()())())))()))))))(())((()())))()(())())())))())(())(((())())()()(()()())())))()(()()())(((((()()))()()))))(((())((()(((()))((()(((()((()()((((()())))(()(())()()()((()(()))(((())(())))()))()(()))(())))))(())))(()(()(((()())())))())()(()(()(((())(()))))()((()()))((()())((())()(())(())(())(())()()))))(((((((())(((())))()(()(((()()))()((())()()()))))())))()())))))))((()()))())()))(()(((((((()))))(()())))())())(((()()))((((((()())))))))))()()()()(()()(()()((()())()(((()())(((())()()(((())()((((()))(())(((()(((()()(())(()()()(())(()((())((()()((()(()))()(()(())()()(()))()((((())))()(())((((()()))())())(()))))()(((((())))((((())))))((((()((((())))())())))()))))))((())((()))())(((((((((((((()((()()))((()))))()()(()))()))()(((()(()()(()((()()()((())())))((()((())((()()(()())((((()(((()))))(()((()()())(()())(((()()((())((((())((()(((((((()(((())((((())((((((()()(((()()))((((()()()))((((())())(())(()(()))()()))(())))(()(()))()))()())))))()))(())))(((()(()(()()(()(()(())()(()(((()))(((()))))(()))))())))(((()))()))((()(()()(((((())())))(()((((((()((()()()()((((()(()(()))(()(((())()(((((()))(()))()(()))()()(()()()()())()))(())))(()(()(()))(())(())))()(())))))(((()()(((())())(()(()()(()(())((())))(((()))))(())())()()(()()))))))()))))()))))(((()()))(()(()((())()(())())()()()()((())()((())(((())())()()))()()()()()))((()()())))))()(()((()()())))))()(((((((((((()))))(()))())()())((()()()(())))())())())(())(()())()(()((((((()()(()()))())))())((())((()((()())())))))(()((((())))(())((()((())())(())))(()())((())(())))((((())(((((()()))))((()))())())()())()))(((()(())))(()()(())))())))()))()(()()(()())()))())(()(())))))()))((())(()())())))(()())())(())()()(()())))())()))((((()()))))()(())(())()(())()))()(()(()(()((()(())())(((((()((((()))()()()))(()()(()()()())))))())())))(()))))()())))((()(()((()()))))((((((()(()(()))())()()(()(()))((((())((())())()((((((()())())()()(())))))(())(())((()(()()(((()()())()((())((((()))))((())((((((((()()))))(((())(()()(()()))((())(((((()()()())((()()())())(()((()))(())()(()()()))())(()()(()))))()(()((()(())()())(())()()))(())()(((((())(((()))(()())(((())()((()))(((())())()())(()))(()())))(())))())(()()))))((((())()(()((((()()))(())(()(()()()())(((())(((((((())()()())(()))()))(()()((())((((()))(()())())(()()(()()(()()()())()()())()((()()))))))((()()))(()()))(((())))())))()()()())()())(((())(()(()(()()((())(()())((()))()))())))(())()())((((((())))))()))())()(((()()((()))(((())())(((()(()))(((()()()(()))())((()))(())))))((((()()))()())()()(((()))(()(()((()()()()))))(()()()))()()))()()()))()(()()()(((())()(((())))(()(())(()())))((())()))()(()))(()())(((()(((()))())(())())()))()(()()())))(())(()()()())(()()((()()))())()(())())()))))())))(((())()(())(((()))))))))))))))()))))((()(()()((((((((()(()()())())((()(((()((()))()(())))()(())((())((()(())))))))(()((()))()()()))))()(()(((()()())((((()()(((()(()()()))(((()(())))(((()())()))()(((()((())))())()(()((((()((((()))))(())())()))(((()()))(()))()())(((((((())()(())(()(((((((())())))()((((((())()())()))((()()())))()()()()(()(()()(()((()(()(()(()()))))(((()(()()((())))()()()(((((((()(()()((()()(()(())))()))((((((())(()(((()()(()(()()())((()))())(()()()((())()())()(()))))())((()((()()(()())()))((((((())))((()))())((())()(((())))))())()))()))()))(()))((()())())(())())())))())()())((()())()))())(((()(()()(()())((()()()(()())))((())()((()())((())))()))(()(()())()((()(()(((())(())())))))((()()))()))())()(())))))())()))(())(()(((()(((()(("));
    }
}
