package src.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Main point: 
// Object[][] romanChar = {
//     {1000, "M"}, {900, "CM"}, {500, "D"}, {400, "CD"}, 
//     {100, "C"}, {90, "XC"}, {50, "L"}, {40, "XL"}, 
//     {10, "X"}, {9, "IX"}, {5, "V"}, {4, "IV"}, {1, "I"}
// }

public class IntegerToRoman {

    public String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        Object[][] romanChar = {
            {1000, "M"}, {900, "CM"}, {500, "D"}, {400, "CD"}, 
            {100, "C"}, {90, "XC"}, {50, "L"}, {40, "XL"}, 
            {10, "X"}, {9, "IX"}, {5, "V"}, {4, "IV"}, {1, "I"}
        };
        for (int i = 0; i < romanChar.length; ++i) {
            while (num >= (int)romanChar[i][0]) {
                stringBuilder.append((String)romanChar[i][1]);
                num -= (int)romanChar[i][0];
            }
        }
        return stringBuilder.toString();
    }
}
