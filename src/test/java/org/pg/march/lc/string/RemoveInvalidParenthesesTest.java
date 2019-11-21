package org.pg.march.lc.string;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.pg.march.util.CollectionUtilTest;

import com.google.common.collect.Lists;

public class RemoveInvalidParenthesesTest {

    private RemoveInvalidParentheses removeInvalidParentheses;

    @Before
    public void setup() {
        removeInvalidParentheses = new RemoveInvalidParentheses();
    }

    @Test
    public void testcase1() {
        List<String> invalidParanthesis = removeInvalidParentheses.removeInvalidParentheses("()())()");
        List<String> expected = Lists.newArrayList("()()()", "(())()");
        CollectionUtilTest.assertIgnoreOrderList(expected, invalidParanthesis);
    }
    
    @Test
    public void testcase2() {
        List<String> invalidParanthesis = removeInvalidParentheses.removeInvalidParentheses("(a)())()");
        List<String> expected = Lists.newArrayList("(a)()()", "(a())()");
        CollectionUtilTest.assertIgnoreOrderList(expected, invalidParanthesis);
    }
    
    @Test
    public void testcase3() {
        List<String> invalidParanthesis = removeInvalidParentheses.removeInvalidParentheses(")(");
        List<String> expected = Lists.newArrayList("");
        CollectionUtilTest.assertIgnoreOrderList(expected, invalidParanthesis);
    }
}
