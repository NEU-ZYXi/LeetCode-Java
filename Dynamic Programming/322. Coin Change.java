
/*

You are given coins of different denominations and a total amount of money amount. 
Write a function to compute the fewest number of coins that you need to make up that amount. 
If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1

*/

/*

Solution: dp[i][j] means the minimum number for coins[0...i] to get amount j
          for each coin, we could use or not, which means dp[i-1][j] (not use) and dp[i][j-coins[i]]+1
          initialize with a max value, Integer.MAX_VALUE will cause overflow
O(nm),O(nm)

*/

public int coinChange(int[] coins, int amount) {
    int n = coins.length;
    int[][] dp = new int[n + 1][amount + 1];
    for (int j = 1; j <= amount; ++j) dp[0][j] = amount + 1;
    dp[0][0] = 0;
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= amount; ++j) {
            if (j >= coins[i - 1]) dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
            else dp[i][j] = dp[i - 1][j];
        }
    }
    return dp[n][amount] == amount + 1 ? -1 : dp[n][amount];
}


public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;
    for (int i = 0; i < coins.length; ++i) {
        for (int j = 1; j <= amount; ++j) {
            if (j >= coins[i]) dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
        }
    }
    return dp[amount] == amount + 1 ? -1 : dp[amount];
}



