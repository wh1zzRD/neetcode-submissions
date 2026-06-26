class Solution {
    public int maxProfit(int[] prices) {
        int[][] profit = new int[prices.length][4];
        profit[0][0] = -prices[0];
        profit[0][1] = 0;
        profit[0][2] = 0;
        profit[0][3] = 0;

        for (int i = 1; i < prices.length; i++) {
            profit[i][1] = profit[i-1][3];
            profit[i][2] = Math.max(profit[i-1][1], profit[i-1][2]);
            profit[i][3] = profit[i-1][0] + prices[i];

            profit[i][0] = Math.max(Math.max(profit[i-1][1], profit[i-1][2]) - prices[i], profit[i-1][0]);
        }

        return Math.max(
            Math.max(profit[prices.length-1][0], profit[prices.length-1][1]),
            Math.max(profit[prices.length-1][2], profit[prices.length-1][3])
        );
    }
}
