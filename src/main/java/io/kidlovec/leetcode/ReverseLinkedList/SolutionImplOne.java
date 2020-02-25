package io.kidlovec.leetcode.ReverseLinkedList;

import io.kidlovec.leetcode.ListNode;

/**
 * @author kidlovec
 * @date 2019-11-18
 */
public class SolutionImplOne implements Solution {

    /**
     * 1->2->3->4->5->Null
     * 5->4->3->2->1->Null
     *
     * 效果就是
     * 1->2 的时候，做到
     * null<-1
     *
     *  1->2->3 的时候，做到
     *  null<-1<-2
     *
     * @param head
     * @return
     */
    @Override
    public ListNode reverseList(ListNode head) {

        ListNode cursor = head;
        ListNode prev = null;
        ListNode prevNext = null;
        while (cursor != null){

            prevNext = prev;
            prev = cursor;


            cursor = cursor.next;

            prev.next = prevNext;
        }


        return prev;
    }
}
