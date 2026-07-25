class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        if (n > 0) res[1] = 1;
        if (n > 1) res[2] = 1;
        if (n > 2) res[3] = 2;
        if (n <= 3) return res;

        int l = 2;
        int r = 3;
        
        int nextPow = 8;

        int i = 4;
        while (i <= n) {
            int p = l;
            while (i <= n && p <= r) res[i++] = res[p++];
            p = (l + r) / 2 + 1;
            while (i <= n && p <= r) res[i++] = res[p++];
            p = (l + r) / 2 + 1;
            while (i <= n && p <= r) res[i++] = res[p++] + 1;

            l = r+1;
            r = nextPow-1;
            nextPow *= 2;
        }

        return res;
    }
}
