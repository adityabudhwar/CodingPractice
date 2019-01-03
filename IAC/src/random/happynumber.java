package random;

import java.util.HashSet;

public class happynumber {

	public boolean isHappyNumber(int num) {
		HashSet<Integer> set = new HashSet<Integer>();
		while(!set.contains(num)) {
			set.add(num);
			num=getsum(num);
			if(num==1) {
				return true;
			}
		}
		return false;
	}
	public int getsum(int num) {
		int sum =0;
		while(num>0) {
			sum = sum + (num%10*num%10); 
			num = num/10;
		}
		return sum;
	}
	
}
