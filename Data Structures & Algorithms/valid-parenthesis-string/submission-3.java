class Solution {
    public boolean checkValidString(String s) {

        // ()**)

        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') left.push(i);
            else if (s.charAt(i) == '*') star.push(i);
            else {
                if (left.isEmpty() && star.isEmpty()) return false;

                if (!left.isEmpty()) left.pop();
                else if (!star.isEmpty()) star.pop();
            }
        }

        while (!left.isEmpty()) {
            if (!star.isEmpty() && left.peek() < star.peek()) {
                left.pop();
                star.pop();
            } else return false;
        }
        return true;
    }
}
