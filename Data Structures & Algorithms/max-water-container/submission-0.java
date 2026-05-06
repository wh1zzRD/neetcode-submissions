class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length-1;
        int currentMax = 0;
        while (l < r) {
            currentMax = Math.max(currentMax, Math.min(heights[l], heights[r])*(r-l));
            if (heights[l] < heights[r]) l++;
            else r--;
        }
        return currentMax;
    }
}
