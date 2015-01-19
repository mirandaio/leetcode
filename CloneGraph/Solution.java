/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>();
 *     }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<UndirectedGraphNode, UndirectedGraphNode> visited =
            new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue =
            new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode newNode = null;

        if(node != null) {
            queue.add(node);
            newNode = new UndirectedGraphNode(node.label);
            visited.put(node, newNode);
        }

        while(!queue.isEmpty()) {
            UndirectedGraphNode n = queue.remove();
            UndirectedGraphNode clone = visited.get(n);

            for(UndirectedGraphNode neighbor : n.neighbors) {
                UndirectedGraphNode cloneNeighbor;

                if(visited.containsKey(neighbor)) {
                    cloneNeighbor = visited.get(neighbor);
                } else {
                    cloneNeighbor = new UndirectedGraphNode(neighbor.label);
                    queue.add(neighbor);
                    visited.put(neighbor, cloneNeighbor);
                }

                clone.neighbors.add(cloneNeighbor);
            }
        }

        return newNode;
    }
}
