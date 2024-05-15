package src.leetcode;

import java.util.ArrayList;
import java.util.List;

// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

// Main point: String [] digitToLetters = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//             private void recursive(List<String> res, String combination, String digits, String [] digitToLetters, int index)
//            int digitPosition = Integer.valueOf(digits.charAt(index) - '0');
//             draw tree structure to implement recursion


public class LetterCombinationsOfAPhoneNumber {
    // Use recursive
    private void recursive(List<String> res, String combination, String digits, String [] digitToLetters, int index) {
        // Finish combining letters
        if (index == digits.length()) {
            res.add(combination);
            return;
        }
        int digitPosition = Integer.valueOf(digits.charAt(index) - '0');
        String letters = digitToLetters[digitPosition];
        // index = 0; digitPosition = 2, letters = "abc"
        // index = 1; digitPosition = 3, letters = "def"
        for (int i = 0; i < letters.length(); ++i ) {
            combination += letters.charAt(i);
            recursive(res, combination, digits, digitToLetters, index+1);
            combination = combination.substring(0, index);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        String combination = "";
        String [] digitToLetters = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        recursive(res, combination, digits, digitToLetters, 0);
        System.out.println(res.toString());
        return res;
    }  

}
