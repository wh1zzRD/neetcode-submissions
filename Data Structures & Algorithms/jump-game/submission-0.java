class Solution {
    public boolean canJump(int[] nums) {
        int curFurthest = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (i > curFurthest) return false;
            curFurthest = Math.max(curFurthest, i + nums[i]);
        }
        return true;
    }
}
