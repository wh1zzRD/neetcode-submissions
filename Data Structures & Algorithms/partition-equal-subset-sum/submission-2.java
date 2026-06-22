class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int n : nums) totalSum += n;

        if (totalSum % 2 == 1) return false;

        boolean[] sumPossible = new boolean[totalSum + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = totalSum; j >= 0; j--) {
                if (sumPossible[j] && j + nums[i] <= totalSum)
                    sumPossible[j + nums[i]] = true;
            }
            sumPossible[nums[i]] = true;
        }
        return sumPossible[(int) (totalSum / 2)];
    }
}
