class Solution {
    public int maxProduct(int[] nums) {
        int curMax = nums[0];
        int max = Integer.MIN_VALUE;
        int maxNeg = nums[0] < 0? nums[0] : 1;

        for (int i = 1; i < nums.length; i++) {
            if (max < curMax) max = curMax;

            int tmpCurMax = curMax;
            int tmpMaxNeg = maxNeg;

            curMax = Math.max(nums[i], Math.max(tmpCurMax * nums[i], tmpMaxNeg * nums[i]));
            maxNeg = Math.min(
                nums[i] < 0? nums[i] : 1,
                Math.min(
                    nums[i] * maxNeg < 0? nums[i] * maxNeg: 1,
                    nums[i] * tmpCurMax < 0? nums[i] * tmpCurMax: 1
                )
            );
        }

        if (curMax > max) max = curMax;

        return max;
    }
}
