package org.pg.march.geeksforgeeks;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.pg.march.util.CollectionUtil;

import junit.framework.Assert;

import static org.pg.march.geeksforgeeks.WordBreakSentences.recursiveSplit;

public class WordBreakSentencesTest {

    @Test
    public void testCase1() {
        Set<String> dictWords = Stream.of("lr m lrm hcdar wk".split(" ")).collect(Collectors.toSet());
        List<String> output = recursiveSplit(0, "hcdarlrm", dictWords);
        System.out.println("Output: "+output);
        Assert.assertNotNull(output);
        Assert.assertEquals(2, output.size());
        Assert.assertTrue(CollectionUtil.containsAll(output, "hcdar lr m", "hcdar lrm"));
    }
    
    @Test
    public void testCase2() {
        Set<String> dictWords = Stream.of("snake","snakes","and","sand","ladder").collect(Collectors.toSet());
        List<String> output = recursiveSplit(0, "snakesandladder", dictWords);
        System.out.println("Output: "+output);
        Assert.assertNotNull(output);
        Assert.assertEquals(2, output.size());
        Assert.assertTrue(CollectionUtil.containsAll(output, "snakes and ladder", "snake sand ladder"));
    }
    
}
