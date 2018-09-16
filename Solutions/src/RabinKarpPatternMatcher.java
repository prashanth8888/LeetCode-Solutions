package SampleTest;

public class RabinKarpPatternMatcher {

	private static int PRIME_REF = 101;

	public int isPatternPresent(String text, String pattern) {
		int patternLength = pattern.length();
		int textLength = text.length();
		
		if(patternLength > textLength) return -1;
		
		long phash = calculateHash(pattern, patternLength);
		long thash = calculateHash(text, patternLength);
		
		for(int i = 1; i <= textLength - patternLength + 1; i++) {
			if(phash == thash && isStringEqual(text.substring(i-1, i - 1 +patternLength), pattern)) {
				return i-1;
			} 
			if(i < textLength - patternLength + 1) {
				thash = reCalculateHash(text, i-1, i+patternLength-1, patternLength-1, thash);
			}
		}
		return -1;
	}

	public long calculateHash(String str, int limit) {
		long hashVal = 0;
		for (int i = 0; i < limit; i++) {
			hashVal += (Math.pow(PRIME_REF, i) * str.charAt(i));
		}
		return hashVal;
	}

	public long reCalculateHash(String str, int removeCharIdx, int addCharIdx, int power, long refHashVal) {
		refHashVal -= str.charAt(removeCharIdx);
		refHashVal = refHashVal / PRIME_REF;
		refHashVal += (Math.pow(PRIME_REF, power) * str.charAt(addCharIdx));
		return refHashVal;
	}

	public boolean isStringEqual(String textCapture, String pattern) {
		return textCapture.equals(pattern);
	}

	public static void main(String[] args) {
		
	}

}
