import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) return node;
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		queue.add(node);
		Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		while(!queue.isEmpty()) {
			UndirectedGraphNode n = queue.remove();
			if (visited.contains(n)) continue;
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
