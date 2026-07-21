class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return backtrack(nums, 0);
    }

    public List<List<Integer>> backtrack(int[] nums, int current) {
        if (current == nums.length - 1) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            res.add(new ArrayList<>(Arrays.asList(nums[current])));
            return res;
        }

        HashSet<List<Integer>> res = new HashSet<>();
        for (List<Integer> l : backtrack(nums, current+1)) {
            List<Integer> tmp = new ArrayList<>(l);
            tmp.add(nums[current]);
            res.add(l);
            res.add(tmp);
        }

        List<List<Integer>> r = new ArrayList<>(res);
        return r;
    }
}
