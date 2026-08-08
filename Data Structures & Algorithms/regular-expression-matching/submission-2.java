class Solution {
    int[][] dp;
    public boolean isMatch(String s, String p) {
        dp = new int[p.length()][s.length()];

        return helper(s, p, 0, 0);
    }

    public boolean helper(String s, String p, int i, int j) {
        if (j >= p.length()) return i >= s.length();
        boolean first = (i < s.length()) && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.');
        if (j < p.length() && i < s.length()) {
            if (dp[j][i] == 1) return false;
            if (dp[j][i] == 2) return true;
        }

        if (j < p.length() - 1 && p.charAt(j+1) == '*') {
            boolean tmp = helper(s, p, i, j+2) || (first && helper(s, p, i+1, j));
            if (j < p.length() && i < s.length()) dp[j][i] = tmp? 2 : 1;
            return tmp;
        } else {
            boolean tmp = first && helper(s, p, i+1, j+1);
            if (j < p.length() && i < s.length()) dp[j][i] = tmp? 2 : 1;
            return tmp;
        }
    }
}
