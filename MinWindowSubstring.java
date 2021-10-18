class MinWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        
        for(int i = 0; i < t.length(); i++){
            char tChar = t.charAt(i);
            if(!tMap.containsKey(tChar)){
                tMap.put(tChar, 1);
            }else{
                tMap.put(tChar, tMap.get(tChar)+1);
            }
        }
        
        int wStart = 0;
        int count = tMap.size();
        String temp = new String();
        int minLeft = 0;
        int minLen = s.length()+1;
        
        for(int wEnd = 0; wEnd < s.length(); wEnd++){
            char sChar = s.charAt(wEnd);
            if(tMap.containsKey(sChar)){
                tMap.put(sChar, tMap.get(sChar)-1);
                
                if(tMap.get(sChar) == 0){
                    count--;
                }
            }
            
            while(count == 0){
                if(wEnd-wStart+1 < minLen) {
                    minLeft = wStart;
                    minLen = wEnd-wStart+1;
                }
                if(tMap.containsKey(s.charAt(wStart))){
                    tMap.put(s.charAt(wStart), tMap.get(s.charAt(wStart))+1);
                    
                    if(tMap.get(s.charAt(wStart)) > 0){
                        count++;
                    }
                }
                wStart++;
            }     
        }
        
        if(minLen>s.length())
            return "";
        
        return s.substring(minLeft, minLeft+minLen);
    }
}
