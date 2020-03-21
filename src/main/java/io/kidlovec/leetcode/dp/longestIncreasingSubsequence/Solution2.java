package io.kidlovec.leetcode.dp.longestIncreasingSubsequence;

/**
 *
 * 动态规划 + 二分查找
 *
 * @author kidlovec
 * @date 2020-03-14
 * @since 1.0.0
 */
public class Solution2 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int counter = 0;
        for (int num : nums) {
            int i = 0, j = counter;
            while (i < j) {
                int m = (i + j) / 2;
                if (dp[m] < num) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }

            dp[i] = num;

            if (counter == j) {
                counter++;
            }
        }
        return counter;
    }
    public static void main(String[] args) {
//
        int[] array;
//        array = new int[]{10, 9, 2, 5, 3, 7, 101, 18, 20};
        array = new int[]{0};
//
        Solution2 s = new Solution2();
//
        final int i = s.lengthOfLIS(array);

//        int[] a = new int[]{2,3,7,101};
//
//        final int i = s.find(a, a.length, 18);
        System.out.println(i);
//        System.out.println(a[i]);

    }
}
