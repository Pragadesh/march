package org.pg.march.lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

    public int numUniqueEmails(String[] emails) {
    	Set<String> validEmails = new HashSet<>();
        for(String email : emails) {
        	String[] address = email.split("@");
        	String local = address[0];
        	int firstPlus = local.indexOf('+', 0);
        	if(firstPlus > 0) {
        		local = local.substring(0, firstPlus);
        	}
        	local = local.replace(".", "");
        	validEmails.add(local+"@"+address[1]);
        }
        return validEmails.size();
    }
    
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> missingNumbers = new ArrayList<>();
		for(int i=0; i<nums.length; i++) {
			int val = Math.abs(nums[i]);
			nums[val-1] = -1 * Math.abs(nums[val-1]);
		}
		for(int i=0; i<nums.length; i++) {
			if(nums[i] > 0) {
				missingNumbers.add(i+1);
			}
		}
		return missingNumbers;
	}
	
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> duplicates = new ArrayList<>();
		int pivot = nums.length + 1;
		for(int i=0; i<nums.length; i++) {
			int val = nums[i] % pivot;
			nums[val-1] = nums[val-1] + pivot;
		}
		for(int i=0; i<nums.length; i++) {
			if(nums[i] / pivot == 2) {
				duplicates.add(i+1);
			}
		}
		return duplicates;
	}
	
	public boolean containsNearbyDuplicate1(int[] nums, int k) {
		for(int i=0; i < nums.length - 1; i++) {
			int maxIdx = Math.min(i + k + 1, nums.length);
			for(int j=i + 1; j<maxIdx; j++) {
				if(nums[i] == nums[j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> nearestMap = new HashMap<>();
		for(int i=0; i < nums.length; i++) {
			Integer prevIdx = nearestMap.remove(nums[i]);
			if(prevIdx != null && (i - prevIdx) <= k) {
				return true;
			}
			nearestMap.put(nums[i], i);
		}
		return false;
	}
	
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> nearestSet = new TreeSet<>();
        for(int i=0; i < nums.length; i++) {
        	int val = nums[i];
        	Integer lower = nearestSet.floor(val);
        	
        	if(lower != null) {
        		long diff = (long) val-lower;
        		if(Math.abs(diff) <= t) {
        			return true;
        		}
        	}
        	Integer upper = nearestSet.ceiling(val+1);
        	if (upper != null) {
        		long diff = (long)upper - val;
        		if(Math.abs(diff) <= t) {
        			return true;
        		}
        	}
        	if (nearestSet.size() >= k && i>=k) {
        		nearestSet.remove(nums[i-k]);
        	}
        	if (k > 0) {
        		nearestSet.add(nums[i]);
        	}
        }
        return false;
    }
    
    public int jump(int[] nums) {
        return 1;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	{
    		int[] nums = {1,2,3,1};
        	System.out.println(solution.containsNearbyAlmostDuplicate(nums, 3, 0));
    	}
    	{
    		int[] nums = {1,0,1,1};
        	System.out.println(solution.containsNearbyAlmostDuplicate(nums, 1, 2));
    	}
    	{
    		int[] nums = {1,5,9,1,5,9};
        	System.out.println(solution.containsNearbyAlmostDuplicate(nums, 2, 3));
    	}
    	
    	{
    		int[] nums = {1,2};
        	System.out.println(solution.containsNearbyAlmostDuplicate(nums, 0, 1));
    	}
    	{
    		int[] nums = {-1,2147483647};
    		System.out.println(solution.containsNearbyAlmostDuplicate(nums, 1, 2147483647));
    	}
    }
}
