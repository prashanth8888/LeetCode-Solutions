class Solution {
    public void rotate(int[][] matrix) {
        
        
        //Row-wise exchange of the rows first
        int upperRowPointer = 0;
        int lowerRowPointer = matrix.length - 1;
        int cols = matrix[0].length;
        
        while(lowerRowPointer > upperRowPointer){
            
            for(int i = 0 ; i < cols; i++){
                // System.out.println(upperRowPointer + ":" + i + ":::" + lowerRowPointer + ":" + i);
                swap(matrix, upperRowPointer, i, lowerRowPointer, i);
            }
            
            upperRowPointer++;
            lowerRowPointer--;
        }
        
        // for(int i = 0; i < matrix.length; i++){
        //     for(int j = 0; j < cols; j++){
        //         System.out.print(matrix[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        //Now exchange the symmertical elements
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = i+1; j < cols; j++){
                swap(matrix, i, j, j, i);
            }
        }
        
    }
    
    public void swap(int[][] matrix, int row1, int col1, int row2, int col2){
        
            int temp = matrix[row1][col1];
            matrix[row1][col1] = matrix[row2][col2];
            matrix[row2][col2] = temp;
        
        return;
    }
}
