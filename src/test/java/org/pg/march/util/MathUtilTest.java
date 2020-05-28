package org.pg.march.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

public class MathUtilTest {

	private MathUtil mathUtil;

	@Before
	public void setup() {
		mathUtil = new MathUtil();
	}

	@Test
	public void testcase1() {
		double totalCart = 39.97;
		calculateAmount(totalCart);
	}

	@Test
	public void testcase2() {
		double totalCart = 131.99;
		calculateAmount(totalCart);
	}

	public boolean isEven(int s) {
		return s % 2 == 0;
	}

	
	@Test
	public void testcase3() {
		double totalCart = 51.97;
		calculateAmount(totalCart);
//		BigDecimal bd = BigDecimal.valueOf(totalCart);
//		BigDecimal dd = bd.divide(BigDecimal.valueOf(4)).setScale(2, RoundingMode.HALF_UP);
//		System.out.println(bd.divide(BigDecimal.valueOf(4)));
//		System.out.println(dd);
//		
//		
//		System.out.println(BigDecimal.valueOf(19.99444).setScale(2, RoundingMode.HALF_UP));
//		System.out.println(BigDecimal.valueOf(19.99445).setScale(2, RoundingMode.HALF_UP));
//		System.out.println(BigDecimal.valueOf(19.995).setScale(2, RoundingMode.HALF_UP));
//		System.out.println(BigDecimal.valueOf(19.9945).setScale(2, RoundingMode.HALF_UP));
	}
	
	@Test
	public void testcase4() {
		int target = 2;
		int res = Integer.MIN_VALUE;
//		int[] nums = {3, -5, 2, 6, -1};
		int[] nums = {1,2,3,0,4,5};
		int[] sum = new int[nums.length];
		TreeSet<Integer> set = new TreeSet<>();
		
		int val = 0;
		set.add(val);
		for(int i=0; i<nums.length; i++) {
			
			val += nums[i];
			sum[i] = val;
			Integer subres = set.ceiling(val - target);
            if(null!=subres){
                res=Math.max(res,val-subres);
            }
            System.out.println("Res : " + res);
            set.add(val);
		}
	}
	
	@Test
	public void testcase6() {
		int target = 15;
		int res = Integer.MIN_VALUE;
//		int[] nums = {3, -5, 2, 6, -1};
		int[] nums = {1,2,3,4,5};
		TreeSet<Integer> set = new TreeSet<>();
		
		int val = 0;
		set.add(val);
		for(int i=0; i<nums.length; i++) {
			
			val += nums[i];
			Integer subres = set.ceiling(val - target);
            if(null!=subres){
                res=Math.max(res,val-subres);
            }
            System.out.println("Res : " + res);
            set.add(val);
		}
	}
	
	private void calculateAmount(double totalCart) {
//		BigDecimal tCart = BigDecimal.valueOf(totalCart).setScale(2, RoundingMode.HALF_UP);
		BigDecimal tCart = BigDecimal.valueOf(totalCart);
		BigDecimal fPayment = tCart.divide(BigDecimal.valueOf(4)).setScale(2, RoundingMode.HALF_UP);
//		BigDecimal fPayment = tCart.divide(BigDecimal.valueOf(4)).setScale(2, RoundingMode.HALF_UP);
		BigDecimal lPayment = fPayment.add(tCart.subtract(fPayment.multiply(BigDecimal.valueOf(4)))).setScale(2, RoundingMode.HALF_UP);
		System.out.println("Total cart: " + totalCart);
		System.out.println("First 3 Payment: " + fPayment);
		System.out.println("Last Payment: " + lPayment);
		System.out.println("*************************");
	}
}
