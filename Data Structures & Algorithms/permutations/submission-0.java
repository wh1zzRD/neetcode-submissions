class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return backtrack(nums, 0);
    }

    public List<List<Integer>> backtrack(int[] nums, int current) {
        if (current == nums.length - 1) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>(Arrays.asList(nums[current])));
            return res;
        }

        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> l : backtrack(nums, current+1)) {
            for (int i = 0; i < l.size(); i++) {
                List<Integer> tmp = new ArrayList<>(l);
                tmp.add(i, nums[current]);
                res.add(tmp);
            }
            List<Integer> tmp = new ArrayList<>(l);
            tmp.addLast(nums[current]);
            res.add(tmp);
        }

        return res;
    }
}
