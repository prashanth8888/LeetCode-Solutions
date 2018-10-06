class Solution {
    //[ 5, 0, 3, 8, 4, 9, 10, 11, 12, 3, 14, 16, 17]
    // 0   1  2 . 3 .4  5  6   7 .  8 . 9 .10 . 11 12
    // Range traversed till - Till that range it is invalid.
    // i - 9
    // currMax = 14, validUntilIdx = 9
    // start - 11, end - 12
    
    public int partitionDisjoint(int[] A) {
        if(A == null || A.length < 1) return 0;
        
        int currMax = A[0];
        int validUnitlIdx = 0;
        int range = A.length;
        
        for(int i = 1; i < range; i++) {
            if(A[i] >= currMax)
            {
                int[] tempResult = validTillRange(A, i, range, currMax, currMax);
                currMax = tempResult[1];
                validUnitlIdx = tempResult[0];
                if(validUnitlIdx == range) return i;
                i = validUnitlIdx;
            }
        }
        
        return 0;
        
    }
    
    private int[] validTillRange(int[] A, int start, int end, int currMax, int newMax) {
        for(int i = start + 1; i < end; i++) {
            newMax = Math.max(newMax, A[i-1]);
            if(A[i] < currMax || A[i-1] < currMax) return new int[]{i, newMax};
        }
        return new int[]{end, newMax};
    }
}
