class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<String> output = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        solve(s, output, res, 0);
        
        return res;
    }
    
    public void solve(String input, List<String> output, List<List<String>> res, int start){
        if(start == input.length()){
            res.add(new ArrayList<>(output));
            return;
        }
        
        for(int i = start; i < input.length(); i++){
            if(isPalindrome(input, start, i)){
                output.add(input.substring(start, i+1));
                solve(input, output, res, i+1);
                output.remove(output.size()-1);
            }
        }    
    }
    
    public boolean isPalindrome(String s, int low, int high){
        while(low < high){
            if(s.charAt(low) != s.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }
}
