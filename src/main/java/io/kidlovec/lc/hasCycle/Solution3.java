package io.kidlovec.lc.hasCycle;

import com.kid.leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

import static com.kid.leetcode.ListNodeUtil.initListWithCycle;

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

//        com.kid.leetcode.ListNodeUtil.printList(head);
        Solution3 s = new Solution3();
        final ListNode listNode = s.detectCycle(head);
        System.out.println(listNode.val);

    }



}
