package io.kidlovec.leetcode.dp.longestIncreasingSubsequence;

/**
 * 动态规划 + 二分查找
 *
 * @author kidlovec
 * @date 2020-03-14
 * @since 1.0.0
 */
public class Solution3 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = getdp(nums);
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; ++i) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public int[] getdp(int[] arr) {
        int left = 0;
        int r = 0;
        int right = 0;

        int m = 0;

        int len = arr.length;

        int[] dp = new int[len];
        int[] ends = new int[len];

        ends[0] = arr[0];
        dp[0] = 1;
        for (int i = 0; i < len; ++i) {
            left = 0;
            r = right;
            while (left <= r) {
                m = (left + r) / 2;
                if (arr[i] > ends[m]) {
                    left = m + 1;
                } else {
                    r = m - 1;
                }
            }
            right = Math.max(left, right);
            ends[left] = arr[i];
            dp[i] = left + 1;
        }
        return dp;
    }

    public static void main(String[] args) {
//
        int[] array;
//        array = new int[]{10, 9, 2, 5, 3, 7, 101, 18, 20};
        array = new int[]{0};
//
        Solution3 s = new Solution3();
//
        final int i = s.lengthOfLIS(array);

//        int[] a = new int[]{2,3,7,101};
//
//        final int i = s.find(a, a.length, 18);
        System.out.println(i);
//        System.out.println(a[i]);

    }
}
