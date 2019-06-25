
/*

You have N gardens, labelled 1 to N.  In each garden, you want to plant one of 4 types of flowers.
paths[i] = [x, y] describes the existence of a bidirectional path from garden x to garden y.
Also, there is no garden that has more than 3 paths coming into or leaving it.
Your task is to choose a flower type for each garden such that, 
for any two gardens connected by a path, they have different types of flowers.
Return any such a choice as an array answer, where answer[i] is the type of flower planted in the (i+1)-th garden. 
The flower types are denoted 1, 2, 3, or 4.  It is guaranteed an answer exists.

Example 1:
Input: N = 3, paths = [[1,2],[2,3],[3,1]]
Output: [1,2,3]

Example 2:
Input: N = 4, paths = [[1,2],[3,4]]
Output: [1,2,1,2]

Example 3:
Input: N = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
Output: [1,2,3,4]

*/

/*

O(n),O(n)

*/

public int[] gardenNoAdj(int N, int[][] paths) {
    Map<Integer, Set<Integer>> adj = new HashMap<>();
    for (int i = 1; i <= N; ++i) {
        adj.put(i, new HashSet<>());
    }
    for (int[] path : paths) {
        int u = path[0], v = path[1];
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    int[] ans = new int[N];
    for (int i = 1; i <= N; ++i) {
        Set<Integer> colors = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        for (int j : adj.get(i)) {
            colors.remove(ans[j - 1]);
        }
        ans[i - 1] = colors.iterator().next();
    }
    return ans;
}



