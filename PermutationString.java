class PermutationString {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();
        
        for(int i = 0; i < s1.length(); i++){
            char s1Char = s1.charAt(i);
            
            if(s1Map.containsKey(s1Char)){
                s1Map.put(s1Char, s1Map.get(s1Char)+1);
            }else{
                s1Map.put(s1Char, 1);
            }
        }
        int wStart = 0;
        
        for(int wEnd = 0; wEnd < s2.length(); wEnd++){
            char s2Char = s2.charAt(wEnd);
            
            if(s2Map.containsKey(s2Char)){
                s2Map.put(s2Char, s2Map.get(s2Char)+1);
            }else{
                s2Map.put(s2Char, 1);
            }
            
            if((wEnd-wStart+1) == s1.length()){
                if(s1Map.equals(s2Map))
                    return true;
                
                if(s2Map.get(s2.charAt(wStart)) > 1){
                    s2Map.put(s2.charAt(wStart), s2Map.get(s2.charAt(wStart)) - 1);
                }else{
                    s2Map.remove(s2.charAt(wStart));
                }
                wStart++;
            }
        }
        return false;
    }
}
