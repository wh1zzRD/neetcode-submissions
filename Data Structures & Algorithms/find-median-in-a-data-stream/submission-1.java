class MedianFinder {
    int numElements;
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        numElements = 0;
        right = new PriorityQueue<>();
        left = new PriorityQueue<>(Comparator.reverseOrder());
    }
    
    public void addNum(int num) {
        if (right.size() > 0 && num > right.peek()) right.add(num);
        else left.add(num);
        numElements++;

        if (left.size() > right.size() + 1) right.add(left.poll());
        else if (right.size() > left.size() + 1) left.add(right.poll());
    }
    
    public double findMedian() {
        if (numElements % 2 == 0) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            if (left.size() > right.size()) return left.peek();
            else return right.peek();
        }
    }
}
