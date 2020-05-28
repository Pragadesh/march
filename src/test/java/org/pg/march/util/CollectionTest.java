package org.pg.march.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

public class CollectionTest {

	@Test
	public void testGenericAssignment() {
		int[] nums1 = {0,1,2,2,4,5,6,7,8,9,10};
		System.out.println(Arrays.binarySearch(nums1, 0, 11, 3));
		
		int[] nums2 = {0,1,2,4,4,5,6,7,8,9,10};
        System.out.println(Arrays.binarySearch(nums2, 0, 11, 3));
	}
	
	
	@Test
    public void testConcurrentMap() {
	    System.out.println("Java: " + getVersion());
	    ConcurrentHashMap<UUID, String> map = new ConcurrentHashMap<>();
	    UUID key1 = UUID.randomUUID();
	    map.put(key1, "value1");
	    map.get(key1);
	    map.get(null);
	}
	
	private static int getVersion() {
	    String version = System.getProperty("java.version");
	    if(version.startsWith("1.")) {
	        version = version.substring(2, 3);
	    } else {
	        int dot = version.indexOf(".");
	        if(dot != -1) { version = version.substring(0, dot); }
	    } return Integer.parseInt(version);
	}
}
