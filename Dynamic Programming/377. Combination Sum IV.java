
/*

Given an integer array with all positive numbers and no duplicates, 
find the number of possible combinations that add up to a positive integer target.

Example:
nums = [1, 2, 3]
target = 4
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.
Therefore the output is 7.

*/

/*

Solution 1: bottom-up DP
O(nm),O(m)

*/

public int combinationSum4(int[] nums, int target) {
    int[] dp = new int[target + 1];
    dp[0] = 1;
    for (int i = 1; i <= target; ++i) {
        for (int j = 0; j < nums.length; ++j) {
            if (i >= nums[j]) dp[i] += dp[i - nums[j]];
        }
    }
    return dp[target];
}


/*

Solution 2: recursion with memoization
O(nm),O(m)

*/

public int combinationSum4(int[] nums, int target) {
    if (nums.length == 0) return 0;
    int[] memo = new int[target + 1];
    Arrays.fill(memo, -1);
    memo[0] = 1;
    return dfs(memo, nums, target);
}

private int dfs(int[] memo, int[] nums, int target) {
    if (memo[target] != -1) return memo[target];
    int ans = 0;
    for (int num : nums) {
        if (target >= num) ans += dfs(memo, nums, target - num);
    }
    memo[target] = ans;
    return ans;
}




