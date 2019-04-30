
/*

Given an array which consists of non-negative integers and an integer m, 
you can split the array into m non-empty continuous subarrays. 
Write an algorithm to minimize the largest sum among these m subarrays.
Note:
If n is the length of array, assume the following constraints are satisfied:
1 ≤ n ≤ 1000
1 ≤ m ≤ min(50, n)

Examples:
Input:
nums = [7,2,5,10,8]
m = 2
Output:
18
Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.

*/

/*

Solution 1: dp[i][j] means the min of largest sum for nums[0...j] with i splits
            dp[0][j] is initialized as the prefix sum 
            for dp[i][j], to trigger one more split, find the min of max(dp[i-1][k],dp[0][j]-dp[0][k]) for 0<=k<j
            where dp[i-1][k] means the target value for nums[0...k] and dp[0][j]-dp[0][k] means nums[k+1...j] and split at k
O(mn^2),O(nm)            

*/

public int splitArray(int[] nums, int m) {
    int n = nums.length;
    int[][] dp = new int[m][n];
    dp[0][0] = nums[0];
    for (int i = 1; i < n; ++i) dp[0][i] = dp[0][i - 1] + nums[i];
    for (int i = 1; i < m; ++i) {
        for (int j = i; j < n; ++j) {
            int min = Integer.MAX_VALUE;
            for (int k = 0; k < j; ++k) {
                min = Math.min(min, Math.max(dp[i - 1][k], dp[0][j] - dp[0][k]));
            }
            dp[i][j] = min;
        }
    }
    return dp[m - 1][n - 1];
}


/*

Solution 2: binary search in [max,sum], for each target, check if we could generate it or not
            if we could find a value with m splits which is larger or equals to the target, search in the left part
            otherwise, search in the right part
            to check, greedily sum until the current sum is larger than target and split at this position
O(nlog(sum-max)),O(1)            

*/

public int splitArray(int[] nums, int m) {
    int max = 0, sum = 0;
    for (int num : nums) {
        max = Math.max(max, num);
        sum += num;
    }
    if (m == 1) return sum;
    int l = max, r = sum;
    while (l <= r) {
        int mid = (l + r) / 2;
        if (check(nums, mid, m)) r = mid - 1;
        else l = mid + 1;
    }
    return l;
}

private boolean check(int[] nums, int target, int m) {
    int cnt = 1, sum = 0;
    for (int num : nums) {
        sum += num;
        if (sum > target) {
            cnt++;
            sum = num;
            if (cnt > m) return false;
        }
    }
    return true;
}





