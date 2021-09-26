import java.util.ArrayList;
import java.util.List;

class GenerateParanthesis {
    public List<String> generateParenthesis(int n) {
        int open = n;
        int close = n;
        List<String> res = new ArrayList<>();
        
        String output = new String();
        
        solve(open, close, res, output);
        return res;
    }
    
    public void solve(int open, int close, List<String> res, String output){
        if(open == 0 && close == 0){
            res.add(output);
            return;
        }
        
        if(open != 0){
            String op1 = output;
            StringBuilder sbop1 = new StringBuilder(op1);
            op1 = sbop1.append("(").toString();
            solve(open-1, close, res, op1);
        }
        if(open < close){
            String op2 = output;
            StringBuilder sbop2 = new StringBuilder(op2);
            op2 = sbop2.append(")").toString();
            solve(open, close-1, res, op2);
        }
    }


    public static void main(String[] args) {
        GenerateParanthesis obj = new GenerateParanthesis();
        List<String> ans = obj.generateParenthesis(3);

        for(String str: ans){
            System.out.println(str);
        }

    }
}
