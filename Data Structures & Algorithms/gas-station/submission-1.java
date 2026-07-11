class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int dif = 0;
        for (int i = 0; i < gas.length; i++) {
            dif += gas[i] - cost[i];
        }
        if (dif < 0) return -1;

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
