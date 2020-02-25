package io.kidlovec.leetcode.validAnagram;

/**
 * 242
 *
 * @author kidlovec
 * @date 2020-02-19
 * @since 1.0.0
 */
class Solution3 {
    public boolean isAnagram(String s, String t) {

        int[] map = new int[26];
        char[] sArray = s.toCharArray();
        for (char ch : sArray) {
            map[ch - 97]++;
        }
        char[] tArray = t.toCharArray();
        for (char ch : tArray) {
            map[ch - 97]--;
        }
        for (int n : map) {
            if (n != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        Solution3 ss = new Solution3();
        System.out.println(ss.isAnagram(s, t));
    }

}
