class KthLargest {
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) heap.poll();
        }
    }
    
    public int add(int val) {
        heap.add(val);
        if (heap.size() > k) heap.poll();

        return heap.peek();
    }
}
