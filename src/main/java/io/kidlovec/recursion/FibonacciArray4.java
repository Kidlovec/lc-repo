package io.kidlovec.recursion;

/**
 * 自底向上 迭代
 * <p>
 * 复杂度分析
 *
 * <pre>
 * 复杂度分析
 *
 * 时间复杂度：O(N)。
 * 空间复杂度：O(1)，仅仅使用了 current，prev1，prev2
 * </pre>
 *
 * @author kidlovec
 * @date 2020-03-05
 * @since 1.0.0
 */
public class FibonacciArray4 {


    public Integer fib(int n) {

        if (n <= 1) {
            return n;
        }

        if (n == 2) {
            return 1;
        }

        int current = 0;
        int prev1 = 1;
        int prev2 = 1;

        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return current;
    }

    public static void main(String[] args) {
        FibonacciArray4 f = new FibonacciArray4();

        // 1, 1, 2, 3, 5, 8,13, 21, 34
        System.out.println(f.fib(6));
    }
}
