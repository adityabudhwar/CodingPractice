package BitManipulation;

public class numberOf1bits {
	public int numberbits(int n) {
		int count = 0;
		for(int i=0;i<33;i++) {
			if(check(n,i)==1) {
				count++;
			}
		}
		return count;
	}
	public int check(int n, int i) {
		return n & (1<<i);
	}

}
