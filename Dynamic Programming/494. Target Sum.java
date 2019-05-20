
/*

You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. 
For each integer, you should choose one from + and - as its new symbol.
Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 
-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
There are 5 ways to assign symbols to make the sum of nums be target 3.

*/

/*

Solution 1: backtrack all combinations of add and minus, memorize the same sum with nums[0...i]
O(2^n),O(n)

*/

public int findTargetSumWays(int[] nums, int S) {
    Map<String, Integer> memo = new HashMap<>();
    return dfs(nums, memo, S, 0, 0);
}

private int dfs(int[] nums, Map<String, Integer> memo, int S, int idx, int sum) {
    String cur = idx + "," + sum;
    if (memo.containsKey(cur)) {
        return memo.get(cur);
    }
    if (idx == nums.length) {
        if (sum == S) {
            return 1;
        } else {
            return 0;
        }
    }
    int add = dfs(nums, memo, S, idx + 1, sum + nums[idx]);
    int minus = dfs(nums, memo, S, idx + 1, sum - nums[idx]);
    int ans = add + minus;
    memo.put(cur, ans);
    return ans;
}


/*

Solution 2: knapsack problem, where we could get -sum to sum possible values, let dp[n+1][2*sum+1] means the sum value
            dp[i][j]=dp[i-1][j+nums[i-1]]+dp[i-1][j-nums[i-1]] which means the add and minus combinations
O(nm),O(nm) where n is the length of nums and m is sum            

*/

public int findTargetSumWays(int[] nums, int S) {
    int sum = 0, n = nums.length;
    for (int num : nums) {
        sum += num;
    }
    if (sum < S || sum < -S) {
        return 0;
    }
    int[][] dp = new int[n + 1][2 * sum + 1];
    dp[0][sum] = 1;
    for (int i = 1; i <= n; ++i) {
        for (int j = 0; j <= 2 * sum; ++j) {
            if (j + nums[i - 1] <= 2 * sum) {
                dp[i][j] = dp[i - 1][j + nums[i - 1]];
            }
            if (j - nums[i - 1] >= 0) {
                dp[i][j] += dp[i - 1][j - nums[i - 1]];
            }
        }
    }
    return dp[n][sum + S];
}




