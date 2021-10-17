class LongestSubstringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int wStart = 0;
        Map<Character, Integer> map = new HashMap<>();
        int longest = Integer.MIN_VALUE;
        
        for(int wEnd = 0; wEnd < s.length(); wEnd++){
            char sChar = s.charAt(wEnd);
            if(map.containsKey(sChar)){
                map.put(sChar, map.get(sChar)+1);
            }else{
                map.put(sChar, 1);
            }
            
            while(map.size() > k){
                if(map.get(s.charAt(wStart)) > 1){
                    map.put(s.charAt(wStart), map.get(s.charAt(wStart))-1);
                }else{
                    map.remove(s.charAt(wStart));
                }
                
                wStart++;
            }
            // No need to check equal to K condition because it is atmost
            //if(map.size() == k){
            longest = Math.max(longest, wEnd-wStart+1);
            //}
        }
        return longest==Integer.MIN_VALUE ? 0 : longest;
    }
}
