
/*

Consider a directed graph, with nodes labelled 0, 1, ..., n-1.  
In this graph, each edge is either red or blue, and there could be self-edges or parallel edges.
Each [i, j] in red_edges denotes a red directed edge from node i to node j.  
Similarly, each [i, j] in blue_edges denotes a blue directed edge from node i to node j.
Return an array answer of length n, where each answer[X] is the length of the shortest path from node 0 to node X 
such that the edge colors alternate along the path (or -1 if such a path doesn't exist).

Example 1:
Input: n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
Output: [0,1,-1]

Example 2:
Input: n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
Output: [0,1,-1]

Example 3:
Input: n = 3, red_edges = [[1,0]], blue_edges = [[2,1]]
Output: [0,-1,-1]

Example 4:
Input: n = 3, red_edges = [[0,1]], blue_edges = [[1,2]]
Output: [0,1,2]

Example 5:
Input: n = 3, red_edges = [[0,1],[0,2]], blue_edges = [[1,0]]
Output: [0,1,1]

*/

/*

O(V+E),O(V+E)

*/

public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
    List<Integer>[] red_adj = new ArrayList[n];
    List<Integer>[] blue_adj = new ArrayList[n];
    for (int[] edge : red_edges) {
        int u = edge[0], v = edge[1];
        if (red_adj[u] == null) {
            red_adj[u] = new ArrayList<>();
        }
        red_adj[u].add(v);
    }
    for (int[] edge : blue_edges) {
        int u = edge[0], v = edge[1];
        if (blue_adj[u] == null) {
            blue_adj[u] = new ArrayList<>();
        }
        blue_adj[u].add(v);
    }
    int[] ans = new int[n];
    Queue<int[]> queue = new LinkedList<>();
    Arrays.fill(ans, -1);
    Set<String> vis = new HashSet<>();
    int cnt = 0;
    queue.offer(new int[] {0, 0});
    while (!queue.isEmpty()) {
        int sz = queue.size();
        for (int i = 0; i < sz; ++i) {
            int[] cur = queue.poll();
            int to = cur[0], color = cur[1];
            if (vis.add(to + "," + color)) {
                if (ans[to] == -1) {
                    ans[to] = cnt;
                }
                if (color == 0 || color == 1) {
                    if (red_adj[to] != null) {
                        for (int next : red_adj[to]) {
                            queue.offer(new int[] {next, 2});
                        }
                    }
                }
                if (color == 0 || color == 2) {
                    if (blue_adj[to] != null) {
                        for (int next : blue_adj[to]) {
                            queue.offer(new int[] {next, 1});
                        }
                    }
                }
            }
        }
        cnt++;
    }
    return ans;
}




