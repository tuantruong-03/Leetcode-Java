package src.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // O(nlog(n))
        int size = nums.length;
        int closestSum = Integer.MAX_VALUE;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < size - 2; ++i) {
            int left = i + 1;
            int right = size - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int distance = Math.abs(sum - target);
                if (distance == 0) {
                    return target;
                }
                if (distance < minDistance) { // minDistance change, so closeSum change
                    minDistance = distance;
                    closestSum = sum;
                }
                if (sum > target) {
                    right--;
                } else {

                    left++;
                }
            }
        }
        return closestSum;
    }
}
