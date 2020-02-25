package io.kidlovec.lc.findTheDifferentNumber;

/**
 * find-the-duplicate-number
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [3,1,3,4,2]
 * 输出: 3
 *
 * <p>
 * 说明：
 * <p>
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * 使用 快慢指针的方法
 * <p>
 * 题中的数组 "数字都在 1 到 n 之间（包括 1 和 n）" 所以，指针在数字中游走不会越界。
 * 且 "可知至少存在一个重复的整数" 知道，数组成环。
 *
 *
 * <p>使用数组配合下标，抽象成链表问题。</p>
 * 举个例子：nums = [2, 5, 9, 6, 9, 3, 8, 9, 7, 1]，
 * nums[i];
 * nums[nums[i]]
 * <p>
 * 构造成链表就是：2->[9]->1->5->3->6->8->7->[9]，也就是在[9]处循环。
 *
 * @author kidlovec
 * @date 2020-01-16
 */
public class Solution2 {

    public int findDuplicate(int[] nums) {

        int fast = 0, slow = 0;

        while (true) {

            fast = nums[nums[fast]];
            slow = nums[slow];

            if (fast == slow) {

                fast = 0;
                while (fast != slow) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return fast;

            }
        }
    }

    public static void main(String[] args) {

        int[] inputData = new int[]{1, 3, 4, 2, 2};

        Solution2 s = new Solution2();

        final int result = s.findDuplicate(inputData);
        System.out.println(result);
    }

}
