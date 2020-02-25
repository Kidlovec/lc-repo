package io.kidlovec.leetcode.missingNumber;

import java.util.LinkedList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * <p>
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * <p>
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * 输出:
 * [5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author kidlovec
 * @date 2020-01-17
 */
public class Solution3 {

    /**
     * 时间复杂度 O(n) 空间复杂度O(n)
     * <p>
     * 不使用额外空间 且 时间复杂度为O(n)的情况下完成
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> list = new LinkedList<>();
        final int length = nums.length;

        if (length == 0) return list;

        for (int i = 0; i < length; i++) {
            final int index = Math.abs(nums[i]);
            if (index <= length && nums[index - 1] > 0)
                nums[index - 1] *= -1;
        }

        for (int i = 0; i < length; i++) {
            if (nums[i] > 0 )
                list.add(i + 1);
        }

        return list;
    }

    public static void main(String[] args) {

        int[] inputData = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        test(inputData);
        System.out.println("---- ---- --- ");
        inputData = new int[]{9, 6, 4, 2, 3, 5, 7,  1, Integer.MAX_VALUE};
        test(inputData);

        System.out.println("---- ---- --- ");
        inputData = new int[]{1, 1};
        test(inputData);

        System.out.println("---- ---- --- ");
        inputData = new int[]{};
        test(inputData);

        System.out.println("---- ---- --- ");
        inputData = new int[]{2, 2};
        test(inputData);
    }

    private static void test(int[] inputData) {


        Solution3 s = new Solution3();

        final List<Integer> result = s.findDisappearedNumbers(inputData);
        System.out.println(result);
    }
}
