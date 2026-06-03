class Solution {
    public int rob(int[] nums) {
        int[] breakIn = new int[nums.length];
        int[] notBreakIn = new int[nums.length];
        breakIn[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            breakIn[i] = notBreakIn[i-1] + nums[i];
            notBreakIn[i] = Math.max(breakIn[i-1], notBreakIn[i-1]);
        }
        return Math.max(breakIn[nums.length-1], notBreakIn[nums.length-1]);
    }
}
