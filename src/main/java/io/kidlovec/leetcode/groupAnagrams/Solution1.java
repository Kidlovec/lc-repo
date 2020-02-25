package io.kidlovec.leetcode.groupAnagrams;

import java.util.LinkedList;
import java.util.List;

/**
 * 49
 *
 * @author kidlovec
 * @date 2020-02-19
 * @since 1.0.0
 */
public class Solution1 {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new LinkedList<>();

        for (int i = 0; i < strs.length; i++) {
            boolean isExist = false;
            for (List<String> s : result) {
                if (isAnagram(strs[i], s.get(0))) {
                    isExist = true;

                    s.add(strs[i]);
                }
            }

            if (!isExist) {
                final LinkedList<String> strings = new LinkedList<>();
                strings.add(strs[i]);
                result.add(strings);
            }
        }

        return result;
    }

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;


        int[] map = new int[128];

        char[] sArray = s.toCharArray();
        for (char ch : sArray) {
            map[ch]++;
        }

        char[] tArray = t.toCharArray();
        for (char ch : tArray) {
            map[ch]--;
        }

        for (int n : map) {
            if (n != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] inputArr = {"eat", "tea", "tan", "ate", "nat", "bat"};

        Solution1 solution = new Solution1();

        long st = System.nanoTime();
        final List<List<String>> lists = solution.groupAnagrams(inputArr);
        long et = System.nanoTime();
        System.out.println("cost: " + (et - st) + " ns");

        for (List<String> l : lists) {
            for (String s : l) {
                System.out.print(s + ", ");
            }
            System.out.println();
        }


    }
}
