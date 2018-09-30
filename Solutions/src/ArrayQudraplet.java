package SampleTest;

import java.util.Arrays;

class ArrayQudraplet {

	static int[] findArrayQuadruplet(int[] arr, int s) {

		if (arr == null || arr.length <= 3) {
			return new int[0];
		}

		Arrays.sort(arr);

		int limit = arr.length;

		for (int i = 0; i < limit; i++) {
			for (int j = i + 1; j < limit; j++) {
				int reqdSum = s - (arr[i] + arr[j]);
				int low = j + 1, high = limit - 1;

				while (low < high) {
					int currSum = arr[low] + arr[high];

					if (high - low == 1 && currSum != reqdSum)
						break;

					if (currSum < reqdSum)
						low = (low + high) / 2;
					else if (currSum > reqdSum)
						high = (low + high) / 2;
					else
						return new int[] { arr[i], arr[j], arr[low], arr[high] };
				}

			}
		}

		return new int[0];

	}

	public static void main(String[] args) {
		int[] arr = { 2, 7, 4, 0, 9, 5, 1, 3 };
		ArrayQudraplet.findArrayQuadruplet(arr, 20);
	}

}

