public class Solution {
    public int candy(int[] ratings) {
     
     int[] candies = new int[ratings.length];
     candies[0] = 1;
     
     for(int i = 1; i <= ratings.length - 1; i++){
        
        if(ratings[i] > ratings[i-1]){
            candies[i] = candies[i-1] + 1;
        }    
        else{
            candies[i] = 1;
        }
         
     }
     
     int result = candies[ratings.length - 1];
     int currentRating = 0;
     
     for(int j = ratings.length - 2; j >= 0; j--){
         currentRating = 1;
         if(ratings[j] > ratings[j+1]){
             currentRating = candies[j+1] + 1;
             
         }
         result += Math.max(currentRating,candies[j]);
         if(currentRating > candies[j]){
             candies[j] = currentRating;
         }
         
     }
        return result;
    }
}
