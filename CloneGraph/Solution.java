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
        if(node == null)
            return null;

        HashSet<Integer> visited = new HashSet<Integer>();
        HashMap<Integer, UndirectedGraphNode> created =
            new HashMap<Integer, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue =
            new LinkedList<UndirectedGraphNode>();

        if(node != null) {
            queue.add(node);
            visited.add(node.label);
        }

        while(!queue.isEmpty()) {
            UndirectedGraphNode n = queue.remove();
            UndirectedGraphNode clone;

            if(created.containsKey(n.label)) {
                clone = created.get(n.label);
            } else {
                clone = new UndirectedGraphNode(n.label);
                created.put(clone.label, clone);
            }

            for(UndirectedGraphNode neighbor : n.neighbors) {
                UndirectedGraphNode cloneNeighbor;
                
                if(created.containsKey(neighbor.label)) {
                    cloneNeighbor = created.get(neighbor.label);
                } else {
                    cloneNeighbor =
                        new UndirectedGraphNode(neighbor.label);
                    created.put(neighbor.label, cloneNeighbor);
                }
                
                clone.neighbors.add(cloneNeighbor);

                if(!visited.contains(neighbor.label)) {
                    queue.add(neighbor);
                    visited.add(neighbor.label);
                }
            }
        }

        return created.get(node.label);
    }
}
