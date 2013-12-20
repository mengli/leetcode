/**
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

import java.util.LinkedList;
import java.util.Queue;


public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
    	int ret = 1;
    	int currentLevel = 1;
    	int nextLevel = 0;
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	while (!queue.isEmpty()) {
    		TreeNode node = queue.remove();
    		currentLevel--;
    		if (node.left != null) {
    			queue.add(root.left);
    			nextLevel++;
    		}
    		if (node.right != null) {
    			queue.add(root.right);
    			nextLevel++;
    		}
    		if (currentLevel == 0) {
    			if (nextLevel != 0) {
    				ret++;
    			}
    			currentLevel = nextLevel;
    			nextLevel = 0;
    		}
    	}
    	return ret;
    }
}
