package io.kidlovec.lc.firstMissingPositive;

/**
 * @author kidlovec
 * @date 2020-01-16
 */
public class Solution {

    public int firstMissingPositive(int[] nums) {

        int len = nums.length;

        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i])
                swap(nums, nums[i] - 1, i);
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // 都正确则返回数组长度 + 1
        return len + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {

        int[] inputData = new int[]{1, 2, 0, Integer.MAX_VALUE};

        Solution s = new Solution();

        final int result = s.firstMissingPositive(inputData);
        System.out.println(result);
    }

}
