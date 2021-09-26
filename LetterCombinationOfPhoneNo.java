class LetterCombinationOfPhoneNo {
    public List<String> letterCombinations(String digits) {
        
        if(digits.length() == 0)
            return new ArrayList<String>();
        
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        
        List<String> res = new ArrayList<>();
        
        String output = new String();
        
        String input = digits;
        int len = input.length();
        
        solve(input, output, res, map, len);
        
        return res;
    }
    
    public void solve(String input, String output, List<String> res, Map<Character, List<Character>> map, int len){
        if(output.length() == len){
            res.add(new String(output));
            return;
        }
        
        List<Character> charList = map.get(input.charAt(0));
        
        if(input.length() > 0)
            input = input.substring(1, input.length());
        
        for(int i = 0; i < charList.size(); i++){
            solve(input, output+charList.get(i), res, map, len);
        }
    }
}
