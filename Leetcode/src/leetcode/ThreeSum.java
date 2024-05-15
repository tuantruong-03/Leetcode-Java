package src.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// Main point: Two Pointers technique,
//               for (int i = 0; i < nums.length -2 ; ++i) {
//                 left = i+1
//                 right = nums.leght-1
//                 while (left < right) {
//                     if (sum = 0 ) add triplet, left++, right--
//                     if (sum < 0) left++
//                     if (sum > 0) right--
//                 }

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);  // O(logn), Ascending Order
        // -4, -1, -1, 0, 1, 2
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length -2 ; ++i) {

            if (i > 0 && nums[i] == nums[i-1]) {    
                continue;
            }
            int left = i +1;
            int right = nums.length - 1;
            while(left < right) {
                if (left > i+1 && nums[left] == nums[left-1] ) { 
                    // Example, i=0, left=2, nums[left] = -1; nums[left-1] -1, skip consecutive identical elements
                    left++;
                    continue;
                }
                int sum = nums[i] + nums[left] + nums[right]; 
                if ( sum == 0) {
                    List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    res.add(temp);
                } else if (sum > 0) {
                    // If sum > 0, we have to move right pointer backwards one unit to get the smaller element (for the "sum" closer to 0)
                    right--;
                } else { // sum <= 0
                    left++;
                }
            }
        }
        return res;
    }
}
