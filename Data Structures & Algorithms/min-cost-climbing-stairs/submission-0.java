class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] c = new int[cost.length+1];
        c[0] = 0;
        c[1] = 0;

        for (int i = 2; i < cost.length + 1; i++) c[i] = Math.min(c[i-1] + cost[i-1], c[i-2] + cost[i-2]);
        return c[cost.length];
    }
}
