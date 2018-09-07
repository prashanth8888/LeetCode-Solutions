class Solution {
    public int mySqrt(int x) {
        
        long left = 1, right = x;
        int ans = 0;
        
        while(left <= right){
            
            long mid = left + (right - left) / 2;
            long sqrd = mid * mid;
            if(sqrd < x) {
                ans = (int) mid;
                left = mid + 1;
            } else if(sqrd > x) {
                right = mid - 1;
            } else {
                return (int) mid;
            }
            
        }
        
        return ans;
        
    }
}
