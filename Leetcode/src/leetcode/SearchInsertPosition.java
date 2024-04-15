package src.leetcode;

// Main point: left, mid, right, while(left <= right)

public class SearchInsertPosition {
	 public int searchInsert(int[] nums, int target) {
	        int left = 0;
	        int right = nums.length-1;
	        int mid = (int)(left+right)/2;
	        while(left<=right) {
	        	if (target == nums[mid]) {
	        		return mid;
	        	}
	        	if (target < nums[mid]) {
	        		right = mid -1;
	        		mid = (int)(left+right)/2;
	        	}
	        	else {
	        		left = mid + 1;
	        		mid = (int)(left+right)/2;
	        	}
	        }
	        return left;
	 }
}
