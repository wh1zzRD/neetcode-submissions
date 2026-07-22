class Solution {
    public List<List<String>> partition(String s) {
        return helper(s, 0);
    }

    public List<List<String>> helper(String s, int current) {
        List<List<String>> res = new ArrayList<>();
        if (current == s.length()) {
            res.add(new ArrayList<String>());
            return res;
        }

        for (int r = current; r < s.length(); r++) {
            if (isPalindrome(s, current, r)) {
                for (List<String> l : helper(s, r + 1)) {
                    List<String> tmp = new ArrayList<>();
                    tmp.add(s.substring(current, r+1));
                    for (String str : l) tmp.add(str);
                    res.add(tmp);
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(String s, int l, int r) {
        int x = l;
        int y = r;

        while (x < y) {
            if (s.charAt(x) != s.charAt(y)) return false;
            x++;
            y--;
        }
        return true;
    }
}
