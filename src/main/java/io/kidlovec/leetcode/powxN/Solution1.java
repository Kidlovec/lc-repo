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
public class Solution1 {
    public double myPow(double x, int n) {

        return Math.pow(x,n);
    }
}
