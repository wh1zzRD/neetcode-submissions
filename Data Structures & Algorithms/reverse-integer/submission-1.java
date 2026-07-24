class Solution {
    public int reverse(int x) {
        int res = 0;
        System.out.println(Integer.MAX_VALUE);
        while (x != 0) {
            if (Math.abs(res) > Integer.MAX_VALUE / 10) return 0;

            res = res * 10 + (x % 10);
            x /= 10;
        }
        return res;
    }

    // 214748364
    // 463847412
}
