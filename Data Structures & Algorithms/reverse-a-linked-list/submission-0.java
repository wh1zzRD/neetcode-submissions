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
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        if (head.next.next == null) {
            ListNode r = head.next;
            head.next.next = head;
            head.next = null;
            return r;
        }

        ListNode one = head;
        ListNode two = head.next;
        ListNode three = head.next.next;
        one.next = null;

        while (three != null) {
            two.next = one;

            one = two;
            two = three;
            three = three.next;
        }

        two.next = one;

        return two;
    }
}
