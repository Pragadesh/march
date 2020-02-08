package org.pg.march.lc.graph;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class ParallelCoursesTest {

	private ParallelCourses parallelCourses;

    @Before
    public void setup() {
        parallelCourses = new ParallelCourses();
    }

    @Test
    public void testcase1() {
        int[][] relations = new int[][] {
            {1,3},
            {2,3}};
        Assert.assertEquals(2, parallelCourses.minimumSemesters(3, relations));
    }
    
    @Test
    public void testcase2() {
        int[][] relations = new int[][] {
            {1,2},
            {2,3},
            {3,1}};
        Assert.assertEquals(-1, parallelCourses.minimumSemesters(3, relations));
    }
}
