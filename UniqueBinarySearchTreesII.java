/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 *
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 *
 *  1         3     3      2      1
 *   \       /     /      / \      \
 *    3     2     1      1   3      2
 *   /     /       \                 \
 *  2     1         2                 3
 */

import java.util.ArrayList;

public class UniqueBinarySearchTreesII {
	public ArrayList<TreeNode> generateTrees(int n) {
		return buildBST(1, n);
	}

	private ArrayList<TreeNode> buildBST(int min, int max) {
		ArrayList<TreeNode> ret = new ArrayList<TreeNode>();
		if (min > max) {
			ret.add(null);
			return ret;
		}
		if (min == max) {
			ret.add(new TreeNode(min));
			return ret;
		}
		for (int i = min; i <= max; i++) {
			ArrayList<TreeNode> leftTrees = buildBST(min, i - 1);
			ArrayList<TreeNode> rightTrees = buildBST(i + 1, max);
			for (TreeNode l : leftTrees) {
				for (TreeNode r : rightTrees) {
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					ret.add(root);
				}
			}
		}
		return ret;
	}
}
