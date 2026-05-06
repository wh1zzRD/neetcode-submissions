class MinStack {
    int[] stack = new int[100];
    int pointer = 0;
    // int currentMin = Integer.MAX_VALUE;
    int[] minTable = new int[100];

    public MinStack() {
        int[] stack = new int[100];
        for (int i = 0; i < 100; i++) minTable[i] = Integer.MAX_VALUE;
        int pointer = 0;
        // int currentMin = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if (pointer == stack.length-1) {
            int[] newStack = new int[stack.length*2];
            int[] newMinTable = new int[stack.length*2];
            for (int i = 0; i < stack.length; i++) {
                newStack[i] = stack[i];
                newMinTable[i] = minTable[i];
            }
            stack = newStack;
            minTable = newMinTable;
        }
        stack[++pointer] = val;
        if (val < minTable[pointer-1]) minTable[pointer] = val;
        else minTable[pointer] = minTable[pointer-1];
    }
    
    public void pop() {
        pointer -= 1;
    }
    
    public int top() {
        return stack[pointer];
    }
    
    public int getMin() {
        return minTable[pointer];
    }
}
