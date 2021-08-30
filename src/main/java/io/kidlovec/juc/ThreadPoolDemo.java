package io.kidlovec.juc;


import java.util.concurrent.*;

/**
 * todo  description
 *
 * @author Fan Wenjie
 * @since 2021/8/29
 */
public class ThreadPoolDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int size = 100;
        ExecutorService e = new ThreadPoolExecutor(5,
                10,
                60,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(size - 10));

        for (int i = 0; i < size; i++) {
            final int integer = i;
            Future<?> data = e.submit(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.out.println("No." + String.format("%2d", integer) + " . [" + Thread.currentThread().getName() + "]");
                System.out.println("No." + String.format("%2d", integer) + " . " + e);
            });

            data.get();
        }
        int loop = size / 2;
        while (loop > 0) {
            try {
                TimeUnit.MILLISECONDS.sleep(500);

                System.out.println();
                System.out.println(e.toString());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            loop--;
        }

    }


}
