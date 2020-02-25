package io.kidlovec.lc;

import java.util.*;

/**
 * @author kidlovec
 * @date 2018-12-24
 * @description 15. 3Sum
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {0,0,0,0,-1, -1, 0, 1, 2, -1, -4};

        Solution solution = new Solution3();

        final List<List<Integer>> lists = solution.threeSum(nums);

        final Iterator<List<Integer>> iterator = lists.iterator();


        while (iterator.hasNext()) {
            StringBuffer sb = new StringBuffer();
            final List<Integer> next = iterator.next();

            final Iterator<Integer> iterator1 = next.iterator();
            while (iterator1.hasNext()) {
                sb.append(",");
                sb.append(iterator1.next());
            }
            sb.append("]");
            System.out.println(sb.toString().replaceFirst(",", "["));
        }

        System.out.println();
    }


}

interface Solution {

    List<List<Integer>> threeSum(int[] nums);
}

/**
 * solution 1
 * O(n^3)
 */
class Solution1 implements Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> arrays = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> integers = new ArrayList<>();
                        integers.add(nums[i]);
                        integers.add(nums[j]);
                        integers.add(nums[k]);
                        Collections.sort(integers);
                        if (arrays.indexOf(integers) < 0){
                            arrays.add(integers);
                        }
                    }
                }
            }
        }

        return arrays;
    }
}

class Solution2 implements Solution {

    @Override
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> arrays = new ArrayList<>();
        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                int a = nums[i] + nums[j];
                if (set.contains(-a)){

                    List<Integer> integers = new ArrayList<>();
                    integers.add(nums[i]);
                    integers.add(nums[j]);
                    integers.add(-a);
                    Collections.sort(integers);
                    if (arrays.indexOf(integers) < 0){
                        arrays.add(integers);
                    }
                }
            }
        }

        return arrays;
    }
}





