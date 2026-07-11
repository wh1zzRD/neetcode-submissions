class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        int sumCost = 0;
        for (int i = 0; i < gas.length; i++) {
            sumGas += gas[i];
            sumCost += cost[i];
        }
        if (sumGas < sumCost) return -1;

        int total = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            if (total < 0) {
                total = 0;
                start = i;
            }
            total += gas[i] - cost[i];
        }

        return start;
    
    }
}
