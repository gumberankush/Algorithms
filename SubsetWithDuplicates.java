class SubsetWithDuplicates {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        // Ref: https://leetcode.com/problems/subsets-ii/discuss/169226/Java-Two-Way-of-Recursive-thinking
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtracking(nums, 0, res, false, new ArrayList<>());
        
        return res;
    }
    
    private void backtracking(int[] nums, int index, List<List<Integer>> res, boolean choosePre, List<Integer> currList){
        if(nums.length == index){
            res.add(new ArrayList<>(currList));
            return;
        }
        backtracking(nums, index+1, res, false, currList);
        if(index >= 1 && nums[index] == nums[index-1] && !choosePre)
            return;
        
        currList.add(nums[index]);
        backtracking(nums, index+1, res, true, currList);
        currList.remove(currList.size()-1);
        
    }
}
