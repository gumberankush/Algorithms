class DistinctCharacters {
    public int countGoodSubstrings(String s) {
        int wStart = 0;
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        
        for(int wEnd = 0; wEnd < s.length(); wEnd++){
            char c = s.charAt(wEnd);
            if(!map.containsKey(c)){
                map.put(c, 1);
            }else{
                map.put(c, map.get(c)+1);
            }
            
            if(((wEnd-wStart+1) == 3) && map.size() == 3){
                count++;
            }
            
            if((wEnd-wStart+1) >= 3){
                char cStart = s.charAt(wStart);
                if(map.get(cStart) > 1){
                    map.put(cStart, map.get(cStart)-1);
                }else{
                    map.remove(cStart);
                }
                wStart++;
            }
        }
        return count;
    }
}
