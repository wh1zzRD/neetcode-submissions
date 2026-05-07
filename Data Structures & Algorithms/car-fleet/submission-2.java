class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] comb = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            comb[i][0] = position[i];
            comb[i][1] = speed[i];
        }
        Arrays.sort(comb, (a,b)->Integer.compare(a[0], b[0]));

        Stack<Double> stack = new Stack<>();
        stack.push((double)(target - comb[position.length-1][0])/comb[position.length-1][1]);
        System.out.println((double)(target - comb[position.length-1][0])/comb[position.length-1][1]);

        int res = 1;

        for (int i = position.length-2; i >= 0; i--) {
            double time = (double)(target - comb[i][0])/comb[i][1];
            System.out.println(time);
            if (time > stack.peek()) {
                res++;
                stack.clear();
                stack.push(time);
            }
        }
        return res;
    }
}
