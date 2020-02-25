package io.kidlovec.lc.hasCycle;

import com.kid.leetcode.ListNode;

import static com.kid.leetcode.ListNodeUtil.initListWithCycle;

/**
 * 快慢指针的方式 判断链表是否有环
 *
 * @author kidlovec
 * @date 2020-01-16
 */
public class Solution {

    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode quick = head;
        while (quick != null && quick.next != null &&
                slow != null) {

            slow = slow.next;
            quick = quick.next.next;
            if (slow == quick) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode head = initListWithCycle(1, 5);


//        printList(head);
        Solution s = new Solution();

        System.out.println(s.hasCycle(head));
    }

}
