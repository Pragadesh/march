package org.pg.march.lc.num;

/*
 * https://leetcode.com/problems/ugly-number-iii/
 */
public class UglyNumber3 {

    public int nthUglyNumber(int n, int a, int b, int c) {

        long ab = ((long)a * b) / gcd(a, b);
        long bc = ((long)b * c) / gcd(b, c);
        long ac = ((long)a * c) / gcd(a, c);
        long abc = a * bc / gcd(a, bc);

        int low = 1;
        int high = Integer.MAX_VALUE;

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count =  (int) (mid / a + mid / b + mid / c - mid / ab - mid / bc - mid / ac + mid / abc);
            if (count < n) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return high;
    }

    private long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
