package src.leetcode;

import javax.swing.text.StyledEditorKit.BoldAction;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class SymmetricTree {
	private boolean check(TreeNode left, TreeNode right) {
		if (left == null && right == null) return true;
		if (left == null || right == null) return false;
		boolean child1 = check(left.left, right.right);
		boolean child2 = check(left.right, right.left);
		return left.val == right.val && child1 && child2;
	}
	public boolean isSymmetric(TreeNode root) {
        if (root == null) {
        	return false;
        }
        return check(root.left, root.right);
    }
}
