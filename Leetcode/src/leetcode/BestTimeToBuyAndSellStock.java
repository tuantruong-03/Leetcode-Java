package src.leetcode;

//	Main point: two pointers (left and right) to control array
//	if (profits[right] - prices[left] <=0 ) left = right
// 	[7,1,5,3,6,4]

public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int max = Integer.MIN_VALUE;
        while (right < prices.length) {
        	int profit = prices[right] - prices[left];
        	if (profit > 0) {
        		max = Integer.max(max, profit);
        	} else {
        		left = right;
        	}
        	right++;
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
