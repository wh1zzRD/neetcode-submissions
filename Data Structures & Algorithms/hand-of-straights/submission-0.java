class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        Arrays.sort(hand);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int v : hand) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }

        for (int i = 0 ; i < hand.length; i++) {
            if (map.get(hand[i]) == 0) continue;
            map.put(hand[i], map.get(hand[i]) - 1);

            for (int j = 1; j < groupSize; j++) {
                if (!map.containsKey(hand[i] + j) || map.get(hand[i] + j) == 0) {
                    return false;
                }
                
                map.put(hand[i] + j, map.get(hand[i] + j) - 1);
            }
        }
        return true;
    }
}
