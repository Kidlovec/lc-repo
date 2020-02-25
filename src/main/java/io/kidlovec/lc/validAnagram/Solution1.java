package io.kidlovec.lc.validAnagram;

/**
 * 242
 *
 * 1. 排序
 * 2. 哈希表
 * 3. 字符数组
 *
 * @author kidlovec
 * @date 2020-02-19
 * @since 1.0.0
 */
class Solution1 {
    public boolean isAnagram(String s, String t) {
        final String s1 = toSorted(s);
        final String s2 = toSorted(t);

        return s1.equals(s2);
    }

    private String toSorted(String s){
        final char[] sChars = s.toCharArray();
        qsort(sChars, 0, sChars.length - 1);
        return String.valueOf(sChars);
    }

    private static int charsPartition(char[] arr, int left, int right) {
        char beginNum = arr[left];
        int i = left, j = right;

        while (i != j) {
            while (arr[j] >= beginNum && i != j) {
                j--;
            }

            arr[i] = arr[j];

            while (arr[i] < beginNum && i != j) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = beginNum;
        return i;
    }

    /**
     * 字符串排序的快速排序算法
     * @param a
     * @param left
     * @param right
     */
    private static void qsort(char a[], int left, int right) {
        int p;
        if (left < right) {
            p = charsPartition(a, left, right);
            qsort(a, left, p - 1);
            qsort(a, p + 1, right);
        }
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        Solution1 ss = new Solution1();
        System.out.println(ss.isAnagram(s, t));
    }

}
