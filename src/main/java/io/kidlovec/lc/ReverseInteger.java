package io.kidlovec.lc;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *<ul>示例 1:
 *
 * <li>输入: 123</li>
 * <li>输出: 321</li>
 *  示例 2:
 *
 * <li>输入: -123</li>
 * <li>输出: -321</li>
 * 示例 3:
 *
 * <li><输入: 120</li>
 * <li>输出: 21</li>
 * </ul>
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer

 * @author kidlovec
 * @date 2019-10-25
 * @since v1.0.0
 */
public class ReverseInteger {

    public static void main(String[] args) {

        Solution s = new Solution();
        int reversed = 0;

        reversed = s.reverse(12345);

//        if (reversed == 54321) {
//            System.out.println("passed!");
//        } else {
//            System.out.println("not passed!");
//        }

        reversed = s.reverse(123456);

        if (reversed == 654321) {
            System.out.println("passed!");
        } else {
            System.out.println("not passed!");
        }
    }

    static class Solution {

        private Solution() {

        }

        int reverse(int x) {
            int y = 0;

            return trans2Array(x);
        }

        private int trans2Array(int x) {

            int size = 10;

            String s = String.valueOf(x);

            int length = s.length();

            char[] yArray = new char[length];

            int i = length;
            int i1 = length / 2;
            while (i > i1) {
                yArray[i - 1] = s.charAt(length - i);
                yArray[length - i] = s.charAt(i - 1);
                i--;
            }

            System.out.println(yArray);

            return Integer.parseInt(String.valueOf(yArray));
        }
    }
}

