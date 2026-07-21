class Solution {
    HashMap<Character, ArrayList<String>> symbols = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<String>();
        }
        symbols.put('2', new ArrayList<String>(Arrays.asList("a", "b", "c")));
        symbols.put('3', new ArrayList<String>(Arrays.asList("d", "e", "f")));
        symbols.put('4', new ArrayList<String>(Arrays.asList("g", "h", "i")));
        symbols.put('5', new ArrayList<String>(Arrays.asList("j", "k", "l")));
        symbols.put('6', new ArrayList<String>(Arrays.asList("m", "n", "o")));
        symbols.put('7', new ArrayList<String>(Arrays.asList("p", "q", "r", "s")));
        symbols.put('8', new ArrayList<String>(Arrays.asList("t", "u", "v")));
        symbols.put('9', new ArrayList<String>(Arrays.asList("w", "x", "y", "z")));

        return backtrack(digits, 0);
    }

    public List<String> backtrack(String digits, int current) {
        if (current == digits.length() - 1) {
            List<String> res = new ArrayList<>();
            for (String s : symbols.get(digits.charAt(current))) {
                res.add(s);
            }
            return res;
        }

        List<String> res = new ArrayList<>();
        for (String s : backtrack(digits, current+1)) {
            for (String newSymbol : symbols.get(digits.charAt(current))) {
                res.add(newSymbol + s);
            }
        }

        return res;
    }
}
