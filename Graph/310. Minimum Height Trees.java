
/*

For an undirected graph with tree characteristics, we can choose any node as the root. 
The result graph is then a rooted tree. 
Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). 
Given such a graph, write a function to find all the MHTs and return a list of their root labels.
You can assume that no duplicate edges will appear in edges. 
Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example 1 :
Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
        0
        |
        1
       / \
      2   3 
Output: [1]

Example 2 :
Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
     0  1  2
      \ | /
        3
        |
        4
        |
        5 
Output: [3, 4]

*/

/*

Solution: keep removing leaf nodes until we have only 1 or 2 nodes left
O(V+E),O(V+E)

*/

public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    if (n == 1) return new ArrayList<>(Arrays.asList(0));
    List<Integer>[] adj = new ArrayList[n];
    for (int i = 0; i < n; ++i) adj[i] = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();
    int[] indegree = new int[n];
    for (int[] edge : edges) {
        int u = edge[0], v = edge[1];
        adj[u].add(v);
        adj[v].add(u);
        indegree[u]++;
        indegree[v]++;
    }
    for (int i = 0; i < n; ++i) {
        if (indegree[i] == 1) ans.add(i);
    }
    while (n > 2) {
        n -= ans.size();
        List<Integer> nxt = new ArrayList<>();
        for (int u : ans) {
            for (int v : adj[u]) {
                indegree[v]--;
                if (indegree[v] == 1) nxt.add(v); 
            }
        }
        ans = nxt;
    }
    return ans;
}





