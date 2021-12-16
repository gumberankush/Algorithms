class MajorityElement {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(count == 0){
                candidate = nums[i];
            }
            if(candidate == nums[i]){
                count += 1;
            }else{
                count -= 1;
            }
        }
        // since it is mentioned in the question that there will be majority element no need to traverse again to find the count of candidate.
        return candidate;
    }
}
