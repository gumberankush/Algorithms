class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        
        Deque<Integer> queue = new ArrayDeque<>();
        int wStart = 0;
        int j = 0;
        
        for(int wEnd = 0; wEnd < nums.length; wEnd++){
            while(!queue.isEmpty() && queue.peekLast() < nums[wEnd]){
                queue.pollLast();
            }
            queue.offer(nums[wEnd]);
            
            if((wEnd-wStart+1) == k){
                ans[wStart] = queue.peekFirst();
            }
            
            if((wEnd-wStart+1) >= k){
                if(queue.peekFirst() == nums[wStart]){
                    queue.pollFirst();
                }
                wStart++;
            }
        }
        
        return ans;
    }
}
