
/*

In this problem, a rooted tree is a directed graph such that, 
there is exactly one node (the root) for which all other nodes are descendants of this node, 
plus every node has exactly one parent, except for the root node which has no parents.
The given input is a directed graph that started as a rooted tree with N nodes (with distinct values 1, 2, ..., N),
with one additional directed edge added. 
The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.
The resulting graph is given as a 2D-array of edges. 
Each element of edges is a pair [u, v] that represents a directed edge connecting nodes u and v,
where u is a parent of child v.
Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes. 
If there are multiple answers, return the answer that occurs last in the given 2D-array.

Example 1:
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given directed graph will be like this:
  1
 / \
v   v
2-->3

Example 2:
Input: [[1,2], [2,3], [3,4], [4,1], [1,5]]
Output: [4,1]
Explanation: The given directed graph will be like this:
5 <- 1 -> 2
     ^    |
     |    v
     4 <- 3

*/

/*

Solution: 1. find the node with two parents if it exists
          2. find cycle and return the second duplicate edge
          otherwise, return the first duplicate edge
O(E),O(E)

*/

class UnionFind {
    private int[] parent;

    public UnionFind(int n) {
        this.parent = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
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

public int[] findRedundantDirectedConnection(int[][] edges) {
    int n = edges.length;
    UnionFind uf = new UnionFind(n);
    int[] first = new int[] {-1, -1};
    int[] second = new int[] {-1, -1};
    for (int[] edge : edges) {
        int u = edge[0], v = edge[1];
        if (uf.parent[v] == v) {
            uf.parent[v] = u;
        } else {
            first = new int[] {u, v};
            second = new int[] {uf.parent[v], v};
            edge[1] = -1;
        }
    }
    uf = new UnionFind(n);
    for (int[] edge : edges) {
        int u = edge[0], v = edge[1];
        if (v == -1) {
            continue;
        }   
        if (uf.find(u) == v) {
            if (second[0] == -1) {
                return edge;
            }
            return second;
        }
        uf.union(u, v);
    }
    return first;
}





