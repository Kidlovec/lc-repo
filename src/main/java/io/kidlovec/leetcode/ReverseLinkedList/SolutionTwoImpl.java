package io.kidlovec.leetcode.ReverseLinkedList;

import io.kidlovec.leetcode.ListNode;

/**
 * @author kidlovec
 * @date 2020-01-03
 */
public class SolutionTwoImpl implements Solution {

    @Override
    public ListNode reverseList(ListNode head) {

        ListNode temp, prev = null;

        while (head != null ){
            temp = prev;
            prev = head;

            head = head.next;
            prev.next = temp;
        }

        return prev;
    }
}
