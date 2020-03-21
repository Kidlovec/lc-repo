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
 * Boyer-Moore 摩尔投票算法
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
 * 复杂度分析
 *
 * 时间复杂度：O(n)。Boyer-Moore 算法只对数组进行了一次遍历。
 *
 * 空间复杂度：O(1)。Boyer-Moore 算法只需要常数级别的额外空间。
 *
 *
 * </pre>
 *
 * @author kidlovec
 * @date 2020-03-14
 * @since 1.0.0
 */
public class Solution3 {

    public int majorityElement(int[] nums) {

        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0){
                candidate = num;
            }

            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }


    public static void main(String[] args) {
        int[] array = new int[]{2, 2, 1, 1, 1, 2, 2};

        Solution3 s = new Solution3();
        final int i = s.majorityElement(array);

        System.out.println(i);
    }
}
