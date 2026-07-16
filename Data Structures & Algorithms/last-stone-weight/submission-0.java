class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) heap.add(stone);

        while (heap.size() > 1) {
            int a = heap.poll();
            int b = heap.poll();

            if (a == b) {
                continue;
            } else heap.add(Math.abs(a - b));
        }

        if (heap.size() == 0) return 0;
        else return heap.poll();
    }
}
