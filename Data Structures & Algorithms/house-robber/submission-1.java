class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[] profit = new int[nums.length];
        profit[0] = nums[0];
        profit[1] = Math.max(profit[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            profit[i] = Math.max(profit[i-1], profit[i-2] + nums[i]);
        }
        return profit[nums.length-1];
    }
}
