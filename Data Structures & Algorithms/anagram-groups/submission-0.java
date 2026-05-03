class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<String> newStrs = new ArrayList<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            newStrs.add(new String(chars));
        }

        HashMap<String, Integer> strToIdx = new HashMap<>();
        int counter = 0;
        for (int i = 0; i < newStrs.size(); i++) {
            if (!strToIdx.containsKey(newStrs.get(i)))
                strToIdx.put(newStrs.get(i), counter++);
        }

        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < counter; i++) {
            res.add(new ArrayList<>());
        }

        for (int i = 0; i < strs.length; i++) {
            res.get(strToIdx.get(newStrs.get(i))).add(strs[i]);
        }

        return res;

    }
}
