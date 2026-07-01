class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();

        while (n != 1 && !set.contains(n)) {

            int sum = 0;
            int tmp = n;
            while (tmp > 0) {
                sum += (tmp % 10) * (tmp % 10);
                tmp /= 10;
            }
            set.add(n);
            n = sum;
            
        }

        if (n == 1) return true;
        return false;
    }
}
