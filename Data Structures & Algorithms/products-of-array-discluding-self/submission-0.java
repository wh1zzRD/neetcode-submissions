class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] leftProd = new int[nums.length];
        leftProd[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            leftProd[i] = leftProd[i-1] * nums[i-1];
        }

        int[] rightProd = new int[nums.length];
        rightProd[nums.length-1] = 1;
        for (int i = nums.length-2; i >= 0; i--) {
            rightProd[i] = rightProd[i+1] * nums[i+1];
        }

        int[] res = new int[nums.length];
        res[0] = rightProd[0];
        res[nums.length-1] = leftProd[nums.length-1];
        for (int i = 1; i < nums.length-1; i++) {
            res[i] = leftProd[i] * rightProd[i];
        }
        return res;

        // int totalProduct = 1;
        // int countZeros = 0;
        // for (int num : nums) {
        //     if (num == 0) {
        //         countZeros++;
        //         if (countZeros == 1) continue;
        //     }
        //     totalProduct *= num;
        // }

        // int[] res = new int[nums.length];
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] == 0 && countZeros == 1) res[i] = totalProduct;
        //     else if (nums[i] != 0 && countZeros != 0) res[i] = 0;
        //     else if (countZeros > 1) res[i] = 0;
        //     else res[i] = totalProduct / nums[i];
        // }
        // return res;
    }
}  
