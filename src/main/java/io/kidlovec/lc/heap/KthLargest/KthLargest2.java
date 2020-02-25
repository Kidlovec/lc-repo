package io.kidlovec.lc.heap.KthLargest;

import java.util.PriorityQueue;

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
public class KthLargest2 {

    private PriorityQueue<Integer> queue;
    private int k;

    /**
     * 求最大 所以是小顶堆。 最小的在最前面，每次把最小的换出来。
     * <p>
     * 优先队列
     *
     * @param k
     * @param nums
     */
    public KthLargest2(int k, int[] nums) {
        queue = new PriorityQueue<>(k);

        this.k = k;
        for (int i : nums)
            add(i);
    }

    public int add(int val) {

        if (queue.size() < this.k) {
            queue.offer(val);

        } else if (queue.peek() < val) {
            queue.poll();
            queue.offer(val);
        }

        return queue.peek();
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
        KthLargest2 kthLargest = new KthLargest2(3, arr);
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
