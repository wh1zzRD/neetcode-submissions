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
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        HashSet<ListNode> visited = new HashSet<>();
        boolean foundCycle = false;
        ListNode curr = head;

        while (curr.next != null && !foundCycle) {
            if (visited.contains(curr.next)) foundCycle = true;

            visited.add(curr);
            curr = curr.next;
        }

        if (foundCycle) return true;
        return false;
    }
}
