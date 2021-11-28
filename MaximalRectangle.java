class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        
        if(matrix == null || matrix.length == 0)
            return 0;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] intMatrix = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                intMatrix[i][j] = Character.getNumericValue(matrix[i][j]);
                //System.out.println(intMatrix[i][j]);
            }
        }
        
        int[] res = new int[intMatrix[0].length];
        
        for(int i = 0; i < intMatrix[0].length; i++){
            res[i] = intMatrix[0][i];
        }
        
        int maxArea = largestRectangeInHistogram(res);
        
        for(int i = 1; i < intMatrix.length; i++){
            for(int j = 0; j < intMatrix[0].length; j++){
                if(intMatrix[i][j] == 0){
                    res[j] = 0;
                }else{
                    res[j] = res[j] + intMatrix[i][j];
                }
            }
            maxArea = Math.max(maxArea, largestRectangeInHistogram(res));
        }
        return maxArea;
    }
    
    public int largestRectangeInHistogram(int[] heights){
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
