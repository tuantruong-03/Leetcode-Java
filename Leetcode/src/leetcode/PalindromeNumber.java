package src.leetcode;

// Main point: sum = sum*10 + temp%10; temp /=10;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
        if (x<0) {
        	return false;
        }
        int temp = x;
        int sum = 0;
        while(temp!=0) {
        	sum = sum*10 + temp%10;
        	temp /=10;
        }
        return sum == x;
    }
}
