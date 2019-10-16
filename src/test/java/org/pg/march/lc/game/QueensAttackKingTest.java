package org.pg.march.lc.game;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.pg.march.util.CollectionUtilTest;

import com.google.common.collect.Lists;

public class QueensAttackKingTest {

    
    private QueensAttackKing queensAttackKing;

    @Before
    public void setup() {
        queensAttackKing = new QueensAttackKing();
    }

    @Test
    public void testcase1() {
        int[][] queens = new int[][] { { 0, 1 }, { 1, 0 }, { 4, 0 }, { 0, 4 }, { 3, 3 }, { 2, 4 } };
        int[] king = new int[] { 0, 0 };
        List<List<Integer>> attacks = queensAttackKing.queensAttacktheKing(queens, king);
        List<List<Integer>> expectedList = Lists.newArrayList();
        expectedList.add(Lists.newArrayList(0, 1));
        expectedList.add(Lists.newArrayList(1, 0));
        expectedList.add(Lists.newArrayList(3, 3));
        CollectionUtilTest.assertIgnoreOrderListOfList(expectedList, attacks);
    }
}
