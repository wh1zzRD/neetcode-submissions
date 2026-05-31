class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l = 0;
        int r = 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        while (r < k) {
            maxHeap.add(nums[r]);
            r++;
        }

        int[] res = new int[nums.length - k + 1];
        int c = 0;
        while (r < nums.length) {
            res[c++] = maxHeap.peek();
            maxHeap.remove(nums[l]);
            maxHeap.add(nums[r]);

            l++; r++;
        }
        res[c] = maxHeap.peek();

        return res;
    }
}
