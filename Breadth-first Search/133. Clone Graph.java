
/*

Given the head of a graph, return a deep copy (clone) of the graph. 
Each node in the graph contains a label (int) and a list (List[UndirectedGraphNode]) of its neighbors. 
There is an edge between the given node and each of the nodes in its neighbors.

OJ's undirected graph serialization (so you can understand error output):
Nodes are labeled uniquely.
We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.

As an example, consider the serialized graph {0,1,2#1,2#2,2}.
The graph has a total of three nodes, and therefore contains three parts as separated by #.
First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.

Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/

*/

/*

Solution 1: BFS
O(n),O(n)

*/

public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if (node == null) return node;
    Queue<UndirectedGraphNode> queue = new LinkedList<>();
    queue.offer(node);
    Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    map.put(node, new UndirectedGraphNode(node.label));
    while (!queue.isEmpty()) {
        UndirectedGraphNode cur = queue.poll();
        for (UndirectedGraphNode nxt : cur.neighbors) {
            if (!map.containsKey(nxt)) {
                queue.offer(nxt);
                map.put(nxt, new UndirectedGraphNode(nxt.label));
            }
            map.get(cur).neighbors.add(map.get(nxt));
        }
    }
    return map.get(node);
}


/*

Solution 2: DFS
O(n),O(n)

*/

public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    return dfs(node, map);
}

private UndirectedGraphNode dfs(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
    if (node == null) return null;
    if (map.containsKey(node)) return map.get(node);
    map.put(node, new UndirectedGraphNode(node.label));
    for (int i = 0; i < node.neighbors.size(); ++i) map.get(node).neighbors.add(dfs(node.neighbors.get(i), map));
    return map.get(node);
}




