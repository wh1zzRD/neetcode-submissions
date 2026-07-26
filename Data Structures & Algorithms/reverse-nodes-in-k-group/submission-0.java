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

class Triplet {
    ListNode firstOfGroup;
    ListNode lastOfGroup;
    ListNode nextAfter;

    public Triplet(ListNode firstOfGroup, ListNode lastOfGroup, ListNode nextAfter) {
        this.firstOfGroup = firstOfGroup;
        this.lastOfGroup = lastOfGroup;
        this.nextAfter = nextAfter;
    }
}

class Solution {
    public Triplet reverseSingleGroup(ListNode start, int k) {
        if (k == 1) return new Triplet(start, start, start.next);

        ListNode lastOfGroup = start;

        ListNode head = start;
        ListNode firstOfGroup = start;
        for (int i = 0; i < k-1; i++) {
            head = head.next;
            if (head == null) {
                return new Triplet(start, firstOfGroup, null);
            }
            firstOfGroup = head;
        }

        head = start;
        ListNode next = head.next;
        head.next = null;
        for (int i = 0; i < k-1; i++) {
            ListNode tmp = next.next;
            next.next = head;
            head = next;
            next = tmp;
        }
        return new Triplet(head, lastOfGroup, next);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        Triplet t = reverseSingleGroup(head, k);
        ListNode newHead = t.firstOfGroup;
        while (t.nextAfter != null) {
            Triplet tmp = reverseSingleGroup(t.nextAfter, k);
            t.lastOfGroup.next = tmp.firstOfGroup;
            t = tmp;
        }
        return newHead;
    }
}
