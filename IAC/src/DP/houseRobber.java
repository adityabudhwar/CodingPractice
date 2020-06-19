package DP;

public class houseRobber {

	// circular list
	public int robCL(int[] nums) {
		if(nums==null||nums.length==0) {
			return 0;
		}
		
		if(nums.length==1) {
			return nums[0];
		}
		
		int max1 = helper(nums,0, nums.length-2);
		int max2 = helper(nums,1, nums.length-1);
		
		return Math.max(max1, max2);		
	}
	
	public int helper(int[] nums, int i, int j) {
		if(i==j) {
			return nums[i];
		}
		
		int[] dp = new int[nums.length];
		dp[i] = i;
		dp[i+1] = Math.max(nums[i+1], dp[i]);
		
		for(int k=i+2; k<=j; k++) {
			dp[k]= Math.max(dp[k-1], dp[k-2]+nums[k]);
		}
		return dp[j];
	}
	
	
	// normal array
	public int rob(int[] nums) {
		if(nums==null||nums.length==0) {
			return 0;
		}
		if(nums.length==1) {
			return nums[0];
		}
		
		int[] dp = new int[nums.length];
		dp[0]=nums[0];
		dp[1]=Math.max(dp[0], nums[1]);
		
		for(int i=2;i<nums.length;i++) {
			dp[i]=Math.max(dp[i-1], dp[i-2]+nums[i]);
		}
		return dp[nums.length-1];
	}
	
}
