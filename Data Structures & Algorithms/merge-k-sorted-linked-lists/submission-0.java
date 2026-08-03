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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;

        ListNode curr1 = list1;
        ListNode curr2 = list2;

        ListNode newHead = null;
        if (list1 != null && (list2 == null || list1.val <= list2.val)) {
            newHead = new ListNode(list1.val);
            curr1 = curr1.next;
        }
        else if (list2 != null && (list1 == null || list2.val <= list1.val)){
            newHead = new ListNode(list2.val);
            curr2 = curr2.next;
        }

        ListNode currRes = newHead;

        while (curr1 != null && curr2 != null) {
            if (curr1.val < curr2.val) {
                currRes.next = new ListNode(curr1.val);
                curr1 = curr1.next;
                currRes = currRes.next;
            } else {
                currRes.next = new ListNode(curr2.val);
                curr2 = curr2.next;
                currRes = currRes.next;
            }
        }

        while (curr1 != null) {
            currRes.next = new ListNode(curr1.val);
            curr1 = curr1.next;
            currRes = currRes.next;
        }

        while (curr2 != null) {
            currRes.next = new ListNode(curr2.val);
            curr2 = curr2.next;
            currRes = currRes.next;
        }

        return newHead;

    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        while (lists.length > 1) {
            ListNode[] newLists = new ListNode[lists.length/2 + lists.length % 2];
            int c = 0;

            for (int i = 0; i < lists.length; i += 2) {
                newLists[c++] = mergeTwoLists(
                    lists[i],
                    i+1 < lists.length? lists[i+1] : null
                );
            }
            lists = newLists;
        }
        return lists[0];
    }
}
