class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int len = temperatures.length;
        int[] res = new int[len];
        
        for(int i = len-1; i >= 0; i--){
            if(stack.isEmpty())
                res[i] = 0;
            else if(stack.size() > 0 && stack.peek()[0] > temperatures[i]){
                res[i] = stack.peek()[1]-i;
            }else if(stack.size() > 0 && stack.peek()[0] <= temperatures[i]){
                while(stack.size() > 0 && stack.peek()[0] <= temperatures[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    res[i] = 0;
                }else{
                    res[i] = stack.peek()[1]-i;
                }
            }
            stack.push(new int[]{temperatures[i], i});
        }
        return res;
        
    }
}
