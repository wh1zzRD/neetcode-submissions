class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean[][] dp = new boolean[s2.length() + 1][s1.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) dp[0][i] = dp[0][i-1] && (s1.charAt(i-1) == s3.charAt(i-1));

        for (int i = 1; i <= s2.length(); i++) {
            for (int j = 0; j <= s1.length(); j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] && (s2.charAt(i-1) == s3.charAt(i-1));
                    continue;
                }

                dp[i][j] = (dp[i][j-1] && s1.charAt(j-1) == s3.charAt(i + j - 1)) || (dp[i-1][j] && s2.charAt(i-1) == s3.charAt(i + j -1));
            }
        }

        return dp[s2.length()][s1.length()];
    }
}
