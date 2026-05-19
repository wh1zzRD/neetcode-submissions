class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) 
            map1.put(
                Character.valueOf(s1.charAt(i)), 
                map1.getOrDefault(Character.valueOf(s1.charAt(i)), 0) + 1
                );
        for (int i = 0; i < s1.length()-1; i++) 
            map2.put(Character.valueOf(s2.charAt(i)), map2.getOrDefault(Character.valueOf(s2.charAt(i)), 0) + 1);

        int l = 0;
        int r = s1.length() - 1;

        for (; r < s2.length(); r++, l++) {
            boolean invalid = false;
            map2.put(Character.valueOf(s2.charAt(r)), map2.getOrDefault(Character.valueOf(s2.charAt(r)), 0) + 1);

            for (Map.Entry<Character, Integer> e : map1.entrySet()) {
                if (e.getValue() != map2.getOrDefault(e.getKey(), 0)) {
                    invalid = true;
                    break;
                }
            }
            if (invalid) {
                map2.put(Character.valueOf(s2.charAt(l)), map2.get(Character.valueOf(s2.charAt(l)))-1);
                continue;
            }
            return true;
        }
        return false;
    }
}
