Binary Tree Level Order Traversal IIOct 1 '12
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7]
  [9,20],
  [3],
]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> levels = new ArrayList<ArrayList<Integer>>();
    	if (root == null) return levels;
    	int curr = 1;
    	int next = 0;
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	ArrayList<Integer> level = new ArrayList<Integer>();
    	q.add(root);
    	while(!q.isEmpty()) {
    		TreeNode n = q.poll();
    		curr--;
    		level.add(n.val);
    		if (n.left != null) {
    			q.add(n.left);
    			next++;
    		}
    		if (n.right != null) {
    			q.add(n.right);
    			next++;
    		}
    		if (curr == 0) {
    			levels.add(level);
    			level = new ArrayList<Integer>();
    			curr = next;
    			next = 0;
    		}
    	}
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	for (int i = levels.size() - 1; i >= 0; i--) {
    		result.add(levels.get(i));
    	}
    	return result;
    }
}