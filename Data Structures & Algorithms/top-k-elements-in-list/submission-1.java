class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) buckets.add(new ArrayList<>());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            buckets.get(entry.getValue()).add(entry.getKey());
        }

        int[] res = new int[k];
        int counter = 0;
        for (int i = buckets.size()-1; i > 0; i--) {
            int tmp = 0;
            while (counter < k) {
                if (tmp == buckets.get(i).size()) break;
                res[counter++] = buckets.get(i).get(tmp++);
            }
        }

        return res;

        // int[] res = new int[k];
        // int counter = 0;

        // for (int i = 0; i < k; i++) {
        //     int num = 0;
        //     int max = Integer.MIN_VALUE;

        //     for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        //         if (entry.getValue() > max) {
        //             max = entry.getValue();
        //             num = entry.getKey();
        //         }
        //     }

        //     res[counter++] = num;
        //     map.remove(num);
        // }
        // return res;
    }
}
