class Trie {
    
    private static TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(); //Initial TrieNode - Will be empty
    }
    
    static class TrieNode{
        
        HashMap<Character, TrieNode> children;
        boolean lastCharacter;
        
        public TrieNode(){
            children = new HashMap<>();
            lastCharacter = false;
        }
    }
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        TrieNode current = root;
        
        char[] wordArray = word.toCharArray();
        int size = wordArray.length;
        
        for(int i = 0; i < size ; i++){
            TrieNode node = current.children.get(wordArray[i]); //Automatically goes into the next loop
            if(node == null){
                //Create a new children here and insert it against the parent - parent will always be current
                node = new TrieNode();
                current.children.put(wordArray[i], node); //Even if it's empty or if it's has character - This will work
            }
            current = node;
        }
        
        current.lastCharacter = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        TrieNode current = root;
        
        char[] wordArray = word.toCharArray();
        int size = wordArray.length;
        
        for(int i=0; i < size; i++){
             if(!current.children.containsKey(wordArray[i])) return false;
             else 
                 current = current.children.get(wordArray[i]);
        }
        
        return current.lastCharacter;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
        TrieNode current = root;
        
        char[] wordArray = prefix.toCharArray();
        int size = wordArray.length;
        
        for(int i = 0; i < size; i++){
            // System.out.println("Here");
            if(!current.children.containsKey(wordArray[i])) return false;
            else
                current = current.children.get(wordArray[i]);
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
