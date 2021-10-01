class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> input = new ArrayList<>();
        Arrays.sort(candidates);
        
        for(int num: candidates){
            input.add(num);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        
        int len = candidates.length;
        
        solve(input, output, target, res, len, 0);
        
        for(List<Integer> each: res){
            Collections.sort(each);
            
            if(!ans.contains(each))
                ans.add(each);
        }
        
        return ans;
    }
    
    public void solve(List<Integer> input, List<Integer> output, int target, List<List<Integer>> res, int len, int sum){
        
        // result added
        if(sum == target){
            // In this case sorting the output will affect the original output
            //Collections.sort(output);
            if(!res.contains(output))
                res.add(new ArrayList<>(output));
            return;
        }
        
         // backtrack - prune the recursive tree
        if(sum > target){
            return;
        }
    
        // do recursion
        for(int i = 0; i < len; i++){
            output.add(input.get(i));
            solve(input, output, target, res, len, sum+input.get(i));
            output.remove(output.size() - 1);
        }
    }
}
