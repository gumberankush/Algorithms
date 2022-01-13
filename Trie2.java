public class Trie2 {
    class Node{
        Node[] links = new Node[26];
        int cp = 0;
        int cw = 0;
        
        public boolean containsKey(char ch){
            return links[ch-'a'] != null;
        }
        
        public void put(char ch, Node node){
            links[ch-'a'] = node;
        }
        
        public void incrementPrefix(){
            cp++;
        }
        
        public void incrementWord(){
            cw++;
        }
        
        public void decrementPrefix(){
            cp--;
        }
        
        public void decrementWord(){
            cw--;
        }
        
        public Node get(char ch){
            return links[ch-'a'];
        }
        
        public int getWordCount(){
            return cw;
        }
        
        public int getPrefixCount(){
            return cp;
        }
    }
    
    Node root;
    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        
        for(int i = 0; i < word.length(); i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
            node.incrementPrefix();
        }
        node.incrementWord();
    }

    public int countWordsEqualTo(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            if(!node.containsKey(word.charAt(i))){
                return 0;
            }
            node = node.get(word.charAt(i));
        }
        return node.getWordCount();
    }

    public int countWordsStartingWith(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            if(!node.containsKey(word.charAt(i))){
                return 0;
            }
            node = node.get(word.charAt(i));
        }
        return node.getPrefixCount();
    }

    public void erase(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            if(node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
                node.decrementPrefix();
            }else{
                return;
            }
        }
        node.decrementWord();
    }

}
