class MinStack {
    
    Stack<Integer> stack;
    Stack<Integer> suppStack;

    public MinStack() {
        stack = new Stack<>();
        suppStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        
        if(suppStack.size() == 0 || suppStack.peek() >= val)
            suppStack.push(val);
        
        return;
    }
    
    public void pop() {
        int res = 0;
        if(!stack.isEmpty())
            res = stack.pop();
        
        if(!suppStack.isEmpty() && suppStack.peek() == res)
            suppStack.pop();
        
        return;
            
    }
    
    public int top() {
        if(!stack.isEmpty())
            return stack.peek();
        
        return -1;
    }
    
    public int getMin() {
        if(!suppStack.isEmpty())
            return suppStack.peek();
        
        return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
