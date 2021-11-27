class StockSpanner {
    
    // Next greater to Left - Approach
    Stack<int[]> stack;
    List<Integer> list;
    int index;

    public StockSpanner() {
        stack = new Stack<>();
        list = new ArrayList<>();
        index = 0;
    }
    
    public int next(int price) {
        if(stack.isEmpty())
            list.add(-1);
        
        if(stack.size() > 0 && stack.peek()[0] > price){
            list.add(stack.peek()[1]);
        }else if(stack.size() > 0 && stack.peek()[0] <= price){
            while(stack.size() > 0 && stack.peek()[0] <= price){
                stack.pop();
            }
            if(stack.isEmpty()){
                list.add(-1);
            }else{
                list.add(stack.peek()[1]);
            }
        }  
        stack.push(new int[]{price, index++});
        
        // return the last elementn i - v[i]
        return (list.size()-1) - list.get(list.size()-1);
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
