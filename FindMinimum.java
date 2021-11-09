class FindMinimum {
    public int findMin(int[] nums) {
        
        int start = 0, end = nums.length-1;
        int size = nums.length;
        
        while(start <= end){
            
            if (nums[start] < nums[end]) { // Sorted as a whole
                return nums[start];
            }
            int mid = start + (end-start)/2;
            int next = (mid + 1) % size;
            int prev = (mid + size - 1) % size;
            
            if(nums[mid] <= nums[prev] && nums[mid] <= nums[next]){
                return nums[mid];
            }else if(nums[start] <= nums[mid]){ // move towars unsorted part
                start = mid+1;
            }else if(nums[mid] <= nums[end]){
                end = mid - 1;
            }     
        }
        return nums[start];
    }
}
