class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 1;
        int maxLength = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(Character.valueOf(s.charAt(0)), 1);
        map.put(Character.valueOf(s.charAt(1)), map.getOrDefault(Character.valueOf(s.charAt(1)), 0) + 1);

        while (r < s.length()-1) {
            int mostFrequent = 0;
            for (Map.Entry<Character, Integer> e : map.entrySet())
                if (e.getValue() > mostFrequent) mostFrequent = e.getValue();

            if (r - l + 1 - mostFrequent <= k) {
                maxLength = Math.max(maxLength, r - l + 1);
                r++;
                map.put(
                    Character.valueOf(s.charAt(r)), 
                    map.getOrDefault(Character.valueOf(s.charAt(r)), 0) + 1
                    );
            } else {
                map.put(
                    Character.valueOf(s.charAt(l)), 
                    map.get(Character.valueOf(s.charAt(l))) - 1
                    );
                l++;
            }
        }
        int mostFrequent = 0;
        for (Map.Entry<Character, Integer> e : map.entrySet())
            if (e.getValue() > mostFrequent) mostFrequent = e.getValue();

        if (r - l + 1 - mostFrequent <= k) maxLength = Math.max(r - l + 1, maxLength);
        return maxLength;
    }
}
