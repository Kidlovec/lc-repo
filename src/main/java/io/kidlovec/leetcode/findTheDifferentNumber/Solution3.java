package io.kidlovec.leetcode.findTheDifferentNumber;

/**
 * find-the-duplicate-number
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [3,1,3,4,2]
 * 输出: 3
 *
 * <p>
 * 说明：
 * <p>
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * 使用 二分查找的方法
 * <p>
 * 题中的数组 "数字都在 1 到 n 之间（包括 1 和 n）" 所以，指针在数字中游走不会越界。
 * 且 "可知至少存在一个重复的整数" 知道，数组成环。
 *
 * @author kidlovec
 * @date 2020-01-16
 */
public class Solution3 {

    public int findDuplicate(int[] nums) {

        int left = 1, right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2 ;
            int cnt = 0;

            for (int i = 0; i < nums.length ; i++) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }

            if (cnt <= mid) {

                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

    public static void main(String[] args) {

        int[] inputData = new int[]{1, 3, 4, 2, 2};

        Solution3 s = new Solution3();

        final int result = s.findDuplicate(inputData);
        System.out.println(result);
    }

}
