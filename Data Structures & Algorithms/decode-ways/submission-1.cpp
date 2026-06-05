class Solution {
public:
    int numDecodings(string s) {
        if (s[0] == '0') return 0;
        if (s.length() == 1) return 1;

        vector<int> combinations(s.length());
        combinations[0] = 1;

        if (s[1] == '0') {
            combinations[1] = 1;
        } else if (s[1] >= '7' && s[0] == '2') {
            combinations[1] = 1;
        } else combinations[1] = 2;

        if (s[1] == '0') {
            if (s[0] <= '2' && s[0] != '0') combinations[1] = 1;
            else return 0;
        } else if (s[1] >= '7' && s[0] == '2') {
            combinations[1] = combinations[0];
        } else if (s[0] >= '3') {
            combinations[1] = combinations[0];
        }
        else combinations[1] = 2;

        for (int i = 2; i < s.length(); i++) {
            if (s[i] == '0') {
                if (s[i-1] <= '2' && s[i-1] != '0') combinations[i] = combinations[i-2];
                else return 0;
            } else if (s[i] >= '7' && s[i-1] == '2') {
                combinations[i] = combinations[i-1];
            } else if (s[i-1] >= '3') {
                combinations[i] = combinations[i-1];
            } else if (s[i-1] == '0') {
                combinations[i] = combinations[i-1];
            }
            else combinations[i] = combinations[i-2] + combinations[i-1];
        }

        return combinations[s.length()-1];
    }
};
