package io.kidlovec.lc;

import java.util.*;
import java.util.stream.IntStream;

/**
 * todo  description
 *
 * @author Fan Wenjie
 * @since 2021/8/11
 */
public class ListCode {


    public static void main(String[] args) {
        int[] arr = IntStream.range(1, 6).toArray();
        ListNode head = init(arr);

        System.out.println("==  init  ==");
        print(head);

        ListNode newList = new Solution().reverseList(head);

        System.out.println("==reversed==");

        print(newList);

        arr = new int[]{-21,10,17,8,4,26,5,35,33,-7,-16,27,-12,6,29,-12,5,9,20,14,14,2,13,-24,21,23,-21,5};
        head = init(arr);
        print(head);
        boolean hasCycle = new Solution().hasCycle(head);

        System.out.println("==hasCycle==" + hasCycle);
    }

    private static ListNode init(int[] arr) {
        ListNode curr = new ListNode(arr[0]);
        ListNode head = curr;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        curr.next = null;


        return head;
    }

    private static void print(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode next,prev = null;
        while (head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    public ListNode detectCycle1(ListNode head) {

        Set<ListNode> set = new HashSet<>();
        ListNode curr = head;
        while (curr != null && set.add(curr)){
            set.add(curr);
            curr = curr.next;
        }

        return curr;
    }

    public ListNode detectCycle2(ListNode head) {


        ListNode slow = head;
        ListNode fast = slow;
        boolean checked = false;
        while (fast != null && fast.next !=null && slow.next !=null){

            if (!checked){
                fast = fast.next.next;
                slow = slow.next;
                if (slow == fast){
                    // 有环
                    checked = true;
                    slow = head;
                }
            } else {
                fast = fast.next;
                slow = slow.next;
                if (slow == fast)
                    return slow;
            }
        }

        return slow;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<ListNode>();
        while (pos != null) {
            if (visited.contains(pos)) {
                return pos;
            } else {
                visited.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }


    /**
     * 1. 方法一， 遍历 list 并放入 set 中。如果set 出现重复 说明有环，或者 list 到尾部节点就说明无环。
     * 注意 放入的是 索引 而不是 内容
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

//        // 方法1
//        Set<ListNode> set = new HashSet<>();
//
//        ListNode curr = head;
//        while (curr != null &&!set.add(curr)){
//            curr = curr.next;
//        }
//
//        return curr != null;

        ListNode slow = head;
        ListNode quick = slow;

        while (slow != null && quick != null && quick.next != null){
            slow = slow.next;
            quick = quick.next.next;

            if (slow == quick )
                return true;
        }

        return false;
    }

}