package io.kidlovec.leetcode.partitionArrayIntoThreePartsWithEqualSum;


/**
 * @author kidlovec
 * @date 2020-03-11
 * @since 1.0.0
 */
public class Solution1 {
    public boolean canThreePartsEqualSum(int[] A) {

        int len = A.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += A[i];
        }
        if (sum % 3 != 0) {
            return false;
        }
        int subSum = sum / 3;
        int left = 1, leftSum = A[0], right = len - 2, rightSum = A[len - 1];
        while (leftSum != subSum && left < len) {
            leftSum += A[left];
            left++;
        }
        while (rightSum != subSum && right >= 0) {
            rightSum += A[right];
            right--;
        }
        return left <= right;
    }



    public static void main(String[] args) {
        int[] arr;
////        arr = new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
////        arr = new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1};
////        arr = new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4};
//        arr = new int[]{18, 12, -18, 18, -19, -1, 10, 10};
//
//        Solution1 s = new Solution1();
//        System.out.println();
//        System.out.println(s.canThreePartsEqualSum(arr));
//        System.out.println();

        arr = new int[]{18,12,-18,18,-19,-1,10,10};

        int sum = 0;

        for (int a : arr){
            sum += a;
        }

        System.out.println(sum);
    }
}
