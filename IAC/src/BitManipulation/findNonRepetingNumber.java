package BitManipulation;

public class findNonRepetingNumber {

	public int findNonRepeating(int[] arr) {
		int x = 0;
		for(int a:arr) {
			x = x^a;
		}
		return x;
	}
	
}
