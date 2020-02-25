package io.kidlovec.leetcode;

/**
 * @author kidlovec
 * @date 2019-11-18
 */
public class ListNodeUtil {
    public static void printList(ListNode head) throws InterruptedException {

        long st = System.currentTimeMillis();
        long et = System.currentTimeMillis();
        ListNode current = head;
        while (current != null) {

            System.out.print(current.val);
            System.out.print("->");
            current = current.next;

            et = System.currentTimeMillis();
            if (et - st >= 100) {
                Thread.sleep(10000);
            }
        }
        System.out.println("Null");
    }

    public static ListNode initList(int startVal, int endVal) {
        ListNode head = new ListNode(startVal);

        ListNode current = head;
        for (int i = startVal + 1; i <= endVal; i++) {
            final ListNode newNode = new ListNode(i);
            current.next = newNode;
            current = newNode;
        }

        return head;
    }

    public static ListNode initListWithCycle(int startVal, int endVal) {
        ListNode head = new ListNode(startVal);

        final int middle = (startVal + endVal) / 2;
        ListNode current = head;
        ListNode cycleNode = null;
        for (int i = startVal + 1; i <= endVal; i++) {
            final ListNode newNode = new ListNode(i);
            if (i == middle) {
                cycleNode = newNode;
            }
            current.next = newNode;
            current = newNode;
        }

        current.next = cycleNode;

        return head;
    }
}
