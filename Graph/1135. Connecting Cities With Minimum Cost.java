
/*

There are N cities numbered from 1 to N.
You are given connections, where each connections[i] = [city1, city2, cost] represents the cost to connect city1 and city2 together. 
(A connection is bidirectional: connecting city1 and city2 is the same as connecting city2 and city1.)
Return the minimum cost so that for every pair of cities, 
there exists a path of connections (possibly of length 1) that connects those two cities together.
The cost is the sum of the connection costs used. If the task is impossible, return -1.

Example 1:
Input: N = 3, connections = [[1,2,5],[1,3,6],[2,3,1]]
Output: 6
Explanation: 
Choosing any 2 edges will connect all cities so we choose the minimum 2.

Example 2:
Input: N = 4, connections = [[1,2,3],[3,4,4]]
Output: -1
Explanation: 
There is no way to connect all cities even if all edges are used.

*/

/*

Solution: kruskal algo to find the minimum spanning tree, sort all edges based on weight first
          union find two vertex of each edge which is in ascending order of its weight
O(nlogn),O(n)          

*/

class UnionFind {
    private int[] parent;
    private int[] rank;
    private int cnt;

    public UnionFind(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        this.cnt = 1;
        for (int i = 0; i < n; ++i) {
            this.parent[i] = i;
            this.rank[i] = 1;
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
        if (rootP == rootQ) {
            return;
        } else if (rank[rootP] > rank[rootQ]) {
            rank[rootP] += rank[rootQ];
            parent[rootQ] = parent[rootP];
            cnt++;
        } else {
            rank[rootQ] += rank[rootP];
            parent[rootP] = parent[rootQ];
            cnt++;
        }
    }

    public int getCount() {
        return cnt;
    }
}

public int minimumCost(int N, int[][] connections) {
    UnionFind uf = new UnionFind(N + 1);
    Arrays.sort(connections, new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            return a[2] - b[2];
        }
    });
    int ans = 0;
    for (int[] edge : connections) {
        int u = edge[0], v = edge[1], w = edge[2];
        if (uf.find(u) != uf.find(v)) {
            ans += w;
            uf.union(u, v);
        }
    }
    return uf.getCount() == N ? ans : -1;
}




