class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;

        double p = helper(x, Math.abs(n));
        if (n < 0) return 1 / p;
        else return p;
    }

    public double helper(double x, int n) {
        if (n == 0) return 1;

        double p = 1.0;
        if (n % 2 == 0) {
            p = helper(x, n/2);
            p = p * p;
        }
        else p = helper(x, n-1) * x;
        return p;
    }
}
