package io.kidlovec.recursion;

/**
 * 矩阵求幂
 * <p>
 * 复杂度分析
 *
 * <pre>
 * 时间复杂度：O(logN)。
 * 空间复杂度：O(logN)，matrixPower 函数递归时堆栈使用的空间。
 * </pre>
 *
 * @author kidlovec
 * @date 2020-03-05
 * @since 1.0.0
 */
public class FibonacciArray5 {


    public Integer fib(int n) {

        if (n <= 1) {
            return n;
        }

        int[][] a = new int[][]{{1, 1}, {1, 0}};

        matrixPower(a, n - 1);

        return a[0][0];
    }

    private void matrixPower(int[][] a, int n) {
        if (n <= 1) {
            return;
        }

        matrixPower(a, n / 2);

        multiply(a, a);
    }

    private void multiply(int[][] a1, int[][] a2) {
        int x = a1[0][0] * a2[0][0] + a1[0][1] * a2[1][0];
        int y = a1[0][0] * a2[0][1] + a1[0][1] * a2[1][1];
        int z = a1[1][0] * a2[0][0] + a1[1][1] * a2[1][0];
        int w = a1[1][0] * a2[0][1] + a1[1][1] * a2[1][1];

        a1[0][0] = x;
        a1[0][1] = y;
        a1[1][0] = z;
        a1[1][1] = w;
    }

    public static void main(String[] args) {
        FibonacciArray5 f = new FibonacciArray5();

        // 1, 1, 2, 3, 5, 8,13, 21, 34
        System.out.println(f.fib(6));
    }
}
