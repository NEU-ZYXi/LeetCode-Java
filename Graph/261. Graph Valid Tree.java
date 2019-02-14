
/*

Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), 
write a function to check whether these edges make up a valid tree.

Example 1:
Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
Output: true

Example 2:
Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
Output: false

*/

/*

Solution 1: DFS to check cycle, use an extra parameter for parent node to avoid duplicate check since it's undirected edges
O(V+E),O(V)

*/

public boolean validTree(int n, int[][] edges) {
    if (edges.length != n - 1) return false;
    List<Integer>[] adj = new ArrayList[n];
    Set<Integer> vis = new HashSet<>();
    for (int i = 0; i < n; ++i) adj[i] = new ArrayList<>();
    for (int[] edge : edges) {
        int u = edge[0], v = edge[1];
        adj[u].add(v);
        adj[v].add(u);
    }
    if (dfs(adj, vis, 0, -1)) return false;
    return vis.size() == n;
}

private boolean dfs(List<Integer>[] adj, Set<Integer> vis, int u, int prev) {
    vis.add(u);
    for (int v : adj[u]) {
        if (v == prev) continue;
        if (vis.contains(v) || dfs(adj, vis, v, u)) return true;
    }
    return false;
}


/*

Solution 2: BFS to detect cycle, 3-color vis array to mark the states of nodes
O(V+E),O(V)

*/

public boolean validTree(int n, int[][] edges) {
    if (edges.length != n - 1) return false;
    List<Integer>[] adj = new ArrayList[n];
    int[] vis = new int[n];
    for (int i = 0; i < n; ++i) adj[i] = new ArrayList<>();
    for (int[] edge : edges) {
        int u = edge[0], v = edge[1];
        adj[u].add(v);
        adj[v].add(u);
    }
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(0);
    vis[0] = 1;
    while (!queue.isEmpty()) {
        int sz = queue.size();
        for (int i = 0; i < sz; ++i) {
            int u = queue.poll();
            for (int v : adj[u]) {
                if (vis[v] == 1) return false;
                if (vis[v] == 0) {
                    vis[v] = 1;
                    queue.offer(v);
                }
            }
            vis[u] = 2;
        }
    }
    for (int v : vis) {
        if (v == 0) return false;
    }
    return true;
}


/*

Solution 3: Union Find, for (u,v), if u and v are already in the same group, the (u,v) is extra edge which forms a cycle
O(V+E),O(V)

*/

public boolean validTree(int n, int[][] edges) {
    if (edges.length != n - 1) return false;
    int[] id = new int[n];
    int[] rank = new int[n];
    for (int i = 0; i < n; ++i) {
        id[i] = i;
        rank[i] = 1;
    }
    for (int[] edge : edges) {
        int u = edge[0], v = edge[1];
        if (find(id, u) == find(id, v)) return false;
        union(id, rank, u, v);
    }
    return true;
}

private int find(int[] id, int u) {
    while (u != id[u]) {
        u = id[u];
        id[u] = id[id[u]];
    }
    return u;
}

private void union(int[] id, int[] rank, int u, int v) {
    int rootU = find(id, u), rootV = find(id, v);
    if (rootU == rootV) return;
    if (rank[rootU] > rank[rootV]) {
        rank[rootU] += rank[rootV];
        id[rootV] = id[rootU];
    } else {
        rank[rootV] += rank[rootU];
        id[rootU] = id[rootV];
    }
}





