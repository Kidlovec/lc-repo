package io.kidlovec.leetcode.threeSum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * No.15
 * <p>
 * 方法一
 * 三层循环
 * <p>
 * 去重
 *
 * @author kidlovec
 * @date 2020-02-25
 * @since 1.0.0
 */
public class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {

            for (int j = i + 1; j < nums.length - 1; j++) {

                for (int k = j + 1; k < nums.length; k++) {

                    if (i != j && k != j && nums[i] + nums[j] + nums[k] == 0) {

                        final LinkedList<Integer> integers = new LinkedList<>();
                        integers.add(nums[i]);
                        integers.add(nums[j]);
                        integers.add(nums[k]);

                        if (!res.contains(integers)) {

                            res.add(integers);
                        }
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] data = new int[]{-1, 0, 1, 2, -1, -4};

        Solution1 s = new Solution1();

        final List<List<Integer>> lists = s.threeSum(data);

        for (List<Integer> list : lists) {

            for (Integer item : list) {
                System.out.print(item);
                System.out.print(",");
            }
            System.out.println();
        }
    }
}
