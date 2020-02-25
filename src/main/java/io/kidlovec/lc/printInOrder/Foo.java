package io.kidlovec.lc.printInOrder;

import java.util.concurrent.CountDownLatch;

/**
 * @author kidlovec
 * @date 2020-01-03
 */
public class Foo {
    public Foo() {

    }

    private CountDownLatch one = new CountDownLatch(1);
    private CountDownLatch two = new CountDownLatch(1);

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        one.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        one.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        two.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        two.await();
        printThird.run();
    }
}
