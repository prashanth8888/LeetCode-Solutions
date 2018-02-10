public class Solution {
    public int maxProduct(String[] words) {
	int result = 0;
	    if(words.length == 0 || words.length == 1) return 0;
	    int[] charBitValues = new int[words.length];
	    //charBitValues[0] = 0;
	    for(int i=0; i<words.length; i++){
	    	String currWord = words[i];
	    	for(int j=0; j<currWord.length(); j++){
	    		charBitValues[i] |= 1 << (currWord.charAt(j) - 'a');
	    	}
	    }
	    
	    for(int m=0; m<charBitValues.length-1; m++){
	    	for(int n=m+1; n<charBitValues.length; n++)
	    	{	
	    		if((charBitValues[m] & charBitValues[n]) == 0 && words[m].length() * words[n].length() > result){
	    			result = words[m].length() * words[n].length();
	    		}
	    	}
	    	}
	    return result;
    }
}
