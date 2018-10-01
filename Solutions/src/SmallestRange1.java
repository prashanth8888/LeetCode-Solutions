class Solution {
    public int smallestRangeI(int[] A, int K) {
        
        if(A == null || A.length <= 1) return 0;
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int element : A){
            if(element < min) min = element;
            if(element > max) max = element;
        }
        
        return max - min > K * 2 ? max - min - (2 * K) : 0; 
    }
}
