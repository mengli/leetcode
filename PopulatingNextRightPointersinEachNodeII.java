import java.util.ArrayList;
import java.util.List;



/** 
 * Populating Next Right Pointers in Each Node IIOct 28 '12
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 *
 * What if the given tree could be any binary tree? Would your previous solution still work?
 *
 * Note:
 *
 * You may only use constant extra space.
 * For example,
 * Given the following binary tree,
 *        1
 *       /  \
 *      2    3
 *     / \    \
 *    4   5    7
 * After calling your function, the tree should look like:
 *        1 -> NULL
 *       /  \
 *      2 -> 3 -> NULL
 *     / \    \
 *    4-> 5 -> 7 -> NULL
 */
	
public class PopulatingNextRightPointersinEachNodeII {
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		TreeLinkNode curLevel = root, cur = root;
		curLevel.next = null;
		List<TreeLinkNode> nextLevelNodes = new ArrayList<TreeLinkNode>();
		while (true) {
			while (cur != null) {
				if (cur.left != null) {
					nextLevelNodes.add(cur.left);
				}
				if (cur.right != null) {
					nextLevelNodes.add(cur.right);
				}
				cur = cur.next;
			}
			for (int i = 0; i < nextLevelNodes.size() - 1; i++) {
				nextLevelNodes.get(i).next = nextLevelNodes.get(i + 1);
			}
			if (nextLevelNodes.size() > 0) {
				curLevel = nextLevelNodes.get(0);
				cur = curLevel;
				nextLevelNodes.clear();
			} else {
				break;
			}
		}
	}
}