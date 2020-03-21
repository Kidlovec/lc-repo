package io.kidlovec.leetcode.majorityElement;

import java.util.Arrays;

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
 * 排序然后拿第 n/2 个元素
 *
 * 时间复杂度: O(nlogⁿ)
 * 空间复杂度: O(logⁿ)
 *
 * 如果使用语言自带的排序算法，需要使用 O(logⁿ) 的栈空间。如果自己编写堆排序，则只需要使用 O(1) 的额外空间。
 *
 *  执行用时 :
 * 2 ms, 在所有 Java 提交中击败了 85.34% 的用户
 * 内存消耗 :
 * 42.1 MB , 在所有 Java 提交中击败了 33.08% 的用户
 *
 * </pre>
 *
 * @author kidlovec
 * @date 2020-03-14
 * @since 1.0.0
 */
public class Solution1 {

    public int majorityElement(int[] nums) {

        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 2, 1, 1, 1, 2, 2};

        Solution1 s = new Solution1();
        final int i = s.majorityElement(array);

        System.out.println(i);
    }
}
