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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String a = "";
        while (l1 != null) {
            a += l1.val;
            l1 = l1.next;
        }

        String b = "";
        while (l2 != null) {
            b += l2.val;
            l2 = l2.next;
        }

        while (a.length() < b.length()) a += "0";
        while (b.length() < a.length()) b += "0";

        String res = "";
        int carryIn = 0;

        for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
            int s = (a.charAt(i) - '0') + (b.charAt(i) - '0');
            res += ((s + carryIn) % 10);
            if (s + carryIn > 9) carryIn = 1;
            else carryIn = 0;
        }

        if (carryIn == 1) res += "1";

        res = new StringBuilder(res).reverse().toString();

        int i = res.length() - 1;
        ListNode resNode = new ListNode(res.charAt(i) - '0');
        i--;
        ListNode curr = resNode;
        while (i >= 0) {
            curr.next = new ListNode(res.charAt(i) - '0');
            i--;
            curr = curr.next;
        }
        return resNode;
    }
}
