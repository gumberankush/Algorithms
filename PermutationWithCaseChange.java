import java.util.ArrayList;
import java.util.List;

public class PermutationWithCaseChange {

    List<String> list = new ArrayList<String>();


    public List<String> permutation(String s){
        String output = new String();
        String input = s;
        solve(output, input);
        return list;
    }

    public void solve(String output, String input){
        if(input.length() == 0){
            list.add(output);
            return;
        }

        // Creating 1st node for lower case choice
        String op1 = output;
        StringBuilder sbop1 = new StringBuilder(op1);
        op1 = sbop1.append(Character.toLowerCase(input.charAt(0))).toString();

        // creating 2nd node for upper case choice
        String op2 = output;
        StringBuilder sbop2 = new StringBuilder(op2);
        op2 = sbop2.append(Character.toUpperCase(input.charAt(0))).toString();

        input = input.substring(1, input.length());

        solve(op1, input);
        solve(op2, input);

    }


    public static void main(String[] args) {
        PermutationWithCaseChange obj = new PermutationWithCaseChange();
        List<String> print = obj.permutation("ABC");

        for (String s: print){
            System.out.println(s);
        }
    }
}
