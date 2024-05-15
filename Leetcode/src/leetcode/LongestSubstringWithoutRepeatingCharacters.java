package src.leetcode;

import java.util.HashMap;
import java.util.Map;

// Main point: utilize "HashMap" to control the repeated character, read comment carefully

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }
        Map <Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxGlobal = 0;
        while (right < s.length()) {
            if (!map.containsKey(s.charAt(right))) { // If map not include s.charAt(right), this means the substring still not repeat the characters
                maxGlobal = Math.max(maxGlobal, right - left + 1);
                map.put(s.charAt(right), right);
                right ++;
            } else {    // The substring repeat the character s.charAt(right), NOTE: always "left <= map.get(s.charAt(right))"
                while (left < map.get(s.charAt(right))) {   
                    // Ex: "bcdeda" 
                    // "left" is 0, "right" is "4", 'd' is the repeated character, map.get('d') = 2 left = map.get('d') + 1 
                    // we will remove ('b',0), ('c',1), ('d',2) in map
                    // 
                    map.remove(s.charAt(left));
                    left++;
                }
                left = map.get(s.charAt(right)) + 1;
                map.remove(s.charAt(right));
            }
        }
        return maxGlobal;
    }
}
