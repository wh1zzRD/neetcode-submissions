class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        for (List<Integer> l : backtrack(nums, 0)) res.add(l);

        return res;
    }

    public List<List<Integer>> backtrack(int[] nums, int index) {
        if (index == nums.length - 1) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<Integer>(Arrays.asList(nums[index])));
            res.add(new ArrayList<Integer>());

            return res;
        }

        List<List<Integer>> res = new ArrayList<>();
        
        for (List<Integer> l : backtrack(nums, index + 1)) {
            List<Integer> tmp = new ArrayList<Integer>(l);
            tmp.add(nums[index]);
            res.add(l);
            res.add(tmp);
        }

        return res;
        
    }

}
