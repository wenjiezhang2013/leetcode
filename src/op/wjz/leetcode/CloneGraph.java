package op.wjz.leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};

public class CloneGraph {
	public HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
	/**
	 * Use the graph depth first
	 * @param node
	 * @return
	 */
    public UndirectedGraphNode cloneGraphDepth(UndirectedGraphNode node) {
		if (node == null)
			return null;

		UndirectedGraphNode head = new UndirectedGraphNode(node.label);
		hm.put(node, head);

		DFS(node);// DFS
		return head;
	}

	public void DFS(UndirectedGraphNode node) {
		if (node == null)
			return;

		for (UndirectedGraphNode aneighbor : node.neighbors) {
			if (!hm.containsKey(aneighbor)) {
				UndirectedGraphNode newneighbor = new UndirectedGraphNode(aneighbor.label);
				hm.put(aneighbor, newneighbor);
				DFS(aneighbor);// DFS
			}
			hm.get(node).neighbors.add(hm.get(aneighbor));
		}
	}
	
	
	/**
	 * Use the graph breadth first 
	 * @param node
	 * @return
	 */
    private static UndirectedGraphNode cloneGraphBreadth(UndirectedGraphNode node) {
    	if (node == null)
			return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		UndirectedGraphNode currentHead = new UndirectedGraphNode(node.label);
		map.put(node, currentHead);
		queue.add(node);
		while(!queue.isEmpty()) {
			UndirectedGraphNode newHead = queue.pop();
    		for (UndirectedGraphNode item : newHead.neighbors) {
    			if (!map.containsKey(item)) {
		            UndirectedGraphNode newNeighbor = new UndirectedGraphNode(item.label);
		            queue.push(item);
		            map.put(item, newNeighbor);
    			}
    			
    			map.get(newHead).neighbors.add(map.get(item));
    		}
		}

		return currentHead;
	}
    
    public static void main(String[] args) {
    	UndirectedGraphNode head = new UndirectedGraphNode(-1);
    	UndirectedGraphNode newHead = cloneGraphBreadth(head);
    	
    	System.err.println(head == newHead);
	}
}