class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int n : nums) {
            heap.add(n);
            if (heap.size() > k) heap.poll();
        }
        // for (int i = 1; i < k; i++) heap.poll();
        return heap.poll();
    }
}
