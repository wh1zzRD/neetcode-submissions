class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> l : backtrack(nums, 0, target)) {
            if (sum(l) == target) res.add(l);
        }
        return res;
    }

    public List<List<Integer>> backtrack(int[] nums, int current, int target) {
        if (target < 0) {
            List<List<Integer>> res = new ArrayList<>();
            return res;
        }
        if (current == nums.length - 1) {
            List<List<Integer>> res = new ArrayList<>();
            
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i <= target; i += nums[current]) {
                //System.out.println(nums[current]);
                res.add(tmp);

                tmp = new ArrayList<Integer>(tmp);
                tmp.add(nums[current]);
            }

            //System.out.println(Arrays.toString(res.toArray()));

            return res;
        }

        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> l : backtrack(nums, current + 1, target)) {
            int s = sum(l);
            while (s <= target) {
                res.add(l);
                l = new ArrayList<Integer>(l);
                l.add(nums[current]);
                s += nums[current];
            }
        }

        return res;
    }

    public int sum(List<Integer> l) {
        int sum = 0;
        for (Integer n : l) sum += n;
        return sum;
    }
}
