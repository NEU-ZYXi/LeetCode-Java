
/*

Given an array of integers nums and a positive integer k, 
find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.

Example 1:
Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.

*/

/*

O(n^n),O(n)

*/

public boolean canPartitionKSubsets(int[] nums, int k) {
    int n = nums.length, sum = 0;
    for (int num : nums) {
        sum += num;
    }
    if (sum % k != 0) {
        return false;
    }
    return dfs(nums, new boolean[n], sum / k, k, 0, 0);
}

private boolean dfs(int[] nums, boolean[] vis, int target, int k, int idx, int sum) {
    if (k == 1) {
        return true;
    }
    if (sum == target) {
        return dfs(nums, vis, target, k - 1, 0, 0);
    }
    for (int i = idx; i < nums.length; ++i) {
        if (!vis[i]) {
            vis[i] = true;
            if (dfs(nums, vis, target, k, i + 1, sum + nums[i])) {
                return true;
            }
            vis[i] = false;
        }
    }
    return false;
}




