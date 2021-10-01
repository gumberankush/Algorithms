class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        
        Arrays.sort(candidates);
        List<Integer> input = new ArrayList<>();
        for(int candidate: candidates){
            input.add(candidate);
        }
        
        List<Integer> output = new ArrayList<>();
        int len = candidates.length;
        solve(input, output, target, 0, len, res, 0);
        return res;
    }
    
    public void solve(List<Integer> input, List<Integer> output, int target, int sum, int len, List<List<Integer>> res, int start){
        if(sum == target){
            res.add(new ArrayList<>(output));
            return;
        }
        
        if(sum > target){
            return;
        }
        
        for(int i = start; i < len; i++){
           if(i > start && input.get(i) == input.get(i-1)) 
               continue; // skip duplicates
            
            output.add(input.get(i));
            solve(input, output, target, sum+input.get(i), len, res, i+1);
            output.remove(output.size()-1);
        }
    }
}
