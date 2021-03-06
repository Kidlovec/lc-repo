package io.kidlovec.leetcode.concurrency.printFoobarAlternately;

/**
 * 我们提供一个类：
 *
 * <pre>
 * class FooBar {
 *   public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 *   }
 *
 *   public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 *   }
 * }
 * </pre>
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 * <p>
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 * <p>
 *  
 * <p>
 * 示例 1:
 *
 * <pre>
 * 输入: n = 1
 * 输出: "foobar"
 * 解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
 * </pre>
 * 示例 2:
 * <p>
 * <pre>
 * 输入: n = 2
 * 输出: "foobarfoobar"
 * 解释: "foobar" 将被输出两次。
 * </pre>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-foobar-alternately
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author kidlovec
 * @date 2020-01-21
 */
public class FooBar3 {

    private int n;

    public FooBar3(int n) {
        this.n = n;
    }

    private volatile boolean nextFoo = true;

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            if (nextFoo) {
                printFoo.run();
                nextFoo = false;

            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            if (!nextFoo) {
                printBar.run();
                nextFoo = true;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FooBar3 fooBar = new FooBar3(5);

        Thread t = new Thread() {

            @Override
            public void run() {
                System.out.println("foo");
            }
        };

        t.setName("thread-foo");

        Thread t2 = new Thread() {

            @Override
            public void run() {
                System.out.println("bar");
            }
        };
        t2.setName("thread-bar");


        new Thread(() -> {
            try {
                fooBar.foo(t);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        new Thread(() -> {
            try {
                fooBar.bar(t2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread.sleep(10);
    }

}