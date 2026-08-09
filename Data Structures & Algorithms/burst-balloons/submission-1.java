class Solution {
    int[][] dp;
    public int maxCoins(int[] nums) {
        int[] baloons = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            baloons[i+1] = nums[i];
        }
        baloons[0] = 1;
        baloons[nums.length + 1] = 1;

        dp = new int[nums.length+2][nums.length+2];
        
        for (int i = nums.length-1; i >= 0; i--) {
            for (int j = i+2; j <= nums.length+1; j++) {
                
                for (int l = i+1; l < j; l++) {
                    dp[i][j] = Math.max(
                        dp[i][j], 
                        baloons[i] * baloons[l] * baloons[j] + dp[i][l] + dp[l][j]
                    );
                }

            }
        }
        return dp[0][nums.length+1];
    }
}
