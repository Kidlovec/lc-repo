package io.kidlovec.leetcode.ReverseLinkedList;

import io.kidlovec.leetcode.ListNode;

import static io.kidlovec.leetcode.ListNodeUtil.*;


/**
 * @author kidlovec
 * @date 2019-11-18
 *
 * 206
 *
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * 相关:
 *
 * swap-nodes-in-pairs
 * linked-list-cycle
 * linked-list-cycle-ii
 *
 *
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 *
 *
 */
public class ReverseLinkedList {

    public static void main(String[] args) throws InterruptedException {
        ListNode head = initList(1, 5);


        printList(head);

        Solution s = new SolutionTwoImpl();

        final ListNode reverseList = s.reverseList(head);
        printList(reverseList);
    }


}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
interface Solution {
     ListNode reverseList(ListNode head);
}


