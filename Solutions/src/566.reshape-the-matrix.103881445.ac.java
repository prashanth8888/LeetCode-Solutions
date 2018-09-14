public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int element_size = r * c;
        int matrix_size = nums.length * nums[0].length;
        int[][] result_num = new int[r][c];
        if(element_size != matrix_size)
            return nums;
        else
            {
                //Recacalculate the shape here
                int row = 0;
                int col = 0;
                for(int i=0; i < nums.length; i++){
                for(int j=0; j < nums[i].length; j++){
                        result_num[row][col] = nums[i][j];
                        col++;
                        if(col >= c) {
                            row++;
                            col = 0;
                        }
                    }
                }
                return result_num;
            }
    }
}
