class 4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 4)
            return res;
        
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-3; i++){
            // avoid duplicates
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            for(int j = i+1; j < nums.length-2; j++){
                if(j > i+1 && nums[j] == nums[j-1])
                    continue;
                
                int left = j+1, right = nums.length-1;
                while(left < right){
                    int sum4 = nums[i] + nums[j] + nums[left] + nums[right];
                    
                    if(sum4 == target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        left++;
                        right--;
                        res.add(list);
                        while(left < right && nums[left] == nums[left-1]){
                            left++;
                        }
                        while(left < right && nums[right] == nums[right + 1]){
                            right--;
                        }
                    }else if(sum4 > target){
                        right--;
                    }else{
                        left++;
                    }
                }
            }
        }
        return res;
    }
}
