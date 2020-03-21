package io.kidlovec.leetcode.majorityElement;

/**
 * <pre>
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * 通过次数141,975|提交次数226,434
 *
 *
 * 分治法
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 *
 *
 * 执行用时 :
 * 17 ms, 在所有 Java 提交中击败了 33.63%的用户
 * 内存消耗 :
 * 46.9 MB , 在所有 Java 提交中击败了 5.07% 的用户
 *
 *
 * </pre>
 *
 * @author kidlovec
 * @date 2020-03-14
 * @since 1.0.0
 */
public class Solution4 {


    public int majorityElement(int[] nums) {

        return majorityElement(nums, 0, nums.length - 1);
    }

    private int majorityElement(int[] nums, int start, int end) {

        // base case
        if (start == end) {
            return nums[start];
        }

        int mid = (end - start) / 2 + start;
        int left = majorityElement(nums, start, mid);
        int right = majorityElement(nums, mid + 1, end);

        if (left == right) {
            return left;
        } else {

            int leftCnt = countInRange(nums, left, start, end);
            int rightCnt = countInRange(nums, right, start, end);

            return leftCnt > rightCnt ? leftCnt : rightCnt;
        }
    }

    private int countInRange(int[] nums, int num, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[] array = new int[]{2, 2, 1, 1, 1, 2, 2};

        Solution4 s = new Solution4();
        final int i = s.majorityElement(array);

        System.out.println(i);
    }
}
