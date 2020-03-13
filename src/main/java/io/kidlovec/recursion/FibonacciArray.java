package io.kidlovec.recursion;

/**
 * 复杂度分析
 * <pre>
 * 时间复杂度：O(2ᴺ)。这是计算斐波那契数最慢的方法。因为它需要指数的时间。
 * 空间复杂度：O(N)，在堆栈中我们需要与 N 成正比的空间大小。该堆栈跟踪 fib(N) 的函数调用，随着堆栈的不断增长如果没有足够的内存则会导致 StackOverflowError。
 * </pre>
 * <p>
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/fibonacci-number/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author kidlovec
 * @date 2020-03-05
 * @since 1.0.0
 */
public class FibonacciArray {

    public Integer fib(int n) {

        if (n <= 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static void main(String[] args) {
        FibonacciArray f = new FibonacciArray();

        // 1, 1, 2, 3, 5, 8,13, 21, 34
        System.out.println(f.fib(6));
    }
}
