class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while (l < r - 1) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) r = mid;
            else l = mid;
        }
        if (nums[l] == target) return l;
        return -1;
    }
}
