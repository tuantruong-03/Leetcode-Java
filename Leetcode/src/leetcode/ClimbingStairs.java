package src.leetcode;


// Main point: Dynamic Programming to eliminate Recursion
public class ClimbingStairs {
	public int climbStairs(int n) {
		int [] F = new int[n+1];
		F[1] = 1;
		if (n==1) {
			return F[1];
		}
		F[2] = 2;
		
		if (n==2) {
			return F[2];
		}
		for (int i = 3; i<=n; ++i) {
			F[i] = F[i-1] + F[i-2];
		}
		return F[n];
    }
}
