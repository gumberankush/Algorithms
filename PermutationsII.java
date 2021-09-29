import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PermutationsII {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> input = new ArrayList<>();
        Arrays.sort(nums);
        for(int num: nums){
            input.add(num);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        
        List<Integer> output = new ArrayList<>();
        int len = nums.length;
        
        boolean[] visited = new boolean[nums.length];
        
        backtrack(input, output, res, len, visited);
        
        return res;
    }
    
    public void backtrack(List<Integer> input, List<Integer> output, List<List<Integer>> res, int len, boolean[] visited){
        if(output.size() == len){
            res.add(new ArrayList<>(output));
            return;
        }
        
        for(int i = 0; i < len; i++){
            if(visited[i] || (i > 0 && input.get(i) == input.get(i-1) && !visited[i - 1]))
                continue;
            output.add(input.get(i));
            visited[i] = true;
            backtrack(input, output, res, len, visited);
            visited[i] = false;
            output.remove(output.size()-1);
        }
    }

    public static void main(String[] args) {
        PermutationsII obj = new PermutationsII();
        obj.permute(new int[]{1, 1, 2});
    }
}
