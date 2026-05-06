class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int l = i + 1;
            int r = nums.length-1;

            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // while (r > l && nums[r-1] == nums[r--]);
                    // l++;
                    // while (nums[l+1] == nums[l++] && l < r);
                    while (nums[r-1] == nums[r--] && r > l);
                }
                else if (nums[i] + nums[l] + nums[r] < 0) l++;
                else r--;
            }
        }
        return new ArrayList<>(res);
    }
}
