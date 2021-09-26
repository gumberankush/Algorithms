import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {

        List<Integer> input = new ArrayList<>();
        for(int num: nums){
            input.add(num);
        }
        List<List<Integer>> subsets = new ArrayList<>();

        solve(subsets, input, new ArrayList<>());

        return subsets;
    }

    public void solve(List<List<Integer>> subsets, List<Integer> input, List<Integer> output){
        if(input.size() == 0){
            subsets.add(output);
            return;
        }

        List<Integer> op1 = new ArrayList<>(output);
        List<Integer> op2 = new ArrayList<>(output);

        op2.add(input.get(0));

        List<Integer> clone = new ArrayList<>(input);
        clone.remove(0);

        solve(subsets, clone, op1);
        solve(subsets, clone, op2);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Subsets obj = new Subsets();
        obj.subsets(nums);
    }
}
