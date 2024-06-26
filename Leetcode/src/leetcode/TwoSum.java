package src.leetcode;

import java.util.HashMap;
import java.util.Map;

//Main point: take advantage of "Map"

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i =0; i<nums.length; ++i) {
			map.put(nums[i],i);
		}
		for (int i =0; i<nums.length; ++i) {
			Integer num1 = nums[i];
			Integer num2 = target - num1;
			if (map.containsKey(num2) && map.get(num2)!= i ) {
				int[] results = {i, map.get(num2)};
				return results;
			}
		}
        return null;
    }
}
