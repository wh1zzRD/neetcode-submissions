class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch(token.charAt(0)) {
                case '+':
                    stack.push(stack.pop() + stack.pop());
                    break;
                case '-':
                    if (token.length() == 1) {
                        stack.push(-stack.pop() + stack.pop());
                    }
                    else stack.push(Integer.parseInt(token));
                    break;
                case '*':
                    stack.push(stack.pop() * stack.pop());
                    break;
                case '/':
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a / b);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
        // for (int i = 0; i < tokens.length; i++) {
        //     if (tokens[i].equals("+")) {
        //         stack.push(stack.pop() + stack.pop());
        //     } else if (tokens[i].equals("-")) {
        //         stack.push(-stack.pop() + stack.pop());
        //     } else if (tokens[i].equals("*")) {
        //         stack.push(stack.pop() * stack.pop());
        //     } else if (tokens[i].equals("/")) {
        //         int b = stack.pop();
        //         int a = stack.pop();
        //         stack.push(a / b);
        //     } else {
        //         stack.push(Integer.parseInt(tokens[i]));
        //     }
        // }
        // return stack.pop();
    }
}
