package io.kidlovec.al;

import java.util.Arrays;

/**
 * todo  description
 *
 * @author Fan Wenjie
 * @since 2021/8/27
 */
public class CountSort {

    /**
     * 中位数
     *
     * 计数排序 中位数
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] inputArray = new int[]{2,8,5,1,10,5,9,9,3,5,6,6,2,8,2};


        Arrays.sort(inputArray);


        for (int i : inputArray) {
            System.out.print(i + " ");
        }
        System.out.println();

    }


}
class CountSortSolution1{

    int max = 100;

    public int[] sort(int[] array){

        int[] t = new int[100];

        for (int i = 0; i < array.length; i++) {
            t[array[i]] ++;
        }

        return t;
    }
}
