package io.kidlovec.leetcode.groupAnagrams;

import java.util.*;

/**
 * 49
 *
 * hash map
 * @author kidlovec
 * @date 2020-02-19
 * @since 1.0.0
 */
public class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> result = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            boolean isExist = false;
            for (String s : result.keySet()) {
                if (isAnagram(strs[i], s)) {
                    isExist = true;
                    final List<String> integers = result.getOrDefault(s, new LinkedList<>());
                    integers.add(strs[i]);
                    result.put(s, integers);
                }
            }

            if (!isExist) {
                final LinkedList<String> l = new LinkedList<>();
                l.add(strs[i]);
                result.put(strs[i], l);
            }
        }

        return new ArrayList<>(result.values());
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

        Solution2 solution = new Solution2();

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
