package io.kidlovec.leetcode.dp.longestIncreasingSubsequence;

import java.util.Arrays;

/**
 * <pre>
 *     300. 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * 通过次数55,718 | 提交次数125,868
 *
 * 动态规划 + 二分查找
 *
 * 执行用时 :
 * 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗 :
 * 38 MB, 在所有 Java 提交中击败了 5.05% 的用户
 *
 * </pre>
 *
 * @author kidlovec
 * @date 2020-03-14
 * @since 1.0.0
 */
public class Solution1 {
    public int lengthOfLIS(int[] nums) {

        final int len = nums.length;
        if (len == 0){
            return 0;
        }
        int[] dp = new int[len];

        int counter = 0;
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {

            if (dp[counter] < nums[i]) {
                dp[++counter] = nums[i];
            } else {
//                dp[++counter] = nums[i];
                int position = Arrays.binarySearch(dp, 0, counter, nums[i]);

                if (position < 0){
                    position = 0;
                }
                dp[position] = nums[i];
            }

            System.out.println("======== Round:" + i + " ========");
            for (int ii = 0; ii <= counter; ii++) {
                System.out.print(dp[ii] + " ");
            }
            System.out.println();
            System.out.println("========  result  ========");
        }

        for (int i = 0; i <= counter; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
        System.out.println("========  result  ========");

        return counter + 1;
    }

    private int find(int[] dp, int j, int num) {

        int i = 0;
        while (i < j) {
            int m = (i + j) / 2;
            if (dp[m] < num) {
                i = m + 1;
            } else {
                j = m;
            }
        }

        return j;
    }


    public static void main(String[] args) {
//
        int[] array;
                array = new int[]{10, 9, 2, 5, 3, 7, 101, 18, 20};
//        array = new int[]{0};
        Solution1 s = new Solution1();
//
        final int i = s.lengthOfLIS(array);
//


//        int[] a = new int[]{2,3,7,101};
//
//        final int i = s.find(a, a.length, 18);
        System.out.println(i);
//        System.out.println(a[i]);

    }
}
