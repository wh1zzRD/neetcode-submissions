class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a = nums1;
        int[] b = nums2;
        if (a.length > b.length) {
            int[] tmp = a;
            a = b;
            b = tmp;
        }

        int l = 0;
        int r = a.length - 1;

        int half = (a.length + b.length) / 2;
        int total = a.length + b.length;

        while (true) {
            int i = Math.floorDiv(l+r, 2);
            int j = half - i - 2;

            int aLeft = (i >= 0)? a[i] : Integer.MIN_VALUE;
            int aRight = (i < a.length-1)? a[i+1] : Integer.MAX_VALUE;
            int bLeft = (j >= 0)? b[j] : Integer.MIN_VALUE;
            int bRight = (j < b.length-1)? b[j+1] : Integer.MAX_VALUE;

            if (aLeft <= bRight && bLeft <= aRight) {
                if (total % 2 == 0) 
                    return (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2.0;
                else return Math.min(aRight, bRight);
            } else if (aLeft > bRight) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }
    }
}
