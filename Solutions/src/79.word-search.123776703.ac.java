class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        
        boolean[][] visited = new boolean[rows][cols];
        for(int i = 0;  i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(helper(board, i, j, visited, 0, word)) return true;
            }
        }
        
        return false;
        
    }
    
    public boolean helper(char[][] board, int row, int col, boolean[][] visited, int wordIndex, String word){
        
        if(wordIndex == word.length()) return true;
        
        if(row >= board.length || col >= board[0].length || row < 0 || col < 0) return false;
        
        if(visited[row][col] == true) return false;
        
        if(board[row][col] != word.charAt(wordIndex)) return false;
    
        
        // System.out.println(board[row][col]);
        visited[row][col] = true;
        boolean res = helper(board, row + 1, col, visited, wordIndex + 1, word) || 
                  helper(board, row - 1, col, visited, wordIndex + 1, word) || 
                  helper(board, row, col + 1, visited, wordIndex + 1, word) || 
                  helper(board, row, col - 1, visited, wordIndex + 1, word);
        
        visited[row][col] = false;
            
        return res;
    }
}
