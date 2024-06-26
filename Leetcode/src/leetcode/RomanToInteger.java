package src.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	private int romanValue(char roman) {
		switch (roman) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			throw new IllegalArgumentException("Unexpected value: " + roman);
		}
	}

	public int romanToInt(String s) {
		int sum = 0;
		for(int i =0; i < s.length(); ++i) {
			if (i <= s.length() - 2 && romanValue(s.charAt(i)) < romanValue(s.charAt(i+1))) {
				sum -=romanValue(s.charAt(i));
			}
			else {
				sum += romanValue(s.charAt(i));
			}
			System.out.println(sum);
		}
		return sum;
	}
}
