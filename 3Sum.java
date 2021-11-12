class 3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> list = new HashSet<>();
        
        if(nums == null || nums.length == 0)
            return new ArrayList<>(list);
        
        for(int i = 0; i < nums.length-2; i++){
            int j = i+1;
            int k = nums.length-1;
            
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                
                if(sum == 0){
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }else if(sum > 0){
                    k--;
                }else if(sum < 0){
                    j++;
                }
            }
        }
        return new ArrayList<>(list);
    }
}
