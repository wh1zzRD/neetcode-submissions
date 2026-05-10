class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) if (pile > max) max = pile;

        int l = 0;
        int r = max;
        while (l < r - 1) {
            int neededTime = 0;
            int mid = (l + r) / 2;
            for (int pile : piles) neededTime += Math.ceil((double)pile / mid);

            if (neededTime <= h) r = mid;
            else l = mid;
        }
        return r;
    }
}
