class Solution {
    public List<String> generateParenthesis(int n) {
        return backtrack(n);
    }

    public List<String> backtrack(int n) {
        if (n == 1) {
            List<String> res = new ArrayList<>();
            res.add("()");
            return res;
        }

        HashSet<String> res = new HashSet<>();
        for (int i = 1; i < n; i++) {
            List<String> a = backtrack(i);
            List<String> b = backtrack(n - i);;

            for (String strA : a) {
                for (String strB : b) {
                    res.add(strA + strB);
                }
            }        
        }
        for (String s : backtrack(n - 1)) {
            res.add("(" + s + ")");
            res.add("()" + s);
            res.add(s + "()");
        }

        List<String> r = new ArrayList<>(res);
        return r;
    }

    // "(())(())"
}
