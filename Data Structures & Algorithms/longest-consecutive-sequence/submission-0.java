class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> numbers = new HashSet<>();
        for (int num : nums) numbers.add(num);

        ArrayList<Integer> starts = new ArrayList<>();
        for (Integer number : numbers) {
            if (!numbers.contains(number-1)) starts.add(number);
        }

        int maxLength = 0;
        for (Integer start : starts) {
            int current = start;
            while (numbers.contains(current++));
            maxLength = Math.max(maxLength, current - start-1);
        }

        return maxLength;
    }
}
