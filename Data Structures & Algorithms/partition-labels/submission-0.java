class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        int curLength = 0;
        int i = 0;
        
        while (i < s.length()) {
            HashSet<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            curLength++;
            map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
            if (map.get(s.charAt(i)) == 0) set.remove(s.charAt(i));
            i++;

            while (!set.isEmpty()) {
                curLength++;
                set.add(s.charAt(i));
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if (map.get(s.charAt(i)) == 0) set.remove(s.charAt(i));
                i++;
            }
            res.add(curLength);
            curLength = 0;
        }

        return res;

        // "xyxxyzbzbbisl"
        // x 3
        // y 2
        // z 2
        // b 3
        // i 1
        // s 1
        // l 1

    }
}
