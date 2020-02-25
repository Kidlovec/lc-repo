package io.kidlovec.leetcode.SwapNodesInPairs;

import io.kidlovec.leetcode.ListNode;

import static io.kidlovec.leetcode.ListNodeUtil.initList;
import static io.kidlovec.leetcode.ListNodeUtil.printList;

/**
 * @author kidlovec
 * @date 2019-11-18
 */
public class SwapNodesInPairs {


    public static void main(String[] args) throws InterruptedException {
        ListNode head = initList(1, 4);


        printList(head);

        Solution s = new SolutionImplOne();

        final ListNode reverseList = s.swapPairs(head);
        printList(reverseList);
    }

}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
interface Solution {
    ListNode swapPairs(ListNode head);
}
