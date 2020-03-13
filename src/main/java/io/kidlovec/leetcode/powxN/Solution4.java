package io.kidlovec.leetcode.powxN;

/**
 * 1. Math.pow O(1)
 * 2. for 循环 O(n)
 * 3. 分治法 + 递归 O(logn)
 * 4. 折半 n
 *
 * @author kidlovec
 * @date 2020-03-05
 * @since 1.0.0
 */
public class Solution4 {
    public double myPow(double x, int N) {
        long n = N;
        if (n < 0) {
            x = 1 / x;
            n *= -1;
        }

        double pow = 1;

        while (n > 0) {

            if (n % 2 == 1) {
                pow *= x;
            }

            x *= x;
            n >>= 1;
        }

        return pow;
    }

    public static void main(String[] args) {
        Solution4 s = new Solution4();

        final double v = s.myPow(2, -2147483648);
        System.out.println(v);
    }
}
