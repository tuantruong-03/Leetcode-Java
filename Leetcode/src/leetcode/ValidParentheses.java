package src.leetcode;

import java.util.Stack;

// Main point: take advantage of stack

public class ValidParentheses {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for( int i = 0; i < s.length(); ++i) {
			char ch = s.charAt(i);
			if (ch == '[' || ch == '{' || ch == '(' ) {
				stack.push(s.charAt(i));
			} else {
				if (stack.isEmpty()) return false;
				char top = stack.pop();
                if ((top == '[' && ch != ']') || (top == '{' && ch != '}') || (top == '(' && ch != ')')) {
                    return false;
                }
			}
		}
		return stack.isEmpty();
	}
}
