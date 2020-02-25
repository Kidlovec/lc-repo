package io.kidlovec.lc.hasCycle;

import com.kid.leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

import static com.kid.leetcode.ListNodeUtil.initListWithCycle;

/**
 * @author kidlovec
 * @date 2020-01-16
 */
public class Solution2 {

    public boolean hasCycle(ListNode head) {

        Set<ListNode> set = new HashSet<>();
        ListNode next = head;
        while (next != null) {

            if (!set.add(next)) {
                return true;
            }
            next = next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = initListWithCycle(1, 5);


//        printList(head);
        Solution2 s = new Solution2();

        System.out.println(s.hasCycle(head));
    }

}
