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

        // while (one != null) {
        //     System.out.print(head.val + " ");
        //     head = head.next;
        //     System.out.print(one.val + " ");
        //     one = one.next;
        // }
        // if (head != null) System.out.print(head.val + " ");

        ListNode first = new ListNode();
        ListNode res = first;
        ListNode curr1 = head;
        ListNode curr2 = one;

        while (curr1 != null && curr2 != null) {
            res.next = new ListNode(curr1.val);
            res = res.next;
            curr1 = curr1.next;

            res.next = new ListNode(curr2.val);
            res = res.next;
            curr2 = curr2.next;
        }

        if (curr1 != null) {
            res.next = new ListNode(curr1.val);
            res = res.next;
            curr1 = curr1.next;
        }
        if (curr2 != null) {
            res.next = new ListNode(curr2.val);
            res = res.next;
            curr2 = curr2.next;
        }

        head.val = first.next.val;
        head.next = first.next.next;

        // head = res;

    }
}
