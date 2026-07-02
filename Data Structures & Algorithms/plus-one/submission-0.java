class Solution {
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> newDigits = new ArrayList<>();
        int cIn = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            newDigits.add((digits[i] + cIn) % 10);
            cIn = (digits[i] + cIn) / 10;
        }
        if (cIn == 1) newDigits.add(cIn);

        int[] res = new int[newDigits.size()];
        for (int i = 0; i < newDigits.size(); i++) {
            res[newDigits.size() - 1 - i] = newDigits.get(i);
        }
        return res;
    }
}
