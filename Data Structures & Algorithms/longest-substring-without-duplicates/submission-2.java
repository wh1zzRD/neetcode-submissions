class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int l = 0;
        int r = 0;
        int maxLength = 1;
        if (s.length() == 0) return 0;
        set.add(Character.valueOf(s.charAt(0)));
        while (r < s.length()-1) {
            r++;
            while (set.contains(Character.valueOf(s.charAt(r)))) {
                set.remove(Character.valueOf(s.charAt(l++)));
            }
            set.add(Character.valueOf(s.charAt(r)));
            if (r - l + 1 > maxLength) {
                maxLength = r - l + 1;
            }
        }

        return maxLength;
    }
}
