class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int wStart = 0;
        int max = Integer.MIN_VALUE;
        
        for(int wEnd = 0; wEnd < s.length(); wEnd++){
            char sEnd = s.charAt(wEnd);
            if(!map.containsKey(sEnd)){
                map.put(sEnd, 1);
            }else{
                map.put(sEnd, map.get(sEnd)+1);
            }
            
            if(map.size() == wEnd-wStart+1){
                max = Math.max(max, wEnd-wStart+1);
            }
            
            while(map.size() < wEnd-wStart+1){
                char sStart = s.charAt(wStart);
                map.put(sStart, map.get(sStart)-1);
                
                if(map.get(sStart) == 0){
                    map.remove(sStart);
                }
                wStart++;
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
