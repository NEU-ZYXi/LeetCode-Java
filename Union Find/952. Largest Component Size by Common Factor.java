
/*

Given a non-empty array of unique positive integers A, consider the following graph:
There are A.length nodes, labelled A[0] to A[A.length - 1];
There is an edge between A[i] and A[j] if and only if A[i] and A[j] share a common factor greater than 1.
Return the size of the largest connected component in the graph.

Example 1:
Input: [4,6,15,35]
Output: 4

Example 2:
Input: [20,50,9,63]
Output: 2

Example 3:
Input: [2,3,6,7,4,12,21,39]
Output: 8

*/

/*

Solution: for each A[i], loop through all its factors j,a/j and a itself if a%j=0 
          use a map to store (factor, index), if the factor exists before, union these two components
O(n*sqrt(max(A))),O(n)          

*/

class UF {
    private int[] parent;
    private int[] rank;
    private int cnt;

    public UF(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        this.cnt = 1;
        for (int i = 0; i < n; ++i) {
            this.parent[i] = i;
            this.rank[i] = 1;
        }
    }

    private int find(int i) {
        while (i != parent[i]) {
            i = parent[i];
            parent[i] = parent[parent[i]];
        }
        return i;
    }

    private void union(int p, int q) {
        int rootP = find(p), rootQ = find(q);
        if (rootP == rootQ) {
            return;
        } else if (rank[rootP] > rank[rootQ]) {
            rank[rootP] += rank[rootQ];
            parent[rootQ] = parent[rootP];
            cnt = Math.max(cnt, rank[rootP]);
        } else {
            rank[rootQ] += rank[rootP];
            parent[rootP] = parent[rootQ];
            cnt = Math.max(cnt, rank[rootQ]);
        }
    }
}

public int largestComponentSize(int[] A) {
    int n = A.length;
    UF uf = new UF(n);
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; ++i) {
        int a = A[i];
        for (int j = 2; j * j <= a; ++j) {
            if (a % j == 0) {
                if (!map.containsKey(j)) {
                    map.put(j, i);
                } else {
                    uf.union(i, map.get(j));
                }
                if (!map.containsKey(a / j)) {
                    map.put(a / j, i);
                } else {
                    uf.union(i, map.get(a / j));
                }
            }
        }
        if (!map.containsKey(a)) {
            map.put(a, i);
        } else {
            uf.union(i, map.get(a));
        }
    }
    return uf.cnt;
}



