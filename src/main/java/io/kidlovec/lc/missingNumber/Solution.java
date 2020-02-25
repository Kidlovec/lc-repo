package io.kidlovec.lc.missingNumber;

/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author kidlovec
 * @date 2020-01-17
 */
public class Solution {

    /**
     * 时间复杂度 O(n) 空间复杂度O(n)
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {

        int[] array = new int[nums.length];

        for (int num : nums) {
            if (num >= 0 && num < nums.length) {
                array[num]++;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0)
                return i;

        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] inputData = new int[]{3, 0, 1, Integer.MAX_VALUE};
        test(inputData);
        System.out.println("---- ---- --- ");
        inputData = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1, Integer.MAX_VALUE};
        test(inputData);
    }

    private static void test(int[] inputData) {


        Solution s = new Solution();

        final int result = s.missingNumber(inputData);
        System.out.println(result);
    }
}
