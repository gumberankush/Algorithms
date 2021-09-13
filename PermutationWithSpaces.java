import java.util.ArrayList;
import java.util.List;

public class PermutationWithSpaces {

    List<String> list = new ArrayList();

    List<String> permutation(String S){
        String output = S.substring(0, 1);
        String input = S.substring(1, S.length());
        printPatterns(output, input);
        return list;
    }

    public void printPatterns(String output, String input){
        if(input.length() == 0){
            list.add(output);
            return;
        }

        String op1 = output;
        StringBuilder sbop1 = new StringBuilder(op1);

        // Insert with space
        sbop1.append(" ");
        op1 = sbop1.append(input.charAt(0)).toString();

        // Insert without space
        String op2 = output;
        StringBuilder sbop2 = new StringBuilder(op2);
        op2 = sbop2.append(input.charAt(0)).toString();

        // delete the character which has been processed
        input = input.substring(1, input.length());

        printPatterns(op1, input);
        printPatterns(op2, input);

    }

    public static void main(String[] args) {
        PermutationWithSpaces obj = new PermutationWithSpaces();
        List<String> print = obj.permutation("ABC");

        for (String s: print){
            System.out.println(s);
        }
    }
}
