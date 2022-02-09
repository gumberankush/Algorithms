class AlienDictionary {
    public String alienOrder(String[] words) {
        // Create adjacent list
        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> count = new HashMap<>();
        for(String word: words){
            for(Character c: word.toCharArray()){
                count.put(c, 0);
                adjList.put(c, new ArrayList<>());
            }
        }
        
        // Create edges
        for(int i = 0; i < words.length-1; i++){
            String word1 = words[i];
            String word2 = words[i+1];
            
            if(word1.length() > word2.length() && word1.startsWith(word2)){
                return "";
            }
            
            for(int j = 0; j < Math.min(word1.length(), word2.length()); j++){
                if(word1.charAt(j) != word2.charAt(j)){
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    count.put(word2.charAt(j), count.get(word2.charAt(j)) + 1); // calculating indegree
                    break;
                }
            }
        }
        
        // Toplogical sort
        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        
        for(Character c: count.keySet()){
            if(count.get(c) == 0){
                queue.add(c);
            }
        }
        
        while(!queue.isEmpty()){
            char c = queue.poll();
            sb.append(c);
            
            for(Character ch: adjList.get(c)){
                count.put(ch, count.get(ch) - 1);
                
                if(count.get(ch) == 0){
                    queue.add(ch);
                }
            }
        }
        
        if(sb.length() < count.size())
            return "";
        
        return sb.toString();
    }
}
