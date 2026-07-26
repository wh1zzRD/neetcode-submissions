class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) 
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);

        // for (Map.Entry<Character, Integer> e : map.entrySet()) {
        //     System.out.println(e.getKey() + " " + e.getValue());
        // }

        int l = 0;
        int r = 0;

        String res = "";
        int size = Integer.MAX_VALUE;
        while (r < s.length()) {

            boolean valid = true;
            for (Integer n : map.values()) {
                if (n > 0) valid = false;
            }
            //if (valid) System.out.println(s.substring(l, r+1));

            while (valid && l < r && map.getOrDefault(s.charAt(l), -1) < 0) {
                //System.out.println(l + " " + s.charAt(l) + " " + map.getOrDefault(s.charAt(l), -1));
                if (map.containsKey(s.charAt(l))) map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
                l++;
            }

            //System.out.println("2) " + l + " " + r);

            if (valid && r - l < size) {
                res = s.substring(l, r);
                size = r - l + 1;
                //System.out.println("1) " + res);
            }
            if (map.containsKey(s.charAt(r))) map.put(s.charAt(r), map.get(s.charAt(r))-1);
            r++;
        }

        boolean valid = true;
        for (Integer n : map.values()) {
            if (n > 0) valid = false;
        }
        while (valid && l < r && map.getOrDefault(s.charAt(l), -1) < 0) {
            //System.out.println(l + " " + s.charAt(l) + " " + map.getOrDefault(s.charAt(l), -1));
            if (map.containsKey(s.charAt(l))) map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
            l++;
        }
        if (valid && r - l < size) {
            res = s.substring(l, r);
            size = r - l + 1;
            //System.out.println("1) " + res);
        }

        return res;
    }
}
