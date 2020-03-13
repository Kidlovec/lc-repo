package io.kidlovec.recursion;

/**
 * @author kidlovec
 * @date 2020-03-05
 * @since 1.0.0
 */
public class Factorial {

    public int factorial(int n) {
        if (n <= 1) {
            // 递归终止条件 recursion terminator
            return 1;
        } else {
            // 处理逻辑 process logic && 下层处理 drill down
            // reverse the current level status if needed
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        Factorial f = new Factorial();

        // = 5 * 4 * 3* 2* 1
        final int factorial = f.factorial(5);

        System.out.println(factorial);
    }
}
