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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 1;
        ListNode curr = head;
        while (curr.next != null) {
            len++;
            curr = curr.next;
        }

        int idxToRemove = len - n;

        if (idxToRemove == 0) return head.next;

        curr = head.next;
        ListNode prev = head;
        int c = 1;

        while (c < idxToRemove) {
            c++;
            prev = curr;
            curr = curr.next;
        }

        prev.next = curr.next;
        curr.next = null;

        return head;

    }
}
