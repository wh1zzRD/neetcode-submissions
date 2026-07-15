class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;
        int[][] dp = new int[nums.length][2 * sum + 1];

        if (Math.abs(target) > Math.abs(sum)) return 0;

        dp[0][nToCoord(sum, nums[0])] += 1;
        dp[0][nToCoord(sum, -nums[0])] += 1;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < 2 * sum + 1; j++) {
                if (j + nums[i + 1] < 2 * sum + 1)
                    dp[i+1][j + nums[i + 1]] += dp[i][j];
                if (j - nums[i + 1] >= 0)
                    dp[i+1][j - nums[i + 1]] += dp[i][j];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 2 * sum + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[nums.length - 1][nToCoord(sum, target)];

        
    }

    public int nToCoord(int sum, int n) {
        return sum + n;
    }
}
