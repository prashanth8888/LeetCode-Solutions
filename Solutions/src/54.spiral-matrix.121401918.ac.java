class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        if(matrix.length == 0) return new ArrayList<Integer>();
        
        List<Integer> resultList = new ArrayList<Integer>();
        
        int rows = matrix.length - 1; 
        int cols = matrix[0].length - 1;
        
        int rows1 = 0;
        int cols1 = 0;
        
        while(rows >= rows1 && cols >= cols1){
            //Traverse the Top-row
            for(int i = cols1; i <= cols ;i++){
                resultList.add(matrix[rows1][i]);
            }
            //Traverses the right path
            for(int j = rows1 + 1; j <= rows; j++){
                resultList.add(matrix[j][cols]);
            }
            
            if(rows1 < rows  && cols1 < cols){
                //Traverse the right to left path
                for(int k = cols-1; k > cols1; k--){
                    resultList.add(matrix[rows][k]);
                }
                //Traverse from left bottom to top
                for(int l = rows; l > rows1; l--){
                    resultList.add(matrix[l][cols1]);
                }
            }

            
            rows1++;
            rows--;
            cols1++;
            cols--;
        }

            
        return resultList;
    }
}
