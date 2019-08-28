
/*

Given an unsorted array of integers, find the number of longest increasing subsequence.

Example 1:
Input: [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].

Example 2:
Input: [2,2,2,2,2]
Output: 5
Explanation: The length of longest continuous increasing subsequence is 1, 
and there are 5 subsequences' length is 1, so output 5.

*/

/*

O(n^2),O(n)

*/

public int findNumberOfLIS(int[] nums) {
    int n = nums.length, max = 1, ans = 0;
    int[] dp = new int[n];
    int[] cnt = new int[n];
    Arrays.fill(dp, 1);
    Arrays.fill(cnt, 1);
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < i; ++j) {
            if (nums[i] > nums[j]) {
                if (dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    cnt[i] = cnt[j];
                } else if (dp[i] == dp[j] + 1) {
                    cnt[i] += cnt[j];
                }
            }
        }
        max = Math.max(max, dp[i]);
    }
    for (int i = 0; i < n; ++i) {
        if (dp[i] == max) {
            ans += cnt[i];
        }
    }
    return ans;
}




