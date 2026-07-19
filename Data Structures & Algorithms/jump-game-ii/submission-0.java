class Solution {
    public int jump(int[] nums) {
        int[] jumps = new int[nums.length];
        int p = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i + nums[i] < p) continue;

            for (int j = p + 1; j <= i + nums[i] && j < nums.length; j++) {
                jumps[j] = jumps[i] + 1;
                p++;
            }
        }

        return jumps[nums.length - 1];
    }
}
