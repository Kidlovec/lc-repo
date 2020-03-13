package io.kidlovec.recursion;

/**
 * 迭代
 * <p>
 * 复杂度分析
 *
 * <pre>
 * 时间复杂度：O(N)。
 * 空间复杂度：O(N)，使用了空间大小为 N 的数组。
 * </pre>
 *
 * @author kidlovec
 * @date 2020-03-05
 * @since 1.0.0
 */
public class FibonacciArray2 {

    public Integer fib(int n) {

        if (n <= 1) {
            return n;
        } else {
            return memoize(n);
        }
    }

    public int memoize(int n) {
        int[] cache = new int[n + 1];
        cache[1] = 1;

        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }

    public static void main(String[] args) {
        FibonacciArray2 f = new FibonacciArray2();

        // 1, 1, 2, 3, 5, 8,13, 21, 34
        System.out.println(f.fib(6));
    }
}
