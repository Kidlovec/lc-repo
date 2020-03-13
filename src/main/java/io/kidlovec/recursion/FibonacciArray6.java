package io.kidlovec.recursion;

/**
 * 公式法
 * <p>
 * 使用黄金分割率计算第 N 个斐波那契数。
 *
 * <pre>
 * 时间复杂度：O(1)。常数的时间复杂度，因为我们是基于 Binet 公式进行计算，没有使用循环或递归。
 * 空间复杂度：O(1)，存储黄金分割率所使用的空间。
 *
 *
 * </pre>
 *
 * @author kidlovec
 * @date 2020-03-05
 * @since 1.0.0
 */
public class FibonacciArray6 {


    public Integer fib(int n) {

        return 0;
    }

    public static void main(String[] args) {
        FibonacciArray6 f = new FibonacciArray6();

        // 1, 1, 2, 3, 5, 8,13, 21, 34
        System.out.println(f.fib(6));
    }
}
