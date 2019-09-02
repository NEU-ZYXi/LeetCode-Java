
/*

In this problem, a tree is an undirected graph that is connected and has no cycles.
The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added. 
The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.
The resulting graph is given as a 2D-array of edges. 
Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.
Return an edge that can be removed so that the resulting graph is a tree of N nodes. 
If there are multiple answers, return the answer that occurs last in the given 2D-array. 
The answer edge [u, v] should be in the same format, with u < v.

Example 1:
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given undirected graph will be like this:
  1
 / \
2 - 3

Example 2:
Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
Output: [1,4]
Explanation: The given undirected graph will be like this:
5 - 1 - 2
    |   |
    4 - 3

*/

/*

Solution 1: O(VE),O(VE)

*/

public int[] findRedundantConnection(int[][] edges) {
    int n = edges.length;
    Map<Integer, Set<Integer>> adj = new HashMap<>();
    for (int i = 1; i <= n; ++i) {
        adj.put(i, new HashSet<>());
    }
    for (int[] edge : edges) {
        int u = edge[0], v = edge[1];
        if (dfs(adj, new HashSet<>(), u, v)) {
            return edge;
        }
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    return new int[] {-1, -1};
}

private boolean dfs(Map<Integer, Set<Integer>> adj, Set<Integer> vis, int u, int v) {
    if (u == v) {
        return true;
    }
    vis.add(u);
    for (int next : adj.get(u)) {
        if (!vis.contains(next)) {
            if (dfs(adj, vis, next, v)) {
                return true;
            }
        }
    }
    return false;
}


/*

Solution 2: O(E),O(E)

*/

class UnionFind {
    private int[] parent;

    public UnionFind(int n) {
        this.parent = new int[n];
        for (int i = 0; i < n; ++i) {
            this.parent[i] = i;
        }
    }

    public int find(int i) {
        while (i != parent[i]) {
            i = parent[i];
            parent[i] = parent[parent[i]];
        }
        return i;
    }

    public void union(int p, int q) {
        int rootP = find(p), rootQ = find(q);
        parent[rootQ] = rootP;
    }
}

public int[] findRedundantConnection(int[][] edges) {
    int n = edges.length;
    UnionFind uf = new UnionFind(n);
    for (int[] edge : edges) {
        int u = edge[0] - 1, v = edge[1] - 1;
        if (uf.find(u) == uf.find(v)) {
            return edge;
        }
        uf.union(u, v);
    }
    return new int[] {-1, -1};
}




