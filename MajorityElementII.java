class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0;
        int count2 = 0;
        
        int candidate1 = Integer.MIN_VALUE;
        int candidate2 = Integer.MIN_VALUE;
        
        List<Integer> res = new ArrayList<>();
        for(int num: nums){
            if(candidate1 == num){
                count1++;
            }else if(candidate2 == num){
                count2++;
            }else if(count1 == 0){
                candidate1 = num;
                count1 = 1;
            }else if (count2 == 0){
                candidate2 = num; 
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        // 2nd pass
        for(int num: nums){
            if(candidate1 == num){
                count1++;
            }
            if(candidate2 == num){
                count2++;
            }
        }
        
        if(count1 > nums.length/3)
            res.add(candidate1);
        if(count2 > nums.length/3)
            res.add(candidate2);
        
        return res;
    }
}
