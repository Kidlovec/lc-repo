package io.kidlovec.leetcode.greatestCommonDivisorOfStrings;

/**
 * @author kidlovec
 * @date 2020-03-12
 * @since 1.0.0
 */
public class Solution1 {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";

        return str1.substring(0, getGreatestCommonDivisor(str1.length(), str2.length()));
    }


    /**
     * 求最大公约数
     *
     * 辗转相除法(欧几里德算法)
     *
     * 例如，求（319，377）：
     * ∵ 319÷377=0（余319）
     * ∴（319，377）=（377，319）；
     * ∵ 377÷319=1（余58）
     * ∴（377，319）=（319，58）；
     * ∵ 319÷58=5（余29）
     * ∴ （319，58）=（58，29）；
     * ∵ 58÷29=2（余0）
     * ∴ （58，29）= 29；
     * ∴（319，377）=29。 可以写成右边的格式。
     *
     * 用辗转相除法求几个数的最大公约数，
     * 可以先求出其中任意两个数的最大公约数，
     * 再求这个最大公约数与第三个数的最大公约数，
     * 依次求下去，直到最后一个数为止。
     *
     * 最后所得的那个最大公约数，就是所有这些数的最大公约数。
     *
     * @param m
     * @param n
     * @return
     */
    public static int getGCD(int m, int n) {
        int result = 0;
        while (n != 0) {
            result = m % n;
            m = n;
            n = result;
        }
        return m;

    }

    /**
     * 求两个数的最大公约数
     * <p>
     * [x] 更相减损法
     * [ ] 辗转相除法
     * [ ] 短除法
     * [ ] 质因数分解法
     *
     * @param m
     * @param n
     * @return
     */
    public static int getGreatestCommonDivisor(int m, int n) {
        while (m != n) {
            if (m > n)
                m -= n;
            else
                n -= m;
        }
        return m;
    }

    public static void main(String[] args) {

    }
}
