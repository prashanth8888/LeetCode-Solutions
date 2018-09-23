package SampleTest;

import java.util.ArrayList;
import java.util.List;

public class PalindromeDecompositions {

	public void palindromicDecompositions(String input) {
		List<List<String>> result = new ArrayList<>();
		generateDecompositions(input, 0, result, new ArrayList<String>());
		System.out.println(result);
	}

	private void generateDecompositions(String input, int offset, List<List<String>> result, List<String> decompositions) {
		
		if(offset == input.length()) {
			result.add(new ArrayList<>(decompositions));
			return;
		}
		
		for(int i = offset+1; i <= input.length(); i++) {
			String prefix = input.substring(offset, i);
			if(isPalindrome(prefix)) {
				decompositions.add(prefix);
				generateDecompositions(input, i, result, decompositions);
				decompositions.remove(decompositions.size()-1);
			}
		}
		
	}

	private boolean isPalindrome(String prefix) {
		
		for(int i = 0, j = prefix.length() - 1; i < j; ++i, --j) {
			if(prefix.charAt(i) != prefix.charAt(j))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		PalindromeDecompositions pdec = new PalindromeDecompositions();
		pdec.palindromicDecompositions("611116");
	}

}
