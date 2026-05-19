/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        HashMap<Node, Stack<Node>> map = new HashMap<>();
        HashMap<Node, Node> newToOld = new HashMap<>();

        Node curr = head;
        Node newHead = new Node(curr.val); newHead.next = head.next;
        Node newCurr = newHead;
        while (curr != null) {
            if (curr.next == null) newCurr.next = null;
            else newCurr.next = new Node(curr.next.val);

            if (curr.random != null) {
                map.put(
                    curr.random,
                    map.getOrDefault(curr.random, new Stack<Node>())
                );
                map.get(curr.random).push(newCurr);
            }

            newToOld.put(newCurr, curr);

            curr = curr.next;
            newCurr = newCurr.next;
        }

        // for (Node n : map.keySet()) System.out.println(n.val);

        curr = newHead;
        while (curr != null) {
            if (!map.containsKey(newToOld.get(curr))) {
                curr = curr.next;
                continue;
            }

            while (!map.get(newToOld.get(curr)).isEmpty()) {
                map.get(newToOld.get(curr)).pop().random = curr;
            }

            curr = curr.next;
            
        }
        return newHead;
    }
}
