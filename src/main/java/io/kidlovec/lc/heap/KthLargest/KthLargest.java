package io.kidlovec.lc.heap.KthLargest;

/**
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 * <p>
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。
 * <p>
 * 每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 * <p>
 * 示例:
 * <pre>
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);  // returns 4
 * kthLargest.add(5);  // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);  // returns 8
 * kthLargest.add(4);  // returns 8
 * </pre>
 * <p>
 * 说明:
 * <blockquote>你可以假设 nums 的长度≥ k-1 且k ≥ 1。</blockquote>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author kidlovec
 * @date 2020-01-18
 */
public class KthLargest {

    private int size = 0;
    private int[] data;

    /**
     * 求最大 所以是小顶堆。 最小的在最前面，每次把最小的换出来。
     *
     * 内部数组实现  O(k)
     *
     * @param k
     * @param nums
     */
    public KthLargest(int k, int[] nums) {
        data = new int[k];

        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int add(int val) {

        // 从 位置 0 开始比较，找到比 val 大的位置
        int i = 0;
        for (i = 0; i < size; i++) {
            if (val < data[i]) {
                break;
            }
        }

        if (data.length != size) {

            // 如果比 所有位置 的元素 大，则放到最后的位置上

            if (i > size - 1) {
                data[size] = val;
            } else {
                // 否则 从 位置 i 往后的所有的元素 往后移一位
                // 再将 val 放入到 位置 i

                for (int j = size; j > i; j--) {
                    data[j] = data[j - 1];
                }
                data[i] = val;
            }
            // 空间数量 + 1
            size++;
        } else {
            //  如果比 0 小则不操作, 将val 弹出。

            if (i == 0) return data[i];

            for (int j = 0; j < i - 1; j++) {
                data[j] = data[j + 1];
            }
            data[i - 1] = val;

            // 如果 比 0 大 则依次比较，找到比自己大的位置 n， 如没有比自己大的，则找到 n = k ，
            // 然后将 0 排除 ， 1 ~ n - 1 的位置 全部往前移一位，然后放入到 n - 1 的位置。
        }

        return data[0];
    }

    private void print(int[] data) {
        for (int i : data)
            System.out.print(i + " ");
        System.out.println();
    }

    /**
     * 执行用时 :
     * 237 ms
     * , 在所有 Java 提交中击败了
     * 18.16%
     * 的用户
     * <p>
     * 内存消耗 :
     * 57.1 MB
     * , 在所有 Java 提交中击败了
     * 14.14%
     * 的用户
     * 炫耀一下:
     *
     * @param args
     */
    public static void main(String[] args) {
        int k = 3;
        int[] arr = new int[]{4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, arr);
//        kthLargest.print(arr);
        int add = kthLargest.add(3);// returns 4
        System.out.println("kthLargest.add(3) == 4 ? " + (add == 4));
        add = kthLargest.add(5);  // returns 5
        System.out.println("kthLargest.add(5) == 5 ? " + (add == 5));
        add = kthLargest.add(10);  // returns 5
        System.out.println("kthLargest.add(10) == 5 ? " + (add == 5));
        add = kthLargest.add(9);  // returns 8
        System.out.println("kthLargest.add(9) == 8 ? " + (add == 8));
        add = kthLargest.add(4);  // returns 8
        System.out.println("kthLargest.add(4) == 8 ? " + (add == 8));
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
