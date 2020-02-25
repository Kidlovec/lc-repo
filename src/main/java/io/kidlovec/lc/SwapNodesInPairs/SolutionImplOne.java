package io.kidlovec.lc.SwapNodesInPairs;

import com.kid.leetcode.ListNode;

/**
 * @author kidlovec
 * @date 2019-11-18
 */
public class SolutionImplOne implements Solution {


    /**
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     *
     * 1 -> 2 -> 3 -> 4 -> null
     *
     * 2 -> 1 -> 3 -> 4 -> null
     *
     * 2 -> 1 -> 4 -> 3 -> null
     *
     *
     * @param head
     * @return
     */
    @Override
    public ListNode swapPairs(ListNode head) {

        ListNode prev = head;
        ListNode next = head;

        int counter = 0;
        while (next != null && next.next != null){


            ListNode a = next.next;
            ListNode b = a.next;

            next.next = b;
            a.next = next;

            if (counter < 1 ) prev.next = a;

            prev = next;
            next = b;
            counter ++;

        }

        return head.next;
    }
}
