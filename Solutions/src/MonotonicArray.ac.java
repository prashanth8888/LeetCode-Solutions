class Solution {
    public boolean isMonotonic(int[] A) {
        if(A == null || A.length <= 1) return true;
        
        int idx1 = 0, idx2 = 1;
        while(idx2 < A.length && A[idx1] == A[idx2]){
            idx1++;
            idx2++;
        }
        
        if(idx2 >= A.length - 1) return true;
        
        return A[idx1] > A[idx2] ? isMontoneDecreasing(A, idx1) : isMonotoneIncreasing(A, idx1);
        
    }
    
    public boolean isMonotoneIncreasing(int[] A, int idx){
        
        for(int i = idx+1; i < A.length ; i++){
            if(A[i] < A[i-1] ) return false;
        }
        
        return true;
    }
    
    public boolean isMontoneDecreasing(int[] A, int idx){
        
        for(int i = idx+1; i < A.length ; i++){
            if(A[i] > A[i-1] ) return false;
        }
        
        return true;
    }
}
