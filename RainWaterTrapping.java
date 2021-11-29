class RainWaterTrapping {
    public int trap(int[] height) {
        // find the global maximum on left side and right side. And then find the minimum 
        // of those two
        int len = height.length;
        
        int[] left = new int[len];
        left[0] = height[0];
        for(int i = 1; i < len; i++){
            left[i] = Math.max(left[i-1], height[i]);
        }
        
        int[] right = new int[len];
        right[len-1] = height[len-1];
        
        for(int i = len-2; i>=0; i--){
            right[i] = Math.max(right[i+1], height[i]);
        }
        
        int[] water = new int[len];
        for(int i = 0; i < len; i++){
            water[i] = Math.min(left[i], right[i]) - height[i];
        }
        int sum = 0;
        
        for(int i = 0; i < len; i++){
            sum += water[i];
        }
        return sum;
    }
}
