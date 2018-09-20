public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        
        int attackTime = 0;
        int tempAttackTime = 0;
        
        for(int i = 0; i < timeSeries.length ; i++){
            tempAttackTime = 0;
            if(i == 0)
                attackTime += duration;
            else{
                if(timeSeries[i] - timeSeries[i-1] < duration){
                    tempAttackTime = duration - (timeSeries[i] - timeSeries[i-1]);
                    attackTime -= tempAttackTime;
                    attackTime += duration;
                }
                else {
                    attackTime += duration;
                }
            }
        }
        
        return attackTime;
        
    }
    
}
