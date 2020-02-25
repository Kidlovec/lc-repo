package io.kidlovec.lc.matrix;

import java.util.Random;

/**
 * @author kidlovec
 * @date 2020-02-19
 * @since 1.0.0
 */
public class Solution3 {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] line : grid) {
            for (int i = 0; i < line.length; i++) {
                if (line[i] < 0) {
                    count += line.length - i;
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();

        int x = 10;
        int y = 10000;
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
