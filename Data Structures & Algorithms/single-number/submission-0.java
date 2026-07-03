class Solution {
    public int singleNumber(int[] nums) {
        int t = nums[0];
        for (int i = 1; i < nums.length; i++) t = t ^ nums[i];
        return t;
    }
}
