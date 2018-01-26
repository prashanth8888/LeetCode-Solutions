public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int rowLength = obstacleGrid.length - 1;
        int colLength = obstacleGrid[0].length - 1;
        
        for(int i = 0; i < obstacleGrid.length; i++){
            for(int j = 0; j < obstacleGrid[i].length; j++){
                if(obstacleGrid[i][j] == 1)
                    obstacleGrid[i][j] = 0;
                else if(i == 0 && j == 0){
                    obstacleGrid[i][j] = 1;
                }
                else if(i == 0){
                    obstacleGrid[i][j] = obstacleGrid[i][j-1] * 1;
                }
                else if(j == 0){
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] * 1;
                }
                else{
                    obstacleGrid[i][j] = obstacleGrid[i][j-1] + obstacleGrid[i-1][j];
                }
            }
        }
        
        return obstacleGrid[rowLength][colLength];
        
    }
}
