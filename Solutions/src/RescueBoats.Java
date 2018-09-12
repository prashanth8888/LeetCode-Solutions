class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        Arrays.sort(people);
        int start = 0, end = people.length - 1;
        int numberOfBoats = 0;
        
        while(start <= end){ 
            if(people[start] + people[end] <= limit){
                numberOfBoats++;   
                start++;
                end--;
            } else {
                numberOfBoats++;
                end--;
            }
        }
        
        return numberOfBoats;
        
    }
}