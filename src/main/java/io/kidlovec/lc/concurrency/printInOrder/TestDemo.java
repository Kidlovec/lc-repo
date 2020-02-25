package io.kidlovec.lc.concurrency.printInOrder;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * TODO description
 *
 * @author kidlovec
 * @date 2020-01-20
 */
public class TestDemo {

    public static String[] pnc(int n) {
        int count = 0;
        String[] xx = new String[6];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (i != j && i != k && j != k) {

                        StringBuffer num = new StringBuffer();
                        num.append(i);
                        num.append(",");
                        num.append(j);
                        num.append(",");
                        num.append(k);

                        xx[count++] = num.toString();
                    }
                }
            }
        }


        return xx;
    }

    public static void main(String[] args) throws InterruptedException {
//        Foo foo = new Foo();

//        Foo1 foo = new Foo1();
//        Foo2 foo = new Foo2();
        Foo3 foo = new Foo3();
//        Foo4 foo = new Foo4();
//        Foo5 foo = new Foo5();

        final ThreadPoolExecutor pool = new ThreadPoolExecutor(10,
                20,
                1000,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(20));

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            String input = sc.nextLine();
            if (input.equals("exit")) {
                pool.shutdown();
                break;
            }
            final String[] pnc = pnc(3);
            Random r = new Random();

            final int i = r.nextInt(5);
            System.err.println(pnc[i]);
            String[] inputArr = pnc[i].split(",");


//            String[] inputArr = "1,3,2".split(",");

            for (String str : inputArr) {

                switch (str) {
                    case "1":
                        pool.execute(() -> {
                            try {
                                foo.first(() -> System.out.println("one"));
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        });
                        break;
                    case "2":
                        pool.execute(() -> {
                            try {
                                foo.second(() -> System.out.println("two"));
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        });
                        break;

                    case "3":
                        pool.execute(() -> {
                            try {
                                foo.third(() -> System.out.println("three"));
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        });
                        break;
                    default:
                        break;
                }

//            Thread.sleep(1);
            }

            System.out.println("===============================================");
            System.out.println("===============================================");
            System.out.println("===============================================");
            System.out.println("===============================================");
            System.out.println("===============================================");
        }
    }
}
