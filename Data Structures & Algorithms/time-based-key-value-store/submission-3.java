class TimeMap {
    HashMap<String, Integer> map;
    ArrayList<ArrayList<Integer>> timestamps;
    ArrayList<ArrayList<String>> values;

    public TimeMap() {
        map = new HashMap<>();
        timestamps = new ArrayList<>();
        values = new ArrayList<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)) {
            int idx = map.get(key);
            timestamps.get(idx).add(timestamp);
            values.get(idx).add(value);
        } else {
            map.put(key, timestamps.size());
            timestamps.add(new ArrayList<Integer>());
            timestamps.getLast().add(timestamp);
            values.add(new ArrayList<String>());
            values.getLast().add(value);
        }
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        int idx = map.get(key);

        int l = 0;
        int r = timestamps.get(idx).size();

        while (l < r-1) {
            int mid = (l + r) / 2;

            if (timestamps.get(idx).get(mid) <= timestamp) l = mid;
            else r = mid;
        }
        // 1     3
        // happy sad

        // 10   20   30
        // one  two  three

        int x = l;
        //System.out.println(idx + " " + l + " " + r);
        if (r < timestamps.get(idx).size() && timestamps.get(idx).get(l) < timestamp && timestamps.get(idx).get(r) >= timestamp) x = r-1;

        if (timestamps.get(idx).get(x) <= timestamp) return values.get(idx).get(x);
        return "";
    }
}
