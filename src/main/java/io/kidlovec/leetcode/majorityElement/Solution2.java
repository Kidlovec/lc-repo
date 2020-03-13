package io.kidlovec.leetcode.majorityElement;

import java.util.HashMap;
import java.util.Map;

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
 * 哈希表
 *
 * 时间复杂度: O(nlogⁿ)
 * 空间复杂度: O(logⁿ)
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
public class Solution2 {


    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length / 2);

        for (int i = 0; i < nums.length; i++) {
            int data = nums[i];
            if (map.containsKey(data)) {
                map.put(data, map.get(data) + 1);
            } else {
                map.put(data, 1);
            }
        }

        int data = 0;
        int counter = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > counter) {
                counter = e.getValue();
                data = e.getKey();
            }
        }
        return data;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 2, 1, 1, 1, 2, 2};

        Solution2 s = new Solution2();
        final int i = s.majorityElement(array);

        System.out.println(i);
    }
}
