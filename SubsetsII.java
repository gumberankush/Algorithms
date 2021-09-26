import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> input = new ArrayList<>();

        for(int num: nums){
            input.add(num);
        }
        solve(input, new ArrayList<>(), subsets);

        return subsets;

    }

    public void solve(List<Integer> input, List<Integer> output, List<List<Integer>> subsets){
        if(input.size() == 0){
            if(!subsets.contains(output)){
                subsets.add(output);
            }
            return;
        }

        List<Integer> op1 = new ArrayList<>(output);
        List<Integer> op2 = new ArrayList<>(output);

        op2.add(input.get(0));

        List<Integer> clone = new ArrayList<>(input);
        clone.remove(0);

        solve(clone, op1, subsets);
        solve(clone, op2, subsets);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        SubsetsII obj = new SubsetsII();
        obj.subsetsWithDup(nums);
    }
}
