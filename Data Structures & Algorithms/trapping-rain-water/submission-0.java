class Solution {
    public int trap(int[] height) {
        int[] maxL = new int[height.length];
        int[] maxR = new int[height.length];
        maxL[0] = 0;
        maxR[height.length-1] = 0;
        for (int i = 1; i < height.length; i++) {
            maxL[i] = Math.max(maxL[i-1], height[i-1]);
            maxR[height.length-1-i] = Math.max(maxR[height.length-i], height[height.length-i]);
        }

        int res = 0;
        for (int i = 0; i < height.length; i++) {
            res += Math.max(0, Math.min(maxL[i], maxR[i]) - height[i]);
        }
        return res;
    }
}
