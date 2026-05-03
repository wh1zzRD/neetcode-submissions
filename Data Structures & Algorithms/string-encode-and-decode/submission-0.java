class Solution {

    public String encode(List<String> strs) {
        String res = "";
        for (String s : strs) {
            res += "0".repeat(s.length()) + "1" + s;
        }
        // System.out.println(res);
        return res;
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int idx = 0;
        while (idx < str.length()) {
            int sLength = 0;
            while (str.charAt(idx++) == '0') {
                sLength++;
            }
            res.add(str.substring(idx, idx+sLength));
            idx += sLength;
        }
        return res;
    }
}
