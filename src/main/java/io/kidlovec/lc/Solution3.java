package io.kidlovec.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * TODO description
 *
 * @author kidlovec
 * @date 2019-11-05
 * @since v1.0.0
 */
public class Solution3 implements Solution {
    @Override
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> l = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                if (nums[i] + nums[j] + nums[k] > 0 ) {
                    k--;
                    continue;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                    continue;
                } else if (nums[i] + nums[j] + nums[k] == 0) {
                    if (k != nums.length - 1 && nums[k] == nums[k + 1] ){
                        k--;
                        continue;
                    }

                    if (j != i + 1 && nums[j] == nums[j - 1]){
                        j ++;
                        continue;
                    }
                    List<Integer> integers = new ArrayList<>(3);
                    integers.add(nums[i]);
                    integers.add(nums[j]);
                    integers.add(nums[k]);
                    Collections.sort(integers);
                    if (l.contains(integers)) {
                    } else {
                        l.add(integers);
                    }
                    j++;
                }
            }
        }
        return l;
    }
}
