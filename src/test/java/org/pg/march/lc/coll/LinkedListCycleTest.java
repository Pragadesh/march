package org.pg.march.lc.coll;

import org.junit.Before;
import org.junit.Test;
import org.pg.march.lc.coll.LinkedListCycle.ListNode;

import junit.framework.Assert;

public class LinkedListCycleTest {

    private LinkedListCycle linkedListCycle;

    @Before
    public void setup() {
        linkedListCycle = new LinkedListCycle();
    }

    @Test
    public void testcase1() {
        int[] nums = {3,2,0,-4};
        int loopPos = 1;
        NodeCreator nodeCreator = new NodeCreator(nums, loopPos);
        Assert.assertEquals(nodeCreator.loopNode, linkedListCycle.detectCycle(nodeCreator.head));
        Assert.assertEquals(true, linkedListCycle.hasCycle(nodeCreator.head));
    }
    
    @Test
    public void testcase2() {
        int[] nums = {1,2};
        int loopPos = 0;
        NodeCreator nodeCreator = new NodeCreator(nums, loopPos);
        Assert.assertEquals(nodeCreator.loopNode, linkedListCycle.detectCycle(nodeCreator.head));
        Assert.assertEquals(true, linkedListCycle.hasCycle(nodeCreator.head));
    }
    
    @Test
    public void testcase3() {
        int[] nums = {1};
        int loopPos = -1;
        NodeCreator nodeCreator = new NodeCreator(nums, loopPos);
        Assert.assertEquals(nodeCreator.loopNode, linkedListCycle.detectCycle(nodeCreator.head));
        Assert.assertEquals(false, linkedListCycle.hasCycle(nodeCreator.head));
    }
    
    private class NodeCreator{
        int[] nums;
        int loopPos = -1;
        
        ListNode head;
        ListNode loopNode;
        
        public NodeCreator(int[] nums, int loopPos) {
            this.nums = nums;
            this.loopPos = loopPos;
            init();
        }
        
        private void init() {
            head = new ListNode(nums[0]);
            if(loopPos == 0) {
                loopNode = head;
            }
            ListNode prev = head;
            for(int i=1; i< nums.length; i++) {
                ListNode curr = new ListNode(nums[i]);
                prev.next = curr;
                if(loopPos == i) {
                    loopNode = curr;
                }
                prev = curr;
            }
            prev.next = loopNode;
        }
        
    }
}
