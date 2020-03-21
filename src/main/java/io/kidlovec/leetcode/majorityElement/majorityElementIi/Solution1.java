package io.kidlovec.leetcode.majorityElement.majorityElementIi;

import java.util.*;

/**
 * 229. 求众数 II
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * <p>
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: [3]
 * 示例 2:
 * <p>
 * 输入: [1,1,1,3,3,2,2,2]
 * 输出: [1,2]
 * 通过次数12,523 | 提交次数29,376
 *
 * @author kidlovec
 * @date 2020-03-14
 * @since 1.0.0
 */
public class Solution1 {

    public List<Integer> majorityElement(int[] nums) {

        Map<Integer, Integer> counters = new HashMap<>(nums.length);

        for (int num : nums) {
            if (counters.containsKey(num)){
                counters.put(num, counters.get(num) + 1 );
            }
            counters.put(num, 1);
        }

        List<Integer> data = new LinkedList<>();

        for (Map.Entry<Integer, Integer> entry: counters.entrySet()){

//            if (entry.getValue() ==


        }




        return null;
    }
}
