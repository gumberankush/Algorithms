class FirstAndLastElement {
    public int[] searchRange(int[] nums, int target) {   
        int[] res = {-1, -1};
        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);
        return res;      
    }
    
    public int findFirst(int[] nums, int target){
        int start = 0, end = nums.length-1;
        int resStart = -1;
        
        while(start <= end){
            int mid = start + (end-start)/2;
            
            if(nums[mid] == target){
                resStart = mid;
                end = mid - 1;
            }else if(target < nums[mid]){
                end = mid - 1;
            }else{
                start = mid + 1; 
            }
        }
        return resStart;
    }
    
    public int findLast(int[] nums, int target){
        int start = 0, end = nums.length-1;
        int resEnd = -1;
        
        while(start <= end){
            int mid = start + (end-start)/2;
            
            if(nums[mid] == target){
                resEnd = mid;
                start = mid + 1;
            }else if(target < nums[mid]){
                end = mid - 1;
            }else{
                start = mid + 1; 
            }
        }
        return resEnd;
    }
}
