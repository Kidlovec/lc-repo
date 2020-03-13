package io.kidlovec.leetcode.partitionArrayIntoThreePartsWithEqualSum;


/**
 * 1013
 *
 * @author kidlovec
 * @date 2020-03-11
 * @since 1.0.0
 */
public class Solution {
    public boolean canThreePartsEqualSum(int[] A) {

        int len = A.length;

//        int counter = 0;

        int partOne = 0;
        int partTwo = 0;
        int partThree = 0;

        for (int i = 0; i < len; i++) {
            partTwo += A[i];
        }

        if ((partOne + partTwo + partThree) % 3 != 0)
            return false;

        int mark = (partOne + partTwo + partThree) / 3;

        int i = 0, j = len - 1;

        for (; i + 1 < j; ) {

//            sprintln(A, i, j, counter);

            if (partOne != mark) {

                partOne += A[i];
                partTwo -= A[i];
                i++;

            }

            if (partThree != mark) {

                partTwo -= A[j];
                partThree += A[j];
                j--;
            }
            if (partOne == partTwo && partTwo == partThree)
                return true;

//            counter++;
        }

//        sprintln(A, i, j, counter);
        if (partOne == partTwo && partTwo == partThree)
            return true;

        return false;
    }

    private void sprintln(int[] a, int i, int j, int counter) {

        System.out.println("======  " + counter + " =======");

        for (int k = 0; k < a.length; k++) {

            if (k == i) {
                System.out.println();
            }
            System.out.print(a[k]);
            System.out.print(", ");
            if (k == j) {
                System.out.println();
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr;
//        arr = new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
//        arr = new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1};
//        arr = new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4};
//        arr = new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4};
//        arr = new int[]{18, 12, -18, 18, -19, -1, 10, 10};
        arr = new int[]{1, -1,1,-1};

        Solution s = new Solution();
        System.out.println();
        System.out.println(s.canThreePartsEqualSum(arr));
        System.out.println();
    }
}
