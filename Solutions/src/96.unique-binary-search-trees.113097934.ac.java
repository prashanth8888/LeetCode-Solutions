public class Solution {
    public int numTrees(int n) {
        if(n == 0 || n == 1) return 1;
        
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        result[2] = 2;
        
        if(n < 3)
            return result[n];
        else{
            for(int i = 3; i <= n; i++){
                for(int j = 1; j <= i; j++){
                    result[i] = result[i] + ( result[j-1] * result[i-j] );
                }
            }
        }
        
        return result[n];
        
    }
}
