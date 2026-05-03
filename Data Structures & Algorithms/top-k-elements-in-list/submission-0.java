class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] res = new int[k];
        int counter = 0;

        for (int i = 0; i < k; i++) {
            int num = 0;
            int max = Integer.MIN_VALUE;

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                    num = entry.getKey();
                }
            }

            res[counter++] = num;
            map.remove(num);
        }
        return res;
    }
}
