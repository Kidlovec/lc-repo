package io.kidlovec.leetcode.twoSum;

/**
 * @author kidlovec
 * @date 2020-02-25
 * @since 1.0.0
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length - 1; i++) {

            for (int j = i + 1; j < nums.length ; j++) {
                if (i != j && nums[j] + nums[i] == target) {
                    return new int[]{i, j};
                }
            }

        }

        return null;
    }
}
