class Anagrams {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        
        for(int i = 0; i < p.length(); i++){
            char pChar = p.charAt(i);
            if(!pMap.containsKey(pChar)){
                pMap.put(pChar, 1);
            }else{
                pMap.put(pChar, pMap.get(pChar)+1);
            }
        }
        
        List<Integer> res = new ArrayList<>();
        int wStart = 0;
        
        for(int wEnd = 0; wEnd < s.length(); wEnd++){
            char sChar = s.charAt(wEnd);
            
           if(!sMap.containsKey(sChar)){
                sMap.put(sChar, 1);
            }else{
                sMap.put(sChar, sMap.get(sChar)+1);
            }
            
            if((wEnd-wStart+1) == p.length()){
                
                if(pMap.equals(sMap)){
                    res.add(wStart);
                }
                
                if(sMap.get(s.charAt(wStart)) > 1){
                    sMap.put(s.charAt(wStart), sMap.get(s.charAt(wStart))-1);
                }else{
                    sMap.remove(s.charAt(wStart));
                }
                wStart++;
            }
        }
        return res;
    }
}
