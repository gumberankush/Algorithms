import java.util.ArrayList;
import java.util.List;

class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        String input = s;
        String output = new String();
        List<String> list = new ArrayList();
        solve(input, output, list);
        return list;
    }

    public void solve(String input, String output, List<String> list){
        if(input.length() == 0){
            list.add(output);
            return;
        }

        if(!Character.isDigit(input.charAt(0))){
            String op1 = output;
            StringBuilder sbop1 = new StringBuilder(op1);
            op1 = sbop1.append(Character.toLowerCase(input.charAt(0))).toString();

            String op2 = output;
            StringBuilder sbop2 = new StringBuilder(op2);
            op2 = sbop2.append(Character.toUpperCase(input.charAt(0))).toString();

            input = input.substring(1, input.length());

            solve(input, op1, list);
            solve(input, op2, list);
        }else{
            String op1 = output;
            StringBuilder sbop1 = new StringBuilder(op1);
            op1 = sbop1.append(input.charAt(0)).toString();

            input = input.substring(1, input.length());

            solve(input, op1, list);
        }
    }
}
