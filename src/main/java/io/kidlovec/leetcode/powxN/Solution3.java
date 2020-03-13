package io.kidlovec.leetcode.powxN;

/**
 * @author kidlovec
 * @date 2020-03-05
 * @since 1.0.0
 */
public class Solution3 {

    public double myPow(double x, int N) {
        long n = N;

        if (n < 0) {
            return 1 / myPow(x, (int) -n);
        }

        if (n == 0) {
            return 1;
        }

        if (n % 2 == 0) {
//            return myPow(x , n / 2) * myPow(x , n / 2) ;
            return x * myPow(x, (int)n - 1);
        } else {
//            return x * myPow(x , n / 2) * myPow(x , n / 2) ;
            return x * myPow(x * x, (int)n / 2);
        }
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();

        System.out.println(s.myPow(1, -2147483648));
    }
}
