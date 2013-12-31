

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/** 
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *    3
 *   / \
 *  9  20
 *  /   \
 * 15    7
 * return its bottom-up level order traversal as:
 * [
 *  [15,7]
 *  [9,20],
 *  [3],
 * ]
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 * 
 */

public class BinaryTreeLevelOrderTraversalII {
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return ret;
		ArrayList<Integer> level = new ArrayList<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int currentLevel = 1;
		int nextLevel = 0;
		while (!queue.isEmpty()) {
			TreeNode node = queue.remove();
			level.add(node.val);
			currentLevel--;
			if (node.left != null) {
				queue.add(node.left);
				nextLevel++;
			}
			if (node.right != null) {
				queue.add(node.right);
				nextLevel++;
			}
			if (currentLevel == 0) {
				ret.add(level);
				level = new ArrayList<Integer>();
				currentLevel = nextLevel;
				nextLevel = 0;
			}
		}
		int i = 0, j = ret.size() - 1;
		while (i < j) {
			ArrayList<Integer> tmp = ret.get(i);
			ret.set(i, ret.get(j));
			ret.set(j, tmp);
			i++;
			j--;
		}
		return ret;
	}
}