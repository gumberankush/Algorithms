class DistinctNumbers {
    public int[] distinctNumbers(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int wStart = 0;
        int[] ans = new int[nums.length-k+1];
        
        for(int wEnd = 0; wEnd < nums.length; wEnd++){
            if(!map.containsKey(nums[wEnd])){
                map.put(nums[wEnd], 1);
            }else{
                map.put(nums[wEnd], map.get(nums[wEnd])+1);
            }
            
            if((wEnd-wStart+1) == k){
                ans[wStart] = map.size();
            }
            
            if((wEnd-wStart+1) >= k){
                if(map.get(nums[wStart]) > 1){
                    map.put(nums[wStart], map.get(nums[wStart])-1);
                }else{
                    map.remove(nums[wStart]);  
                }
                wStart++;
            }
        }
        return ans;
    }
}
