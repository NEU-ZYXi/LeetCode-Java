
/*

Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
write a function to find the number of connected components in an undirected graph.

Example 1:
Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]
     0          3
     |          |
     1 --- 2    4 
Output: 2

Example 2:
Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
     0           4
     |           |
     1 --- 2 --- 3
Output:  1

*/

/*

Solution 1: DFS method
O(V+E),O(V+E)

*/

public int countComponents(int n, int[][] edges) {
    if (n == 0) return 0;
    List<Integer>[] adj = new ArrayList[n];
    for (int i = 0; i < n; ++i) adj[i] = new ArrayList<>();
    for (int[] edge : edges) {
        int u = edge[0], v = edge[1];
        adj[u].add(v);
        adj[v].add(u);
    }
    Set<Integer> vis = new HashSet<>();
    int ans = 0;
    for (int i = 0; i < n; ++i) {
        if (vis.add(i)) {
            dfs(adj, vis, i);
            ans++;
        }
    }
    return ans;
}

private void dfs(List<Integer>[] adj, Set<Integer> vis, int u) {
    for (int v : adj[u]) {
        if (vis.add(v)) dfs(adj, vis, v);
    }
}


/*

Solution 2: BFS method
O(V+E),O(V+E)

*/

public int countComponents(int n, int[][] edges) {
    if (n == 0) return 0;
    List<Integer>[] adj = new ArrayList[n];
    for (int i = 0; i < n; ++i) adj[i] = new ArrayList<>();
    for (int[] edge : edges) {
        int u = edge[0], v = edge[1];
        adj[u].add(v);
        adj[v].add(u);
    }
    Set<Integer> vis = new HashSet<>();
    int ans = 0;
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < n; ++i) {
        if (vis.add(i)) {
            ans++;
            queue.offer(i);
            while (!queue.isEmpty()) {
                int sz = queue.size();
                for (int j = 0; j < sz; ++j) {
                    int u = queue.poll();
                    for (int v : adj[u]) {
                        if (vis.add(v)) queue.offer(v);
                    }
                }
            }
        }
    }
    return ans;
}


/*

Solution 3: union find
O(

*/

public int countComponents(int n, int[][] edges) {
    if (n == 0) return 0;
    int ans = n;
    int[] id = new int[n];
    int[] rank = new int[n];
    for (int i = 0; i < n; ++i) {
        id[i] = i;
        rank[i] = 1;
    }
    for (int[] edge : edges) {
        int u = edge[0], v = edge[1];
        if (find(id, u) != find(id, v)) {
            union(id, rank, u, v);
            ans--;
        }
    }
    return ans;
}

private int find(int[] id, int u) {
    while (u != id[u]) {
        u = id[u];
        id[u] = id[id[u]];
    }
    return u;
}

private void union(int[] id, int[] rank, int u, int v) {
    int rootu = find(id, u), rootv = find(id, v);
    if (rootu == rootv) return;
    else if (rank[rootu] > rank[rootv]) {
        rank[rootu] += rank[rootv];
        id[rootv] = id[rootu];
    } else {
        rank[rootv] += rank[rootu];
        id[rootu] = id[rootv];
    }
}



