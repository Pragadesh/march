package org.pg.march.lc.num;

public class HappyNumber {

    public boolean isHappy(int n) {
        int slow, fast;
        slow = fast = n;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
        } while (slow != fast);
        return (slow == 1);
    }

    private int digitSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int tmp = n % 10;
            sum += (tmp * tmp);
            n = n / 10;
        }
        return sum;
    }
}
