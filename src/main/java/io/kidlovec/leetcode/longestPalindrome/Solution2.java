package io.kidlovec.leetcode.longestPalindrome;

import java.util.HashSet;
import java.util.Set;

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
 *
 * ---
 *
 * 这个是看到的一个网友写的思路。
 * 和打牌的思路一样，凑到一对就打掉加两分。
 * 最后还剩最后多余的牌, 那么还能再 加一分。
 *
 * 时间复杂度 O(n)
 * 空间复杂度 O(n)
 *
 * 执行用时 :
 * 11 ms, 在所有 Java 提交中击败了 19.94% 的用户
 * 内存消耗 :
 * 38.7 MB , 在所有 Java 提交中击败了 5.01% 的用户
 *
 *
 * </pre>
 *
 * @author kidlovec
 * @date 2020-03-21
 * @since 1.0.0
 */
public class Solution2 {
    public int longestPalindrome(String s) {

        final char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>(s.length());

        int counter = 0;
        for (char c : chars) {
            if (set.contains(c)) {
                counter += 2;
                set.remove(c);
            } else {
                set.add(c);
            }
        }

        counter += set.size() > 0 ? 1 : 0;

        return counter;
    }
}
