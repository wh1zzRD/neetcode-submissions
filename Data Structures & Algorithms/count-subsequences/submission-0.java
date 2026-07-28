class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length()][s.length()];
        dp[0][0] = s.charAt(0) == t.charAt(0)? 1 : 0;
        for (int i = 1; i < s.length(); i++) {
            dp[0][i] = dp[0][i-1] + (s.charAt(i) == t.charAt(0)? 1 : 0);
        }

        for (int i = 1; i < t.length(); i++) {
            for (int j = 1; j < s.length(); j++) {
                dp[i][j] = dp[i][j-1];
                if (s.charAt(j) == t.charAt(i)) {
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }
        return dp[t.length()-1][s.length()-1];
    }
}
