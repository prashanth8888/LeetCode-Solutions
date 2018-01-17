class Solution {
    
    static class WordNode{
        public String word;
        public int numberOfSteps;
        
        public WordNode(String word, int steps){
            this.word = word;
            this.numberOfSteps = steps;
        }
    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        WordNode node = new WordNode(beginWord, 1);
        Queue<WordNode> queue = new LinkedList<>();
        Set<String> wordListHashSet = new HashSet<>();
        wordListHashSet.addAll(wordList);
        
        queue.add(node);
        int currSteps = 1;
        
        while(!queue.isEmpty()){
            WordNode currNode = queue.poll();
            String currWord = currNode.word;
            int numSteps = currNode.numberOfSteps;
                
            
            if(currWord.equals(endWord)){
                return numSteps;
            }
            char[] currWordArray = currWord.toCharArray();
            int size = currWordArray.length;
            for(int i = 0; i < size; i++){
                char currChar = currWordArray[i];
                
                for(char c='a'; c <= 'z'; c++){
                    
                    currWordArray[i] = c;
                    String formedWord = new String(currWordArray);
                    
                    if(wordListHashSet.contains(formedWord)){
                        queue.add(new WordNode(formedWord, numSteps + 1));
                        wordListHashSet.remove(formedWord);
                    }
                    currWordArray[i] = currChar;
                }
            }
        }
        
        return 0;
        
        
    }
}
