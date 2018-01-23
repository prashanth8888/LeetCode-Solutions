class Solution {
    public void setZeroes(int[][] matrix) {
        
        boolean row = false, col = false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == 0){
                    if(i == 0) row = true;
                    if(j == 0) col = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        for(int i = 1; i < rows; i++){
            if(matrix[i][0] == 0){
                //Make the whole row as zeroes
                for(int j=1; j < cols; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        
        for(int j=1; j < cols; j++){
            if(matrix[0][j] == 0){
                for(int i = 1; i < rows; i++){
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(row){
            for(int j=0; j < cols; j++){
                matrix[0][j] = 0;
            }
        }
        
        if(col){
            for(int i=0; i < rows; i++){
                matrix[i][0] = 0;
            }
        }
        
    }
}
