class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;

        while (l < r-1) {
            int mid = (l + r) / 2;
            
            if (nums[mid] < nums[l]) r = mid;
            else if (nums[l] > nums[r]) l = mid;
            else r = mid;
        }

        int center = l;
        if (nums[r] < nums[l]) center = r;

        l = 0;
        r = center;
        while (l < r-1) {
            int mid = (l + r) / 2;

            if (nums[mid] <= target) l = mid;
            else r = mid;
        }

        if (nums[l] == target) return l;

        l = center;
        r = nums.length;
        while (l < r-1) {
            int mid = (l + r) / 2;

            if (nums[mid] <= target) l = mid;
            else r = mid;
        }

        if (nums[l] == target) return l;
        return -1;
    }
}
