class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        // Find nearest smallest to left and nearest smallest to right and get the difference in indices between these two lists
        Stack<int[]> stack1 = new Stack<>();
        Stack<int[]> stack2 = new Stack<>();
        int len = heights.length;
        int[] nsl = new int[len];
        int[] nsr = new int[len];
        
        // nearest smaller to right
        for(int i = len-1; i >= 0; i--){
            if(stack1.isEmpty())
                nsr[i] = len;
            
            if(stack1.size() > 0 && stack1.peek()[0] < heights[i]){
                nsr[i] = stack1.peek()[1];
            }else if(stack1.size() > 0 && stack1.peek()[0] >= heights[i]){
                while(stack1.size() > 0 && stack1.peek()[0] >= heights[i]){
                    stack1.pop();
                }
                if(stack1.isEmpty()){
                    nsr[i] = len;
                }else{
                    nsr[i] = stack1.peek()[1];
                }
            }
            stack1.push(new int[]{heights[i], i});
        }
        
        // nearest smaller to left
        for(int i = 0; i < len; i++){
            if(stack2.isEmpty())
                nsl[i] = -1;
            
            if(stack2.size() > 0 && stack2.peek()[0] < heights[i]){
                nsl[i] = stack2.peek()[1];
            }else if(stack2.size() > 0 && stack2.peek()[0] >= heights[i]){
                while(stack2.size() > 0 && stack2.peek()[0] >= heights[i]){
                    stack2.pop();
                }
                if(stack2.isEmpty()){
                    nsl[i] = -1;
                }else{
                    nsl[i] = stack2.peek()[1];
                }
            }
            stack2.push(new int[]{heights[i], i});
        }
        
        int maxArea = Integer.MIN_VALUE;
        
        for(int i = 0; i < len; i++){
            maxArea = Math.max(maxArea, (nsr[i]-nsl[i]-1)*heights[i]);
        }
        
        return maxArea;    
    }
}
