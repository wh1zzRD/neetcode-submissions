/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if (head.next == null) return;

        int len = 1;
        ListNode curr = head;
        while (curr.next != null) {
            len++;
            curr = curr.next;
        }
        
        ListNode mid = head;
        for (int c = 0; c < (len + 1) / 2 - 1; c++) mid = mid.next;

        ListNode prev = mid;
        mid = mid.next;

        prev.next = null;

        ListNode one = mid;
        ListNode two = mid.next;
        one.next = null;
        while (two != null) {
            ListNode tmp = two.next;
            two.next = one;

            one = two;
            two = tmp;
        }

        ListNode curr1 = head;
        ListNode curr2 = one;

        while (curr1 != null && curr2 != null) {
            ListNode next1 = curr1.next;
            ListNode next2 = curr2.next;

            curr1.next = curr2;
            curr2.next = next1;

            curr1 = next1;
            curr2 = next2;
        }

    }
}
