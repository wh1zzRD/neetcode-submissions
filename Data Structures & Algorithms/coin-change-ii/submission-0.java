class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length];
        
        for (int i = coins[0]; i < amount + 1; i += coins[0]) dp[i][0] = 1;
        for (int i = 0; i < coins.length; i++) dp[0][i] = 1;

        for (int i = 1; i < amount + 1; i++) {
            for (int j = 1; j < coins.length; j++) {
                if (i - coins[j] < 0) {
                    dp[i][j] = dp[i][j-1];
                } else {
                    dp[i][j] = dp[i][j-1] + Math.max(dp[i - coins[j]][j], dp[i - coins[j]][j-1]);
                }
            }
        }

        // for (int i = 0; i < amount + 1; i++) {
        //     for (int j = 0; j < coins.length; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        return dp[amount][coins.length-1];

    }
}
