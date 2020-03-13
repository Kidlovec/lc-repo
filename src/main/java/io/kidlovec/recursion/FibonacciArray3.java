package io.kidlovec.recursion;

/**
 * 记忆化自顶向下的方法
 *
 * <p>
 * 复杂度分析
 *
 * <pre>
 * 复杂度分析
 *
 * 时间复杂度：O(N)。
 * 空间复杂度：O(N)，内存中使用的堆栈大小。
 * </pre>
 *
 * @author kidlovec
 * @date 2020-03-05
 * @since 1.0.0
 */
public class FibonacciArray3 {

    private Integer[] cache = new Integer[31];

    public Integer fib(int n) {

        if (n <= 1) {
            return n;
        }

        cache[0] = 1;
        cache[1] = 1;
        return memoize(n);
    }

    public int memoize(int n) {
        if (cache[n] != null) {

            return cache[n];
        }

        cache[n] = memoize(n - 1) + memoize(n - 2);
        return memoize(n);
    }

    public static void main(String[] args) {
        FibonacciArray3 f = new FibonacciArray3();

        // 1, 1, 2, 3, 5, 8,13, 21, 34
        System.out.println(f.fib(6));
    }
}
