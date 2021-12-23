class LongestConsecutiveSeq {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for(int num: nums){
            set.add(num);
        }
        
        int currCount = 1;
        int maxCount = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i]-1)){
                int currNum = nums[i];
                
                while(set.contains(currNum+1)){
                    currCount += 1;
                    currNum = currNum+1;
                }
                maxCount = Math.max(maxCount, currCount);
            }
            currCount = 1;
        }
        
        return maxCount;
    }
}
