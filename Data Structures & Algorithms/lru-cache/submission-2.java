class Node {
    public int val;
    public int key;
    public Node next;
    public Node prev;

    public Node(int val, int key, Node next, Node prev) {
        this.val = val;
        this.key = key;
        this.next = next;
        this.prev = prev;
    }
}

class LRUCache {
    HashMap<Integer, Node> map;

    Node first;
    Node last;

    int curSize;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        first = null;
        last = null;
        this.capacity = capacity;
    }

    private void printList() {
        Node c = first;
        System.out.print("List: ");
        while (c != null) {
            System.out.print("[" + c.key + ", " + c.val + "], ");
            c = c.next;
        }
        System.out.print("(" + last.key + " " + last.val + ")");
        System.out.println();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        else {
            Node n = map.get(key);

            if (n == first) {
                //printList();
                return n.val;
            }
            if (n == last) {
                n.prev.next = null;
                last = n.prev;
                n.prev = null;
                n.next = first;
                first.prev = n;
                first = n;
                //printList();
                return n.val;
            }

            n.prev.next = n.next;
            n.next.prev = n.prev;

            n.next = first;
            first.prev = n;
            n.prev = null;
            first = n;

            //printList();
            return n.val;
        }
    }
    
    public void put(int key, int value) {
        // if (map.size() > 0) {
        //     System.out.println(key + " " + value);
        //     printList();
        // }
        
        if (map.size() == 0) {
            Node n = new Node(value, key, null, null);
            map.put(key, n);

            first = n;
            last = n;
            return;
        }

        if (map.containsKey(key)) {
            Node n = map.get(key);

            if (n == first) {
                n.val = value;
                return;
            }
            if (n == last) {
                n.prev.next = null;
                last = n.prev;
                n.prev = null;
                n.next = first;
                first.prev = n;
                first = n;
                n.val = value;
                return;
            }

            n.prev.next = n.next;
            n.next.prev = n.prev;

            n.next = first;
            first.prev = n;
            n.prev = null;
            first = n;

            n.val = value;
        } else {
            if (map.size() < capacity) {
                Node n = new Node(value, key, first, null);
                map.put(key, n);

                first.prev = n;
                first = n;
            } else {
                if (map.size() == 1) {
                    Node n = new Node(value, key, null, null);
                    map.remove(first.key);
                    first = n;
                    last = n;
                    map.put(key, n);
                    return;
                }

                //printList();
                //System.out.println(key + " " + value + " " +map.size() + " " + last.val);

                last.prev.next = null;
                map.remove(last.key);
                last = last.prev;

                Node n = new Node(value, key, first, null);
                first.prev = n;
                first = n;


                map.put(key, n);
            }
        }
    }
}
