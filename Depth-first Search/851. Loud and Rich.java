
/*

In a group of N people (labelled 0, 1, 2, ..., N-1), each person has different amounts of money, 
and different levels of quietness.
For convenience, we'll call the person with label x, simply "person x".
We'll say that richer[i] = [x, y] if person x definitely has more money than person y.  
Note that richer may only be a subset of valid observations.
Also, we'll say quiet[x] = q if person x has quietness q.
Now, return answer, where answer[x] = y if y is the least quiet person 
(that is, the person y with the smallest value of quiet[y]), 
among all people who definitely have equal to or more money than person x.

Example 1:
Input: richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]
Output: [5,5,2,5,4,5,6,7]
Explanation: 
answer[0] = 5.
Person 5 has more money than 3, which has more money than 1, which has more money than 0.
The only person who is quieter (has lower quiet[x]) is person 7, but
it isn't clear if they have more money than person 0.
answer[7] = 7.
Among all people that definitely have equal to or more money than person 7
(which could be persons 3, 4, 5, 6, or 7), the person who is the quietest (has lower quiet[x])
is person 7.
The other answers can be filled out with similar reasoning.

*/

/*

Solution: build adjacency list from each element to all the richer elements
          for each element, DFS to find the one with smallest quiet value in its adjacent elements
          note to early terminate for visited elements
O(n),O(n)

*/

public int[] loudAndRich(int[][] richer, int[] quiet) {
    int n = quiet.length;
    List<Integer>[] adj = new ArrayList[n];
    int[] ans = new int[n];
    Arrays.fill(ans, -1);
    for (int i = 0; i < n; ++i) {
        adj[i] = new ArrayList<>();
    }
    for (int[] edge : richer) {
        adj[edge[1]].add(edge[0]);
    }
    for (int i = 0; i < n; ++i) {
        dfs(adj, ans, quiet, i);
    }
    return ans;
}

private int dfs(List<Integer>[] adj, int[] ans, int[] quiet, int i) {
    if (ans[i] >= 0) {
        return ans[i];
    }
    ans[i] = i;
    for (int next : adj[i]) {
        if (quiet[ans[i]] > quiet[dfs(adj, ans, quiet, next)]) {
        ans[i] = ans[next];       
        }
    }
    return ans[i];
}



