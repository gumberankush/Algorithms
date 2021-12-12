class SortColors {
    public void sortColors(int[] nums) {
        
        int currPtr = 0, lo = 0, hi = nums.length-1;
        
        while(currPtr <= hi){
            if(nums[currPtr] == 0)
                swap(nums, currPtr++, lo++);
            else if(nums[currPtr] == 1)
                currPtr++;
            else if(nums[currPtr] == 2)
                swap(nums, currPtr, hi--);
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
