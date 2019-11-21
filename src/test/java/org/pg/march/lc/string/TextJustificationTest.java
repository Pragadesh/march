package org.pg.march.lc.string;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.pg.march.util.CollectionUtilTest;

import com.google.common.collect.Lists;

public class TextJustificationTest {

    private TextJustification textJustification;

    @Before
    public void setup() {
        textJustification = new TextJustification();
    }

    @Test
    public void testcase1() {
        String[] words = new String[] { "This", "is", "an", "example", "of", "text", "justification." };
        List<String> justifiedWords = textJustification.fullJustify(words, 16);
        List<String> expected = Lists.newArrayList("This    is    an", "example  of text", "justification.  ");
        System.out.println(justifiedWords);
        CollectionUtilTest.assertIgnoreOrderList(expected, justifiedWords);
    }

    @Test
    public void testcase2() {
        String[] words = new String[] { "What", "must", "be", "acknowledgment", "shall", "be" };
        List<String> justifiedWords = textJustification.fullJustify(words, 16);
        List<String> expected = Lists.newArrayList("What   must   be", "acknowledgment  ", "shall be        ");
        System.out.println(justifiedWords);
        CollectionUtilTest.assertIgnoreOrderList(expected, justifiedWords);
    }

    @Test
    public void testcase3() {
        String[] words = new String[] { "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is",
                "everything", "else", "we", "do" };
        List<String> justifiedWords = textJustification.fullJustify(words, 20);
        List<String> expected = Lists.newArrayList("Science  is  what we", "understand      well", "enough to explain to", "a  computer.  Art is",
                "everything  else  we", "do                  ");
        System.out.println(justifiedWords);
        CollectionUtilTest.assertIgnoreOrderList(expected, justifiedWords);
    }
}
