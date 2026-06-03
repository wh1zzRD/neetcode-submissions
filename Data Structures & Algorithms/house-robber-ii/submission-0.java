class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] profit = new int[nums.length];
        
        profit[0] = nums[0];
        profit[1] = Math.max(profit[0], nums[1]);

        for (int i = 2; i < nums.length - 1; i++) {
            profit[i] = Math.max(profit[i-1], profit[i-2] + nums[i]);
        }
        profit[nums.length-1] = profit[nums.length-2];
        int a = profit[nums.length-1];

        profit[0] = 0;
        profit[1] = Math.max(profit[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            profit[i] = Math.max(profit[i-1], profit[i-2] + nums[i]);
        }
        int b = profit[nums.length-1];

        return Math.max(a, b);
    }
}
