class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        int[][] moves = {{2,-1},{2,1},{-2,-1},{-2,1},{1,-2},{1,2},{-1,-2},{-1,2}};
        
        double[][] dpStore = new double[N][N];
        
        for(double[] row: dpStore) Arrays.fill(row, 1);
        
        for(int i = 0; i < K; i++){
            
            double[][] tempDP = new double[N][N];
            
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    
                    for(int[] move: moves){
                        
                        int row = j + move[0];
                        int col = k + move[1];
                        if(isValid(tempDP, row, col)) tempDP[j][k] += dpStore[row][col];
                    }
                }
            }
            
            dpStore = tempDP;
            
        }//end- K loops
        
        //Each moves can propogate and probabilities are calculated as
        //  2/8 * 2/8 ... So 
        return dpStore[r][c] / Math.pow(8, K);             
    }
    
    public boolean isValid(double[][] tempDP, int row, int col){
        if(row < 0 || row >= tempDP.length || col < 0 || col >= tempDP[0].length) return false;
        return true;
    }
}
