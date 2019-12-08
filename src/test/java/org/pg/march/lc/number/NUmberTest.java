package org.pg.march.lc.number;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.junit.Test;

public class NUmberTest {

	@Test
	public void testCurrency() {
		int AMOUNT_SCALE = 2;
		double totalPayment = 34.1;
		BigDecimal totalAmount = new BigDecimal(totalPayment);
		BigDecimal firstPayment = totalAmount.divide(BigDecimal.valueOf(4), AMOUNT_SCALE, RoundingMode.DOWN);
		
		BigDecimal lastPayment = new BigDecimal(totalPayment).subtract(firstPayment
				.multiply(BigDecimal.valueOf(3)));
		BigDecimal test = lastPayment.round(new MathContext(AMOUNT_SCALE+1, RoundingMode.DOWN));
		System.out.println("First: " + firstPayment);
		System.out.println("Last: " + lastPayment);
		System.out.println("Last2: " + test);
	}
	
	@Test
	public void testPrecision() {
		BigDecimal dec = new BigDecimal(20.1346655);
		System.out.println(dec.setScale(2, RoundingMode.DOWN));
		System.out.println(dec.setScale(3, RoundingMode.DOWN));
		System.out.println(dec.setScale(4, RoundingMode.DOWN));
		System.out.println(dec.setScale(5, RoundingMode.DOWN));
	}
}
