class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int maximum = 1;

        vector<int> subLengths(nums.size(), 1);
        subLengths[0] = 1;
        for (int i = 1; i < nums.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) subLengths[i] = max(subLengths[i], subLengths[j] + 1);
                if (subLengths[i] > maximum) maximum = subLengths[i];
            }
        }

        return maximum;
    }
};
