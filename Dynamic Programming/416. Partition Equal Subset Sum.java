
/*

Given a non-empty array containing only positive integers, 
find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
Note:
Each of the array element will not exceed 100.
The array size will not exceed 200.

Example 1:
Input: [1, 5, 11, 5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:
Input: [1, 2, 3, 5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.

*/

/*

Solution 1: knapsack problem for use nums[0...n-1] to form the target sum
O(nm),O(nm) where n is length of nums and m is sum of nums

*/

public boolean canPartition(int[] nums) {
    int n = nums.length, sum = 0;
    for (int num : nums) sum += num;
    if (sum % 2 == 1) return false;
    sum /= 2;
    boolean[][] dp = new boolean[n + 1][sum + 1];
    dp[0][0] = true;
    for (int i = 1; i <= n; ++i) dp[i][0] = true;
    for (int j = 1; j <= sum; ++j) dp[0][j] = false;
    for (int i = 1;i <= n; ++i) {
        for (int j = 1; j <= sum; ++j) {
            if (j >= nums[i - 1]) dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
        }
    }
    return dp[n][sum];
}


/*

Solution 2: recursion to form target sum with nums
O(2^k),O(k) where k is the number of numbers to form the target sum

*/

public boolean canPartition(int[] nums) {
    int n = nums.length, sum = 0;
    for (int num : nums) sum += num;
    if (sum % 2 == 1) return false;
    sum /= 2;
    return dfs(nums, sum, n - 1);
}

private boolean dfs(int[] nums, int target, int start) {
    if (target == 0) return true;
    if (target > 0 && start >= 0) {
        for (int i = start; i >= 0; i--) {
            if (target - nums[i] < 0) break;
            if (dfs(nums, target - nums[i], i - 1)) return true;
        }
    }
    return false;
}




