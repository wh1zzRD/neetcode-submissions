class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> temps = new Stack<>();
        Stack<Integer> idxs = new Stack<>();

        temps.push(temperatures[0]);
        idxs.push(0);

        for (int i = 1; i < temperatures.length; i++) {
            while (!temps.isEmpty() && temps.peek() < temperatures[i]) {
                temps.pop();
                res[idxs.peek()] = i-idxs.pop();
            }
            temps.push(temperatures[i]);
            idxs.push(i);
        }

        return res;
    }
}
