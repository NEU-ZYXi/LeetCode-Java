
/*

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum 
and return its sum.

Example:
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

*/

/*

O(n),O(n)

*/

public int maxSubArray(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];
    dp[0] = nums[0];
    int ans = nums[0];
    for (int i = 1; i < n; ++i) {
        dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
        ans = Math.max(ans, dp[i]);
    }
    return ans;
}


public int maxSubArray(int[] nums) {
    int prev = nums[0], ans = nums[0];
    for (int i = 1; i < nums.length; ++i) {
        prev = prev > 0 ? prev + nums[i] : nums[i];
        ans = Math.max(ans, prev);
    }
    return ans;
}




