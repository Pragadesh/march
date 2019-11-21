package org.pg.march.lc.graph;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

import junit.framework.Assert;

public class WordLadderTest {

    private WordLadder wordLadder;

    @Before
    public void setup() {
        wordLadder = new WordLadder();
    }

    @Test
    public void testcase1() {
        List<String> wordList = Lists.newArrayList("hot", "dot", "dog", "lot", "log", "cog");
        Assert.assertEquals(5, wordLadder.ladderLength("hit", "cog", wordList));
    }
    
    @Test
    public void testcase2() {
        List<String> wordList = Lists.newArrayList("hot","dot","dog","lot","log");
        Assert.assertEquals(0, wordLadder.ladderLength("hit", "cog", wordList));
    }
}
