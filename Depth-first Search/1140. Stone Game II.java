
/*

Alex and Lee continue their games with piles of stones.  
There are a number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].  
The objective of the game is to end with the most stones. 
Alex and Lee take turns, with Alex starting first.  Initially, M = 1.
On each player's turn, that player can take all the stones in the first X remaining piles, where 1 <= X <= 2M.
Then, we set M = max(M, X).
The game continues until all the stones have been taken.
Assuming Alex and Lee play optimally, return the maximum number of stones Alex can get.

Example 1:
Input: piles = [2,7,9,4,4]
Output: 10
Explanation:  If Alex takes one pile at the beginning, Lee takes two piles, then Alex takes 2 piles again.
Alex can get 2 + 4 + 4 = 10 piles in total.
If Alex takes two piles at the beginning, then Lee can take all three piles left. 
In this case, Alex get 2 + 7 = 9 piles in total. So we return 10 since it's larger. 

*/

/*

Solution: create prefix sums, and for the current user, choose 1<=i<=2*M which get min result for the other user
          so the max result for current user is sums[n]-sums[i]-min which is the sum of a[i...index(min)]
          use memo[i][M] for DFS, which means we get the same position and M is the same as well
O(n^3),O(n^2)

*/

public int stoneGameII(int[] piles) {
    int n = piles.length;
    int[] sums = new int[n + 1];
    int[][] memo = new int[n][2 * n];
    for (int i = 1; i <= n; ++i) {
        sums[i] = sums[i - 1] + piles[i - 1];
    }
    return dfs(piles, sums, memo, 0, 1);
}

private int dfs(int[] piles, int[] sums, int[][] memo, int idx, int M) {
    int n = piles.length, min = Integer.MAX_VALUE;
    if (idx == piles.length) {
        return 0;
    }
    if (n - idx <= 2 * M) {
        return sums[n] - sums[idx];
    }
    if (memo[idx][M] != 0) {
        return memo[idx][M];
    }
    for (int i = 1; i <= 2 * M; ++i) {
        min = Math.min(min, dfs(piles, sums, memo, idx + i, Math.max(M, i)));
    }
    memo[idx][M] = sums[n] - sums[idx] - min;
    return memo[idx][M];
}



