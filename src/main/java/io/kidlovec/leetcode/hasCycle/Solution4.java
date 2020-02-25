package io.kidlovec.leetcode.hasCycle;

import io.kidlovec.leetcode.ListNode;

import static io.kidlovec.leetcode.ListNodeUtil.initListWithCycle;

/**
 * detectCycle
 * 使用 快慢指针的方式来 实现链表 的环位置的判断
 * linked-list-cycle-ii
 *
 * @author kidlovec
 * @date 2020-01-16
 */
public class Solution4 {

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                fast = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;

            }
        }

        return null;
    }

    public static void main(String[] args) throws InterruptedException {
        ListNode head = initListWithCycle(1, 5);

//        io.kid.lc.ListNodeUtil.printList(head);
        Solution4 s = new Solution4();
        final ListNode listNode = s.detectCycle(head);
        System.out.println(listNode.val);

    }


}
