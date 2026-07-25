class Solution {
    public int missingNumber(int[] nums) {
        int x = 0;
        for (int num : nums) {
            x = x ^ num;
        }
        int y = 0;
        for (int i = 0; i < nums.length+1; i++) y = y ^ i;

        return x ^ y;
    }
}
