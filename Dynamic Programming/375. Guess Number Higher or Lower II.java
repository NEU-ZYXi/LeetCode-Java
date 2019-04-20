
/*

We are playing the Guess Game. The game is as follows:
I pick a number from 1 to n. You have to guess which number I picked.
Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
However, when you guess a particular number x, and you guess wrong, you pay $x. 
You win the game when you guess the number I picked.

Example:
n = 10, I pick 8.
First round:  You guess 5, I tell you that it's higher. You pay $5.
Second round: You guess 7, I tell you that it's higher. You pay $7.
Third round:  You guess 9, I tell you that it's lower. You pay $9.
Game over. 8 is the number I picked.
You end up paying $5 + $7 + $9 = $21.

*/

/*

Solution: dp[i][j]=min(max(dp[i][k-1],dp[k+1][j])+k) for i<=k<=j which means guess k then guess in either left or right part
          set (i+j)/2<=k<=j for optimization, because dp[i][i+len]<=dp[j][j+len] if i<=j and dp[i][i+l1]<=dp[i][i+l2] if l1<=l2
O(n^2),O(n^2)

*/

public int getMoneyAmount(int n) {
    int[][] memo = new int[n + 1][n + 1];
    return dfs(memo, 1, n);
}

private int dfs(int[][] memo, int low, int high) {
    if (low >= high) return 0;
    if (memo[low][high] != 0) return memo[low][high];
    int ans = Integer.MAX_VALUE;
    for (int i = (low + high) / 2; i <= high; ++i) {
        int left = dfs(memo, low, i - 1);
        int right = dfs(memo, i + 1, high);
        ans = Math.min(ans, Math.max(left, right) + i);
    }
    memo[low][high] = ans;
    return ans;
}




