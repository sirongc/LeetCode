package second_round;

import java.util.ArrayList;
import java.util.HashMap;

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if (node == null) return null;
    	HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        return cloneGraph(node, map);
    }
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> map) {
	    UndirectedGraphNode n;
	    if (!map.containsKey(node.label)) {
	        n = new UndirectedGraphNode(node.label);
	        map.put(node.label, n);
	    }
	    else 
	        n = map.get(node.label);

	    ArrayList<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();   
	    for (int i = 0; i < node.neighbors.size(); i++) {
	        UndirectedGraphNode oldnode = node.neighbors.get(i);
	        if (map.containsKey(oldnode.label))
	            neighbors.add(map.get(oldnode.label));
	        else
	            neighbors.add(cloneGraph(oldnode, map));
	    }
	    n.neighbors = neighbors;
	    return n;
	}
}
