class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;

        while (l < r-1) {
            int mid = (l + r) / 2;

            if (nums[mid] < nums[l]) r = mid;
            else if (nums[r] < nums[l]) l = mid;
            else r = mid;
            //System.out.println(l + " " + r + " " + mid);
        }

        if (nums[l] > nums[r]) return nums[r];
        return nums[l];

        // while (l < r-1) {
        //     int mid = (l + r) / 2;
        //     if (nums[mid-1] > nums[mid]) r = mid;
        //     else l = mid;
        // }

        // if (nums[r] > nums[(r+1)%nums.length]) return nums[(r+1)%nums.length];
        // return nums[r];

    }
}
