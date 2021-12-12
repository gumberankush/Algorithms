class MaxSubarray {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int maxSum = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            sum = Math.max(nums[i], nums[i]+sum);
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
