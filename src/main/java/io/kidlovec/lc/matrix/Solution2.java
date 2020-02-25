package io.kidlovec.lc.matrix;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author kidlovec
 * @date 2020-02-19
 * @since 1.0.0
 */
public class Solution2 {
    private static final String POOL_NAME = "custom-pool-%d";

    public int countNegatives(int[][] grid) {


        ExecutorService THREAD_POOL = new ThreadPoolExecutor(
                grid.length,
                grid.length,
                1,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100),
                new ThreadFactoryBuilder().setNameFormat(POOL_NAME).build());


        CountDownLatch countDownLatch = new CountDownLatch(grid.length - 1);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        AtomicInteger counter = new AtomicInteger(0);
        while (counter.get() < grid.length) {
            final int index = counter.get();
            System.out.println("counter : " + index);
            THREAD_POOL.execute(() -> {
                for (int j = 0; j < grid[index].length; j++) {
                    if (grid[index][j] < 0)
                        atomicInteger.incrementAndGet();
                }
                System.out.println("当前任务 "+ index + " ready!, 线程名称为：" + Thread.currentThread().getName());
                countDownLatch.countDown();
            });

            counter.getAndIncrement();
        }

        try {
            countDownLatch.await(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        for (AtomicInteger i) {
//            AtomicInteger atomicInteger = new AtomicInteger(0);
//
//        }
        THREAD_POOL.shutdown();

        return atomicInteger.get();
    }
    public static void main(String[] args) {
        Solution2 s = new Solution2();

        int x = 10;
        int y = 100000;
        long st = System.nanoTime();
        int[][] grid = generateData(x, y);
        long et = System.nanoTime();
        System.out.println(String.format("generate cost: %5d ns", (et - st)));
//        print(grid);

        st = System.nanoTime();
        int r = s.countNegatives(grid);
        et = System.nanoTime();

        System.out.println(String.format("compute cost: %5d ns", (et - st)));

        System.out.println("result = " + r);
    }

    private static void print(int[][] data) {

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");

            }
            System.out.println();

        }

    }
    private static int[][] generateData(int x , int y) {

        Random r = new Random(),r2 = new Random();

        int[][] grid = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int z = r2.nextInt(10);
                int flag = z < 3 ? -1 : 1;
                grid[i][j] = r.nextInt(100) * flag ;
            }
        }

        return grid;

    }
}
