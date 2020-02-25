package io.kidlovec.leetcode.twoSum;

import java.util.*;

/**
 * @author kidlovec
 * @date 2020-02-25
 * @since 1.0.0
 */
public class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        // 避免扩容
        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for (int j = 0; j < nums.length; j++) {
            map.put(nums[j], j);
        }

        for (int i = 0; i < nums.length; i++) {
            int nextValue = target - nums[i];

            if (map.containsKey(nextValue)){
                int nextIndex = map.get(nextValue);
                // 去重
                if (i != nextIndex){

                    return new int[] {i, nextIndex};
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{3,3};

        Solution2 s = new Solution2();

        final int[] result = s.twoSum(ints, 6);

        if (result == null){
            System.out.println(" null ");
        } else {
            for (int i : result){
                System.out.print(i);
                System.out.print(" ");
            }
        }
    }
}
