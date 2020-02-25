package io.kidlovec.lc.groupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 49
 * <p>
 * hash map
 *
 * @author kidlovec
 * @date 2020-02-19
 * @since 1.0.0
 */
public class Solution3 {
    public List<List<String>> groupAnagrams(String[] strs) {

        //这是别人的一个解法，很牛逼，将26个字母换成26个质数。然后计算相乘
        //因为都是质数，所以只有异位的情况下结果才相等
        //但是这个方法有一个致命缺陷，如果字符串过长，就会超过long的储值范围。
        int[] table = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        HashMap<Long, List<String>> map = new HashMap<>();
        List<List<String>> ret = new ArrayList<List<String>>();


        for (String s : strs) {
            long sum = 1L;
            for (char c : s.toCharArray()) {
                sum *= table[c - 'a'];
            }

            List<String> list = map.get(sum);
            if (null == list) {
                list = new ArrayList<String>();
                list.add(s);
                map.put(sum, list);
                ret.add(list);
            } else {
                list.add(s);
            }
        }

        return ret;

    }

    public static void main(String[] args) {
        String[] inputArr = {"eat", "tea", "tan", "ate", "nat", "bat"};

        Solution3 solution = new Solution3();

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
