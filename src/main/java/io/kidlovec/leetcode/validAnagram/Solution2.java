package io.kidlovec.leetcode.validAnagram;

import java.util.HashMap;
import java.util.Map;

/**
 * 242
 * 1. 排序
 * 2. 哈希表
 *
 * @author kidlovec
 * @date 2020-02-19
 * @since 1.0.0
 */
class Solution2 {
    public boolean isAnagram(String s, String t) {

        final Map<Character, Integer> m1 = toMap(s);
        final Map<Character, Integer> m2 = toMap(t);

        return m1.equals(m2);
    }

    private Map<Character, Integer> toMap(String s) {
        Map<Character, Integer> map1 = new HashMap<>();
        for( char c : s.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        return map1;
    }


    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        Solution2 ss = new Solution2();
        System.out.println(ss.isAnagram(s, t));
    }


}
