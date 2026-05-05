class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        s = s.toLowerCase();


        while (l < s.length() && r >= 0 && l <= r) {
            if (!((s.charAt(l) >= '0' && s.charAt(l) <= '9') || (s.charAt(l) >= 'a' && s.charAt(l) <= 'z'))) {
                l++;
                continue;
            }
            if (!((s.charAt(r) >= '0' && s.charAt(r) <= '9') || (s.charAt(r) >= 'a' && s.charAt(r) <= 'z'))) {
                r--;
                continue;
            }

            System.out.println(s.charAt(l) + " " + s.charAt(r));
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }   
        return true;
    }
}
