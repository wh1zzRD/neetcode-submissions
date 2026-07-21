class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return backtrack(nums, 0);
    }

    public List<List<Integer>> backtrack(int[] nums, int current) {
        if (current == nums.length) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            return res;
        }
        if (current == nums.length - 1) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            res.add(new ArrayList<>(Arrays.asList(nums[current])));

            return res;
        }

        List<List<Integer>> res = new ArrayList<>();
        int nCurrent = current;
        while (nCurrent < nums.length && nums[nCurrent] == nums[current]) nCurrent++;
        for (List<Integer> l : backtrack(nums, current + 1)) {
            List<Integer> tmp = new ArrayList<>(l);
            tmp.add(nums[current]);
            res.add(tmp);
        }

        for (List<Integer> l : backtrack(nums, nCurrent)) {
            res.add(l);
        }

        return res;
    }
}
