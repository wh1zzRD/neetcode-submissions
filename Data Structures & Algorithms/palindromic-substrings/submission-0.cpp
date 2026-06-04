class Solution {
public:
    int countSubstrings(string s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            int l = i-1;
            int r = i+1;

            while (l >= 0 && r < s.length() && s[l--] == s[r++]) count++;

            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s[l--] == s[r++]) count++;
            count++;
        }

        return count;
    }
};
