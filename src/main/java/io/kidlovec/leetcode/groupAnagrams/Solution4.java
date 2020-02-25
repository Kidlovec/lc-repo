package io.kidlovec.leetcode.groupAnagrams;

import java.util.*;

/**
 * 49
 * <p>
 * hash map
 *
 * @author kidlovec
 * @date 2020-02-19
 * @since 1.0.0
 */
public class Solution4 {
    public List<List<String>> groupAnagrams(String[] strs) {

        int len = strs.length;

        Map<String,List<String>> map = new HashMap<>();

        for(int i=0;i<len; i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key= new String(chars);
            if(map.containsKey(key)){
                map.get(key).add(strs[i]);
            }else{
                ArrayList<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(key,list);
            }
        }

        return  new ArrayList<>(map.values());

    }

    public static void main(String[] args) {
        String[] inputArr = {"eat", "tea", "tan", "ate", "nat", "bat"};

        Solution4 solution = new Solution4();

        long st = System.nanoTime();
        final List<List<String>> lists = solution.groupAnagrams(inputArr);
        long et = System.nanoTime();

        System.out.println(String.format("cost: %5d ns", (et - st)));
        for (List<String> l : lists) {
            for (String s : l) {
                System.out.print(s + ", ");
            }
            System.out.println();
        }


    }
}
