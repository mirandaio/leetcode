class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> mins = new Stack<Integer>();

    public void push(int x) {
        stack.push(x);
        if(mins.isEmpty() || x <= mins.peek())
            mins.push(x);
    }

    public void pop() {
        if(stack.pop().equals(mins.peek()))
            mins.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return mins.peek();
    }
}
