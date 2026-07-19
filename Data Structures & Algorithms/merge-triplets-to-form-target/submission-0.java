class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] cur = new int[3];
        cur[0] = Integer.MIN_VALUE;
        cur[1] = Integer.MIN_VALUE;
        cur[2] = Integer.MIN_VALUE;

        for (int i = 0; i < triplets.length; i++) {
            if (tripletUseful(triplets[i], target)) {
                cur[0] = Math.max(triplets[i][0], cur[0]);
                cur[1] = Math.max(triplets[i][1], cur[1]);
                cur[2] = Math.max(triplets[i][2], cur[2]);
            }
        }

        if (cur[0] == target[0] && cur[1] == target[1] && cur[2] == target[2])
            return true;
        return false;
    }

    public boolean tripletUseful(int[] triplet, int[] target) {
        if (triplet[0] == target[0] && triplet[1] <= target[1] && triplet[2] <= target[2])
            return true;
        if (triplet[0] <= target[0] && triplet[1] == target[1] && triplet[2] <= target[2])
            return true;
        if (triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] == target[2])
            return true;

        return false;
    }
}
