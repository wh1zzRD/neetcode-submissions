class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;

        int s = 0;
        int f = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > prices[f]) {
                f = i;
                max = Math.max(max, prices[f] - prices[s]);
            }
            if (prices[i] < prices[s]) {
                s = i;
                f = i;
            }
        }

        return max;
    }
}
