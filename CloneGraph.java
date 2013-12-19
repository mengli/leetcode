/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * 
 * OJ's undirected graph serialization:
 * Nodes are labeled uniquely.
 * 
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 * 
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.
 * 
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * Second node is labeled as 1. Connect node 1 to node 2.
 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * Visually, the graph looks like the following:
 *
 *      1
 *     / \
 *    /   \
 *   0 --- 2
 *        / \
 *        \_/
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return node;
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		queue.add(node);
		Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		while (!queue.isEmpty()) {
			UndirectedGraphNode n = queue.remove();
			if (visited.contains(n))
				continue;
			visited.add(n);
			UndirectedGraphNode clone;
			if (!map.containsKey(n)) {
				clone = new UndirectedGraphNode(n.label);
				map.put(n, clone);
			} else {
				clone = map.get(n);
			}
			for (UndirectedGraphNode child : n.neighbors) {
				queue.add(child);
				UndirectedGraphNode cloneChild;
				if (!map.containsKey(child)) {
					cloneChild = new UndirectedGraphNode(child.label);
					map.put(child, cloneChild);
				} else {
					cloneChild = map.get(child);
				}
				clone.neighbors.add(cloneChild);
			}
		}
		return map.get(node);
	}
}
