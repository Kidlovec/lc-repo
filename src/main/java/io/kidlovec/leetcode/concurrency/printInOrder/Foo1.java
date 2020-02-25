package io.kidlovec.leetcode.concurrency.printInOrder;

/**
 * 我们提供了一个类：
 * <pre>
 * public class Foo {
 *   public void one() { print("one"); }
 *   public void two() { print("two"); }
 *   public void three() { print("three"); }
 * }
 * </pre>
 * 三个不同的线程将会共用一个 Foo 实例。
 * <p>
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: "onetwothree"
 * 解释:
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 two() 方法，线程 C 将会调用 three() 方法。
 * 正确的输出是 "onetwothree"。
 * 示例 2:
 * <p>
 * 输入: [1,3,2]
 * 输出: "onetwothree"
 * 解释:
 * 输入 [1,3,2] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 three() 方法，线程 C 将会调用 two() 方法。
 * 正确的输出是 "onetwothree"。
 *  
 * <p>
 * 注意:
 * <p>
 * 尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。
 * <p>
 * 你看到的输入格式主要是为了确保测试的全面性。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-in-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 调试多线程的经验， 多线程的问题出现概率极其不稳定，需要大量尝试并查看小概率 case 并分析可能性，不能只看大概率
 *
 * @author kidlovec
 * @date 2020-01-20
 */
public class Foo1 {

    /**
     * 1. synchronized
     * 2. CountDownLatch
     * 3. Lock
     * 4. CyclicBarrier
     */
    public Foo1() {

    }

    private final Object lock = new Object();
    private volatile int flag = 1;

    public void first(Runnable printFirst) throws InterruptedException {

        synchronized (lock) {
            if (1 != flag) {

                lock.wait();
                lock.notify();
            }

            printFirst.run();
            flag = 2;
            lock.notify();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        synchronized (lock) {

            if (2 != flag) {
                lock.wait();
                lock.notify();
            }
            printSecond.run();
            flag = 3;
            lock.notify();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        synchronized (lock) {
            if (3 != flag) {

                lock.wait();
                lock.notify();
            }

            printThird.run();
            flag = 1;
            lock.notify();
        }
    }
}
