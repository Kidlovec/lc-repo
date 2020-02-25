package io.kidlovec.leetcode.hasCycle;

import io.kidlovec.leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

import static io.kidlovec.leetcode.ListNodeUtil.initListWithCycle;

/**
 * detectCycle
 * linked-list-cycle-ii
 *
 * @author kidlovec
 * @date 2020-01-16
 */
public class Solution3 {

    public ListNode detectCycle(ListNode head) {

        Set<ListNode> set = new HashSet<>();
        ListNode next = head;
        while (next != null) {

            if (!set.add(next)) {
                return next;
            }
            next = next.next;
        }
        return null;
    }

    public static void main(String[] args) throws InterruptedException {
        ListNode head = initListWithCycle(1, 5);

//        io.kid.lc.ListNodeUtil.printList(head);
        Solution3 s = new Solution3();
        final ListNode listNode = s.detectCycle(head);
        System.out.println(listNode.val);

    }



}
