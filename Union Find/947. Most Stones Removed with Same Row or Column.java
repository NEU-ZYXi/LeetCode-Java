
/*

On a 2D plane, we place stones at some integer coordinate points.  Each coordinate point may have at most one stone.
Now, a move consists of removing a stone that shares a column or row with another stone on the grid.
What is the largest possible number of moves we can make?

Example 1:
Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
Output: 5

Example 2:
Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
Output: 3

Example 3:
Input: stones = [[0,0]]
Output: 0

*/

/*

Solution 1: set two elements with same row or column as a connected component
            use union-find to count the number of connected components which is the last element we could get
O(nm),O(n)          

*/

public int removeStones(int[][] stones) {
    int n = stones.length, cnt = n;
    Map<String, String> id = new HashMap<>();
    for (int i = 0; i < n; ++i) {
        String s = stones[i][0] + ", " + stones[i][1];
        id.put(s, s);
    }
    for (int i = 0; i < n; ++i) {
        String u = stones[i][0] + ", " + stones[i][1];
        for (int j = 0; j < n; ++j) {
            if (i == j) continue;
            if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                String v = stones[j][0] + ", " + stones[j][1];
                cnt = union(id, u, v, cnt);
            }                    
        }
    }
    return n - cnt;
}

private String find(Map<String, String> id, String u) {
    while (u != id.get(u)) {
        u = id.get(u);
        id.put(id.get(u), find(id, (id.get(u))));
    }
    return u;
}

private int union(Map<String, String> id, String u, String v, int cnt) {
    String uroot = find(id, u), vroot = find(id, v);
    if (uroot.equals(vroot)) return cnt;
    id.put(uroot, vroot);
    return cnt - 1;
}


/*

Solution 2: union-find with row and column index as connected component
O(nm),O(n)

*/

class DSU {
        
    private int[] id;
    private int[] rank;

    public DSU(int n) {
        this.id = new int[n];
        this.rank = new int[n];
        for (int i = 0; i < n; ++i) {
            this.id[i] = i;
            this.rank[i] = 1;
        }
    }

    private int find(int i) {
        if (i != id[i]) id[i] = find(id[i]);
        return id[i];
    }

    private void union(int u, int v) {
        int rootu = find(u), rootv = find(v);
        if (rootu == rootv) return;
        if (rank[rootu] > rank[rootv]) {
            rank[rootu] += rank[rootv];
            id[rootv] = rootu;
        } else {
            rank[rootv] += rank[rootu];
            id[rootu] = rootv;
        }
    }
}

public int removeStones(int[][] stones) {
    int n = 0;
    for (int[] stone : stones) {
        n = Math.max(stone[0], n);
        n = Math.max(stone[1], n);
    }
    DSU dsu = new DSU(2 * n + 2);
    Set<Integer> ans = new HashSet<>();
    for (int[] stone : stones) dsu.union(stone[0], stone[1] + n + 1);
    for (int[] stone : stones) ans.add(dsu.find(stone[0]));
    return stones.length - ans.size();
}




