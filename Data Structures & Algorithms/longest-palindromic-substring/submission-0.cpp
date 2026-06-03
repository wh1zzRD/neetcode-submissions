class Solution {
public:
    string longestPalindrome(string s) {
        int max = 1;
        string res = s.substr(0, 1);

        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;

            while (l >= 0 && r < s.length() && s[l] == s[r]) {
                l--;
                r++;
            }
            l++; r--;

            if (max < r - l + 1) {
                max = r - l + 1;
                res = s.substr(l, r - l + 1);
            }

            l = i;
            r = i + 1;

            while (l >= 0 && r < s.length() && s[l] == s[r]) {
                l--;
                r++;
            }
            l++; r--;

            if (max < r - l + 1) {
                max = r - l + 1;
                res = s.substr(l, r - l + 1);
            }
        }
        return res;
    }
};
