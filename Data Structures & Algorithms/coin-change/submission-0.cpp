class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        vector<int> min_amount(amount + 1);

        for (int c : coins) {
            if (c <= amount) min_amount[c] = 1;
        }

        for (int i = 0; i <= amount; i++) {
            for (int c : coins) {
                if (i - c >= 0 && min_amount[i-c] > 0) {
                    if (!min_amount[i]) min_amount[i] = min_amount[i-c] + 1;
                    else min_amount[i] = min(min_amount[i], min_amount[i-c] + 1);
                }
            }
        }

        if (!min_amount[amount] && amount) return -1;
        else return min_amount[amount];
    }
};
