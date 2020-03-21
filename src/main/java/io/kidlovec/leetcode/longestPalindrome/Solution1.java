package io.kidlovec.leetcode.longestPalindrome;

/**
 * <pre>
 *  409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * 通过次数38,255提交次数70,230
 * 在真实的面试中遇到过这道题？
 *
 *  -------
 *
 *  执行用时 :
 *  1 ms , 在所有 Java 提交中击败了 100.00% 的用户
 *  内存消耗 :
 *  37.6 MB , 在所有 Java 提交中击败了 5.01% 的用户
 *
 * </pre>
 *
 * @author kidlovec
 * @date 2020-03-21
 * @since 1.0.0
 */
public class Solution1 {
    public int longestPalindrome(String s) {

        final char[] chars = s.toCharArray();
        int[] array = new int[54];

        for (char c : chars) {

            if (c >= 'a') {
                array[c - 'a']++;
            } else {
                array[c - 'A' + 28]++;
            }
        }

        int counter = 0;

        for (int i = 0; i < 54; i++) {
            counter += array[i] - array[i] % 2;

        }

        counter += (counter != s.length()) ? 1 : 0;
        return counter;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();

        final int count = s.longestPalindrome("aaaAaaaa");

        System.out.println(count);
    }
}
